package fpGUI;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import fpGame.GameUtil;
import fpIO.AutoSaver;


public class LoginScreen {
	public static void show(Stage stage, AutoSaver autoSaver) {
		//TODO finish this
		
		/*
		 * DIMENSIONS 1920x1080
		 */
		
		
		String username = ""; //stuff
		
		
       
		Button btn1 = new Button();
        btn1.setText("Login");
        
        EventHandler<ActionEvent> b1 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		MainMenu.show(stage, username);
        		System.out.println("Logged In!");
        	}
        };
        
        btn1.setOnAction(b1);
        
        Button btn2 = new Button();
        btn2.setText("Register");
        Button btn3 = new Button();
        btn3.setText("Seppuku");
        
        Text txt = new Text();
        txt.setText("login!");
        
        
        GridPane root = new GridPane();
        root.add(txt, 0, 0);
        root.add(btn1, 0, 1);
        root.add(btn2, 0, 2);
        root.add(btn3, 0, 3);
        
		try {
			Image test = new Image(new FileInputStream("./graphics/test_graphics/test1.jpg"), 
					               1024 * GameUtil.scalingFactor(), 963 * GameUtil.scalingFactor(), true, true);
			ImageView testview = new ImageView(test);
			testview.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent mouseEvent) {
					System.out.println("you just got bonked!");
				}
			});
			root.add(testview, 0, 4);
		} catch (IOException ie) {
			System.err.println("riperino1");
		}
		
		try {
			Image test = new Image(new FileInputStream("./graphics/test_graphics/test2.png"), 
					               800 * GameUtil.scalingFactor(), 923 * GameUtil.scalingFactor(), true, true);
			ImageView testview = new ImageView(test);
			testview.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent mouseEvent) {
					System.out.println("you just got beaned!");
				}
			});
			root.add(testview, 0, 4);
		} catch (IOException ie) {
			System.err.println("riperino2");
		}
		
        stage.setScene(new Scene(root, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
        		       GameUtil.WINDOW_Y * GameUtil.scalingFactor()));
    	stage.setTitle("Login!");
    	stage.show();
	}
}
