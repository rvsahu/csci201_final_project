package fpGUI;

import fpGame.GameUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import fpGame.GameUtil;
import fpGame.Player;
import fpGame.Setup;
import fpGame.Map;

public class MainMenu {
	public static void show(Stage stage, String name) {
		
		/*
		 * DIMENSIONS 1920x1080
		 */
		
		
		StackPane root = new StackPane();
		Text txt = new Text();
		Text txt1 = new Text();
        txt.setText("Hello, " + name+"!");
        txt1.setText("Welcome Back!");
        txt.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor)/5);
        txt1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor)/4);
        
        StackPane.setAlignment(txt, Pos.TOP_CENTER);
        StackPane.setAlignment(txt1, Pos.TOP_CENTER);
        
        Button btn1 = new Button();
        btn1.setText("Resume Gameplay");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	MainMenu.show(stage, "This would be Resume Game");
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Start New Game");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	Player player = new Player();
            	GameUtil.setPlayer(player);
            	Map map = Setup.setupAll();
            	MainMenu.show(stage, "this would be new game");
            }
        });
        
        root.getChildren().addAll(txt,txt1, btn1, btn2);
        StackPane.setAlignment(btn1, Pos.CENTER);
        StackPane.setAlignment(btn2, Pos.CENTER);
        btn2.setTranslateY(50);

        
        stage.setScene(new Scene(root, GameUtil.WINDOW_X* GameUtil.scalingFactor, GameUtil.WINDOW_Y* GameUtil.scalingFactor));
    	stage.setTitle("Main Menu!");
    	stage.show();
	}
}
