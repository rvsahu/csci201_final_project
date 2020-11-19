package fpGUI;

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
        
        TextField txtf1 = new TextField();
        TextField txtf2 = new TextField();
        
        //TODO add confirm password field
                
        txt1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/3);
        txt1.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -50);
        
        txt2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/2);
        txt2.setTranslateX((GameUtil.WINDOW_X* -GameUtil.scalingFactor())*3/40 -50);
        
        btn1.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/4);
                
        btn2.setTranslateY((GameUtil.WINDOW_Y* -GameUtil.scalingFactor())/8);
        
        txtf1.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/3);
        txtf1.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf1.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf1.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        
        txtf2.setTranslateY((GameUtil.WINDOW_Y* GameUtil.scalingFactor())/2);
        txtf2.setTranslateX((GameUtil.WINDOW_X* GameUtil.scalingFactor())/8);
        txtf2.setPrefWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        txtf2.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
        //txtf2.setMaxWidth(300);
        
        
        
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
        		//TODO add condition for if password and confirm password don't match
        		
        		//TODO add condition for if username already exists in database
        		
        		//TODO move to MainMenu with connection to server if/when registration is successful
        		
        		//if registered successfully call GameUtil.login();
        		
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
        root.getChildren().addAll(btn1,btn2,txt1,txt2,txtf1,txtf2,error);
        StackPane.setAlignment(btn1, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btn2, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(txt1, Pos.TOP_CENTER);
        StackPane.setAlignment(txt2, Pos.TOP_CENTER);
        StackPane.setAlignment(txtf1, Pos.TOP_CENTER);
        StackPane.setAlignment(txtf2, Pos.TOP_CENTER);
        StackPane.setAlignment(error, Pos.TOP_CENTER);
        
        stage.setScene(new Scene(root, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
 		       GameUtil.WINDOW_Y * GameUtil.scalingFactor()));
        stage.setTitle("Register!");
        stage.show();
	}
}
