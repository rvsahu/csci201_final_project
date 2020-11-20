package fpGUI;

import java.util.HashMap;

import fpGame.GameUtil;
import fpIO.AutoSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register {
	public static void show(Stage stage, AutoSaver autoSaver) {
		
		Text error = new Text();
		error.setFill(Color.RED);
       
		Button btn1 = new Button();
        btn1.setText("Register"); 
        Button btn2 = new Button();
        btn2.setText("Back");
        
        Text txt1 = new Text();
        txt1.setText("Username:");
        Text txt2 = new Text();
        txt2.setText("Password:");
        Text txt3 = new Text();
        txt3.setText("Confirm Password:");
        
        TextField txtf1 = new TextField();
        TextField txtf2 = new TextField();
        TextField txtf3 = new TextField();
        
        //TODO add confirm password field
                
        txt1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/6);
        txt1.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -50);
        txt1.setFont(new Font(20));
        
        txt2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/3);
        txt2.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -50);
        txt2.setFont(new Font(20));
        
        txt3.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/2);
        txt3.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -70);
        txt3.setFont(new Font(20));
        
        btn1.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/4);
        btn1.setFont(new Font(15));
                
        btn2.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        btn2.setFont(new Font(15));
        
        txtf1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/6);
        txtf1.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf1.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf1.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        
        txtf2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/3);
        txtf2.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf2.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf2.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        //txtf2.setMaxWidth(300);
        
        txtf3.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/2);
        txtf3.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf3.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf3.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        
        
        
        HashMap<String,String> usermap = new HashMap<String,String>();
        usermap.put("Mickey", "password1");
        usermap.put("Hunter", "123123");
        
        
        
        EventHandler<ActionEvent> b1 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		String userName = txtf1.getText();
        		String passWord = txtf2.getText();
        		String confirmPassword = txtf3.getText();
        		
        		if(userName.equals("")) {
        			error.setText("No Username!");
        	        return;
        		}
        		if(passWord.equals("")) {
        			error.setText("No Password!");
        			return;
        		}
        		
        		if(usermap.get(userName) != null) {
        			error.setText("This Username is already taken.");
        			return;
        		}
        		
        		if(!confirmPassword.equals(passWord)) {
        			error.setText("The Password does not match the Confirmed Password field.");
        			return;
        		}
        		
        		
        		
        		
        		usermap.put(userName, passWord);
        		GameUtil.login();
        		
        		MainMenu.show(stage, userName, autoSaver); //pass autoSaver here
        	}
        };
        
        
        EventHandler<ActionEvent> b2 = new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent event) {
        		LoginScreen.show(stage, autoSaver);
        	}
        };
        
        
        btn1.setOnAction(b1);
        btn2.setOnAction(b2);
        
        
        
        StackPane root = new StackPane();
        root.getChildren().addAll(btn1,btn2,txt1,txt2,txt3,txtf1,txtf2,txtf3,error);
        StackPane.setAlignment(btn1, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btn2, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(txt1, Pos.TOP_CENTER);
        StackPane.setAlignment(txt2, Pos.TOP_CENTER);
        StackPane.setAlignment(txt3, Pos.TOP_CENTER);
        StackPane.setAlignment(txtf1, Pos.TOP_CENTER);
        StackPane.setAlignment(txtf2, Pos.TOP_CENTER);
        StackPane.setAlignment(txtf3, Pos.TOP_CENTER);
        StackPane.setAlignment(error, Pos.TOP_CENTER);
        
        root.setStyle("-fx-background-color: #990000");
        
        stage.setScene(new Scene(root, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
 		       GameUtil.WINDOW_Y * GameUtil.scalingFactor()));
        stage.setTitle("Register!");
        stage.show();
	}
}
