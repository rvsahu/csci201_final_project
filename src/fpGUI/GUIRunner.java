package fpGUI;

import javafx.application.Application;
import javafx.stage.Stage;

import fpGame.GameUtil;

import fpIO.AutoSaver;

public class GUIRunner extends Application {
	private AutoSaver autoSaver;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override public void start(Stage primaryStage) {
    	autoSaver = new AutoSaver(180);
    	GameUtil.setScalingFactor();
    	GameUtil.setStage(primaryStage);
    	LoginScreen.show(primaryStage, autoSaver);
    }
    
    @Override public void stop() {
    	//save the game if a user is logged in
    	autoSaver.interrupt();
    	//call super class stop method
    	try {
    		super.stop();
    	} catch (Exception e) {
    		System.err.println("error calling Application.stop()");
    	}
    }
}