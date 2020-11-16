package fpGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import fpGame.GameUtil;
import fpGame.Player;

public class GUIRunner extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	GameUtil.setScalingFactor();
    	GameUtil.setStage(primaryStage);
    	LoginScreen.show(primaryStage);
    }
}