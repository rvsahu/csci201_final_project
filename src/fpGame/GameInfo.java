package fpGame;

import javafx.stage.Stage;

public class GameInfo {
	public static final int WINDOW_X = 1920;
	public static final int WINDOW_Y = 1080;
	//something to consider: 1920x1080 is quite a large resolution. maybe a scale factor needed?
	
	public static Stage stage;
	
	public static void setStage(Stage s) {
		stage = s;
	}
}
