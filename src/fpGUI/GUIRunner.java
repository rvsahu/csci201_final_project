package fpGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import fpGame.GameInfo;

public class GUIRunner extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	GameInfo.setStage(primaryStage);
    	Login.show(primaryStage);
    	//TestRoom.show(primaryStage);
    }
}