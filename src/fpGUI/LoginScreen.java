package fpGUI;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import java.util.HashMap;
import javafx.scene.text.Font;


import fpGame.GameUtil;
import fpIO.AutoSaver;


public class LoginScreen {
	public static void show(Stage stage, AutoSaver autoSaver) {
		//TODO finish this
		
		/*
		 * DIMENSIONS 1920x1080
		 */
		
		
		String username = ""; //stuff
		
		Text error = new Text();
		error.setFill(Color.RED);
       
		Button btn1 = new Button();
        btn1.setText("Sign In"); 
        Button btn2 = new Button();
        btn2.setText("New User Signup");
        Button btn3 = new Button();
        btn3.setText("Guest Play");
        
        Text txt1 = new Text();
        txt1.setText("Username:");
        Text txt2 = new Text();
        txt2.setText("Password:");
        
        TextField txtf1 = new TextField();
        TextField txtf2 = new TextField();
        
        
        txt1.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/10);
        txt1.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -60);
        txt1.setFont(new Font(20));
        
        txt2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/10);
        txt2.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -60);
        txt2.setFont(new Font(20));

        
        btn1.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/4);
        btn1.setFont(new Font(15));
        
        //btn2.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        //btn2.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())/10);
        
        btn2.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        btn2.setTranslateX(-100);
        btn2.setFont(new Font(15));
        
        //btn3.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        //btn3.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/10);
        
        btn3.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        btn3.setTranslateX(100);
        btn3.setFont(new Font(15));
        
        txtf1.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/10);
        txtf1.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf1.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf1.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        
        txtf2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/10);
        txtf2.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf2.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf2.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        //txtf2.setMaxWidth(300);
        
        HashMap<String,String> usermap = new HashMap<String,String>();
        usermap.put("Mickey", "password1");
        usermap.put("Hunter", "123123");
        
        
        
        EventHandler<ActionEvent> b1 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		String userName = txtf1.getText();
        		String passWord = txtf2.getText();
        		
        		if(userName.equals("")) {
        			error.setText("No Username!");
        	        return;
        		}
        		if(passWord.equals("")) {
        			error.setText("No Password!");
        			return;
        		}
        		String actualPassword = usermap.get(userName); 
        		if(actualPassword == null) {
        			error.setText("Username not found!");
        	        return;
        		}else if(actualPassword.equals(passWord)) {
        			GameUtil.login();
        			MainMenu.show(stage, userName, autoSaver);
            		System.out.println("Logged In!");
        		}else {
        			error.setText("Password is incorrect!");
        	        return;
        		}
        		
        		
        	}
        };
        
        
        EventHandler<ActionEvent> b2 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		Register.show(stage, autoSaver);
        	}
        };
        
        
        EventHandler<ActionEvent> b3 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		MainMenu.show(stage, "Guest", autoSaver);
        	}
        };
        
        btn1.setOnAction(b1);
        btn2.setOnAction(b2);
        btn3.setOnAction(b3);
        
        
        StackPane root = new StackPane();
        root.getChildren().addAll(btn1,btn2,btn3,txt1,txt2,txtf1,txtf2,error);
        StackPane.setAlignment(btn1, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btn2, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btn3, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(txt1, Pos.CENTER);
        StackPane.setAlignment(txt2, Pos.CENTER);
        StackPane.setAlignment(txtf1, Pos.CENTER);
        StackPane.setAlignment(txtf2, Pos.CENTER);
        StackPane.setAlignment(error, Pos.TOP_CENTER);
        
        root.setStyle("-fx-background-color: #990000");
        
        /*
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
		*/
        stage.setScene(new Scene(root, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
        		       GameUtil.WINDOW_Y * GameUtil.scalingFactor()));
    	stage.setTitle("Login!");
    	stage.show();
	}
}
