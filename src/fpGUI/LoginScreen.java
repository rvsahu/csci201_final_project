package fpGUI;

import fpIO.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Font;


import fpGame.GameUtil;
import fpIO.AutoSaver;


public class LoginScreen {

	public static void show(Stage stage, AutoSaver autoSaver) {
		Text error = new Text();
		error.setFill(Color.YELLOW);
       
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
        TextField txtf2 = new PasswordField();
        
        
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
        

        
        
        
        EventHandler<ActionEvent> b1 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		String userName = txtf1.getText();
        		String passWord = txtf2.getText();

        		
        		if(userName.equals("")) {
        			error.setText("Please enter your username");
        	        return;
        		}
        		if(passWord.equals("")) {
        			error.setText("Please enter your password.");
        			return;
        		}
        		if (passWord.length() < 8 || passWord.length() > 32) {
                    error.setText("Please enter your password (greater than 8 characters and less than 32.");

        		}
        		else {
                    User user = new User(userName, passWord);
        		    GUIRunner.token = GUIRunner.client.logIn(user);
        		    autoSaver.updateToken(GUIRunner.token);
        		    if (GUIRunner.token.length() < 5) {
        		        error.setText("Error: token invalid");
        		        return;
                    }
        		    else if (GUIRunner.token.startsWith("Error")) {
                        error.setText(GUIRunner.token);
                        return;
                    }
        		    else {
                        GameUtil.login();
                        MainMenu.show(stage, userName, autoSaver);
                        System.out.println("Logged In!");
                    }

                }
        		/*else if(actualPassword.equals(passWord)) {
        			GameUtil.login();
        			MainMenu.show(stage, userName, autoSaver);
            		System.out.println("Logged In!");
        		}else {
        			error.setText("Password is incorrect!");
        	        return;
        		}*/
        		
        		
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
        
        stage.setScene(new Scene(root, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
        		       GameUtil.WINDOW_Y * GameUtil.scalingFactor()));
    	stage.setTitle("Login!");
    	stage.show();
	}
}
