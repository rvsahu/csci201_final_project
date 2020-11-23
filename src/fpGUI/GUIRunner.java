package fpGUI;

import fpIO.USCGameClient;
import javafx.application.Application;
import javafx.stage.Stage;

import fpGame.GameUtil;

import fpIO.AutoSaver;
import fpIO.Saver;

public class GUIRunner extends Application {
	private AutoSaver autoSaver;
	public static USCGameClient client = new USCGameClient();
	public static String token = "";
	
    public static void GUImain(String[] args) {
        launch(args);
    }
    
    @Override public void start(Stage primaryStage) {
    	autoSaver = new AutoSaver(180, token, client);

    	GameUtil.setScalingFactor();
    	GameUtil.setStage(primaryStage);
    	LoginScreen.show(primaryStage, autoSaver);
    }
    
    @Override public void stop() {
    	//save the game if a user is logged in
    	GameUtil.endGame();
    	if (GameUtil.isLoggedIn()) {
    		autoSaver.interrupt();
    		Saver.save(token, client);
    	}
    	//call super class stop method
    	try {
    		super.stop();
    	} catch (Exception e) {
    		System.err.println("error calling Application.stop()");
    	}
    }
}