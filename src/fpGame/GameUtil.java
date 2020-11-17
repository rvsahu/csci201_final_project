package fpGame;

import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameUtil {
	public static final int WINDOW_X = 1920;
	public static final int WINDOW_Y = 1080;

	/**
	 * The multiplier by which all graphics and window size need to be multiplied by.
	 */
	private static double scalingFactor;
	
	/**
	 * Whether the graphics need to be scaled down for the player or not.
	 */
	private static boolean needsScaling = false;
	
	/**
	 * The current player.
	 */
	private static Player player;
	
	/**
	 * The game map, contains all the Rooms.
	 */
	private static Map map;
	
	/**
	 * The stage/window the graphics output to.
	 */
	private static Stage stage;
	
	/**
	 * A boolean representing whether the game is currently running or not.
	 */
	private static boolean gameRunning = false;
	
	/**
	 * Whether the player is a logged in user or otherwise.
	 */
	private static boolean loggedIn = false;
	
	/**
	 *  Sets whether the player has logged in or not to true.
	 */
	public static void login() {
		loggedIn = true;
	}
	
	/**
	 * Returns whether the user is logged in or not.
	 * 
	 * @return     True if the user is logged in, false otherwise.
	 */
	public static boolean isLoggedIn() {
		return loggedIn;
	}
	
	/**
	 * Sets the state of the game to running.
	 */
	public static void startGame() {
		gameRunning = true;
	}
	
	/**
	 * Sets the state of the game to not running.
	 */
	public static void endGame() {
		gameRunning = false;
	}
	
	/**
	 * Returns whether the game is running or not.
	 * 
	 * @return     True if the game is running, false otherwise.
	 */
	public static boolean gameIsRunning() {
		return gameRunning;
	}
	
	/**
	 * Sets the stage/window the game so it is accessible across the code.
	 * 
	 * @param s  The stage/window the game is running in.
	 */
	public static void setStage(Stage s) {
		stage = s;
	}
	
	/**
	 * Returns the stage/window the game is running in.
	 * 
	 * @return     The stage/window the game is running in.
	 */
	public static Stage stage() {
		return stage;
	}
	
	/**
	 * Sets the Player object of the current game instance, which contains important info like inventory, current Room, etc.
	 * 
	 * @param p     The Player representing the player of the game.
	 */
	public static void setPlayer(Player p) {
		player = p;
	}
	
	/**
	 * Returns the Player object, which contains player info.
	 * 
	 * @return     The Player object, which contains player info.
	 */
	public static Player player() {
		return player;
	}
	
	/**
	 * Sets the Map of the current game instance, which contains public references to all the rooms in the game.
	 * 
	 * @param m  The map of the current game instance.
	 */
	public static void setMap(Map m) {
		map = m;
	}
	
	/**
	 * Returns the Map of all the rooms in the game.
	 * 
	 * @return     The Map of all the rooms in the game.
	 */
	public static Map map() {
		return map;
	}
	
	/**
	 * Manually sets the window scaling factor to a given double.
	 * 
	 * @param sF  The scaling factor for the window.
	 */
	public static void setScalingFactor(double sF) {
		scalingFactor = sF;
	}
	
	/**
	 * Gets the scaling factor for the user.
	 * 
	 * @return     The scaling factor for the game window.
	 */
	public static double scalingFactor() {
		return scalingFactor;
	}
	
	/**
	 * Returns whether the user needs their window and graphics scaled or not.
	 * 
	 * @return     True if the window and graphics need to be scaled (downwards), false otherwise.
	 */
	public static boolean needsScaling() {
		return needsScaling;
	}
	
	/**
	 * Determines and sets the appropriate window scale factor based on the user monitor.
	 */
	public static void setScalingFactor() {
		//natural window size: 1920 x 1080 (the size of all the graphics)
		Rectangle2D screenBounds = Screen.getPrimary().getBounds(); //get screen bounds of player's primary display
		double xRatio = WINDOW_X / screenBounds.getWidth(); //determine ratio of natural window size to player display size widthwise 
		double yRatio = WINDOW_Y / screenBounds.getHeight(); //determine ratio of natural window size to player display size heightwise
		if (xRatio <= 1 && yRatio <= 1) {
			setScalingFactor(1.0); //display is big enough, no need to scale
		} else if (xRatio > 1 && yRatio <= 1) {
			//display width is not large enough, scale downwards
			needsScaling = true;
			double sF = (1.0 / xRatio) * 0.9;
			setScalingFactor(sF);
		} else if (xRatio <= 1 && yRatio > 1) {
			//display height is not large enough, scale downwards
			needsScaling = true;
			double sF = (1.0 / yRatio) * 0.9;
			setScalingFactor(sF);
		} else {
			//xRatio > 1 && yRatio > 1
			//neither display width nor height are large enough, scale downwards using the smaller of the two
			needsScaling = true;
			double sF1 = (1.0 / xRatio) * 0.9;
			double sF2 = (1.0 / yRatio) * 0.9;
			setScalingFactor(Math.min(sF1, sF2));
		}
	}
	
	/**
	 * Gets the current room of the player, generates the current view of that room in a Pane, adds game controls to that elements,
	 * and updates the window once all of that is done.
	 */
	public static void displayPlayerView() {
		//get a pane with room rendered
		Pane pane = player.currentRoom().generateScene(stage);
		//TODO add UI elements (inven, save, change perspective arrows, etc)
		
		//create scene and scale the window if need be
		Scene scene;
		if (needsScaling) {
			scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor, GameUtil.WINDOW_Y * GameUtil.scalingFactor);
		} else {
			scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y);
		}
		//setup key response
		EventHandler<KeyEvent> keyReleasedBehaviour = new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT) {
					player.turnRight();
					displayPlayerView();
				} else if (event.getCode() == KeyCode.LEFT) {
					player.turnLeft();
					displayPlayerView();
				}
			}
		};
		
		scene.setOnKeyReleased(keyReleasedBehaviour);
		
		//set the scene
		stage.setScene(scene);
		//show stage
		stage.show();
	}
}
