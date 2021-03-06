package fpGUI;

import fpGame.GameUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import fpGame.Player;
import fpGame.Setup;
import fpIO.AutoSaver;
import fpIO.Loader;

public class MainMenu {
	public static void show(Stage stage, String name, AutoSaver autoSaver) { //add autosaver parameter
		
		/*
		 * DIMENSIONS 1920x1080
		 */
		
		
		StackPane root = new StackPane();
		Text txt = new Text();
		Text txt1 = new Text();
        txt.setText("Hello, " + name+"!");
        txt1.setText("Welcome Back to USCape!");
        txt.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/5);
        txt1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/4);
        txt1.setFont(new Font(20));
        txt.setFont(new Font(20));
        
        StackPane.setAlignment(txt, Pos.TOP_CENTER);
        StackPane.setAlignment(txt1, Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #990000");
        
        Text error = new Text();
		error.setFill(Color.YELLOW);
        
        Button btn1 = new Button();
        btn1.setText("Resume Gameplay");
        btn1.setFont(new Font(15));
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
            	//if so call below and also start AutoSaver thread
            		autoSaver.run();
            		try {
            		    Loader.load(GUIRunner.token, GUIRunner.client);
                    }
            		catch (Exception ignored) {
                    }
            	//if not display error message 
            }
        });
        if(!GameUtil.isLoggedIn() || GameUtil.isRegistered()) {
            btn1.setVisible(false);
            txt1.setText("Welcome to USCape!");
        }
        
        Button btn2 = new Button();
        btn2.setText("Start New Game");
        txt1.setFont(new Font(15));
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	Player player = new Player();
            	GameUtil.setPlayer(player);
            	if(GameUtil.isLoggedIn()) {
            		autoSaver.run();
            	}
            	GameUtil.showLoadingScreen();
            	Setup.setupAll();
            }
        });
        
        root.getChildren().addAll(txt,txt1, btn1, btn2);
        StackPane.setAlignment(btn1, Pos.CENTER);
        StackPane.setAlignment(btn2, Pos.CENTER);
        StackPane.setAlignment(error, Pos.TOP_CENTER);
        btn2.setTranslateY(50);

        
        stage.setScene(new Scene(root, GameUtil.WINDOW_X* GameUtil.scalingFactor(), 
        		                 GameUtil.WINDOW_Y* GameUtil.scalingFactor()));
    	stage.setTitle("Main Menu!");
    	stage.show();
	}
}
