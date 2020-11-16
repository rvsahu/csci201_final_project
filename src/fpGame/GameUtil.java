package fpGame;

import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class GameUtil {
	public static final int WINDOW_X = 1920;
	public static final int WINDOW_Y = 1080;
	//something to consider: 1920x1080 is quite a large resolution. maybe a scale factor needed?
	public static double scalingFactor;
	public static boolean needsScaling;
	
	private static Player player;
	private static Stage stage;
	private static Map map;
	
	public static void setStage(Stage s) {
		stage = s;
	}
	
	public static Stage stage() {
		return stage;
	}
	
	public static void setPlayer(Player p) {
		player = p;
	}
	
	public static Player player() {
		return player;
	}
	
	public static void setMap(Map m) {
		map = m;
	}
	
	public static Map map() {
		return map;
	}
	
	public static void setScalingFactor(double sF) {
		scalingFactor = sF;
	}
	
	public static void setScalingFactor() {
		needsScaling = false;
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		double screenX = screenBounds.getWidth();
		double screenY = screenBounds.getHeight();
		double xRatio = WINDOW_X / screenX;
		double yRatio = WINDOW_Y / screenY;
		/* debug print
		System.out.println("screen x: " + screenX);
		System.out.println("screen y: " + screenY);
		System.out.println("x ratio: " + xRatio);
		System.out.println("y ratio: " + yRatio);
		*/
		if (xRatio <= 1 && yRatio <= 1) {
			setScalingFactor(1.0);
		} else if (xRatio > 1 && yRatio <= 1) {
			needsScaling = true;
			double sF = (1.0 / xRatio) * 0.9;
			setScalingFactor(sF);
		} else if (xRatio <= 1 && yRatio > 1) {
			needsScaling = true;
			double sF = (1.0 / yRatio) * 0.9;
			setScalingFactor(sF);
		} else {
			//xRatio > 1 && yRatio > 1
			needsScaling = true;
			double sF1 = (1.0 / xRatio) * 0.9;
			double sF2 = (1.0 / yRatio) * 0.9;
			setScalingFactor(Math.min(sF1, sF2));
		}
	}
}
