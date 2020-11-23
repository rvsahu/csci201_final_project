package fpGame;

import javafx.stage.Stage;
import javafx.stage.Screen;

import java.io.FileInputStream;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameUtil {
	public static final int WINDOW_X = 1920;
	public static final int WINDOW_Y = 1080;

	private static boolean registered;
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
	 * A reference to a Text object, useful for telling the player something
	 */
	private static Text message = new Text();
	
	/**
	 * Returns the Text object containing the game's message to the player
	 * 
	 * @return     A Text object with the game's message to the player
	 */
	public static Text message() {
		return message;
	}
	
	/**
	 * Updates message with a given String, which will be displayed in displayPlayerView()
	 * 
	 * @param messageStr     The new message to the user.
	 */
	public static void setMessage(String messageStr) {
		message.setText(messageStr);
	}
	
	/**
	 * Updates message to be blank.
	 */
	public static void clearMessage() {
		message.setText("");
	}
	
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
	 *
	 * */
	public static void registered() {
		registered = true;
	}

	public static boolean isRegistered() {
		return registered;
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
		//clear message to user
		clearMessage();
		//get a pane with room rendered
		BorderPane pane = player.currentRoom().generatePane(stage);
		//TODO add UI elements (inven, save, change perspective arrows, etc)
		pane.setTop(message);
		
		//inventory button
		ImageView inventoryButton = null;
		try {
			Image ibImg; 
			if (needsScaling) {
				ibImg = new Image(new FileInputStream("./graphics/game_graphics/gui/inventory.png"), WINDOW_X * scalingFactor, 
						          WINDOW_Y * scalingFactor, true, true);
			} else {
				ibImg = new Image(new FileInputStream("./graphics/game_graphics/gui/inventory.png"));
			}
			inventoryButton = new ImageView(ibImg);
			inventoryButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					GameUtil.setMessage("Your inventory:\n" + player.getInventory().stringRep());
				}
			});
			pane.getChildren().add(inventoryButton);
		} catch (Exception e) {
			System.err.println("Error loading inventory button!");
		}
		//logbook button
		ImageView logbookButton = null;
		try {
			Image lobImg; 
			if (needsScaling) {
				lobImg = new Image(new FileInputStream("./graphics/game_graphics/gui/log.png"), WINDOW_X * scalingFactor, 
					  	           WINDOW_Y * scalingFactor, true, true);
			} else {
				lobImg = new Image(new FileInputStream("./graphics/game_graphics/gui/log.png"));
			}
			logbookButton = new ImageView(lobImg);
			logbookButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					GameUtil.setMessage("Your logbook:\n" + player.getLogbook().stringRep());
				}
			});
			pane.getChildren().add(logbookButton);
		} catch (Exception e) {
			System.err.println("Error loading logbook button!");
		}
		
		
		//rotate left button
		ImageView leftButton = null;
		try {
			Image lebImg; 
			if (needsScaling) {
				lebImg = new Image(new FileInputStream("./graphics/game_graphics/gui/arrowL.png"), WINDOW_X * scalingFactor, 
					  	           WINDOW_Y * scalingFactor, true, true);
			} else {
				lebImg = new Image(new FileInputStream("./graphics/game_graphics/gui/arrowL.png"));
			}
			leftButton = new ImageView(lebImg);
			leftButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					player.turnLeft();
					displayPlayerView();
				}
			});
			pane.getChildren().add(leftButton);
		} catch (Exception e) {
			System.err.println("Error loading left arrow button!");
		}
		//rotate right button
		ImageView rightButton = null;
		try {
			Image rbImg; 
			if (needsScaling) {
				rbImg = new Image(new FileInputStream("./graphics/game_graphics/gui/arrowR.png"), WINDOW_X * scalingFactor, 
					  	           WINDOW_Y * scalingFactor, true, true);
			} else {
				rbImg = new Image(new FileInputStream("./graphics/game_graphics/gui/arrowR.png"));
			}
			rightButton = new ImageView(rbImg);
			rightButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					player.turnRight();
					displayPlayerView();
				}
			});
			pane.getChildren().add(rightButton);
		} catch (Exception e) {
			System.err.println("Error loading right arrow button!");
		}
		
		/*
		ImageView arrows = null;
		try {
			Image arrws; 
			if (needsScaling) {
				arrws = new Image(new FileInputStream("./graphics/game_graphics/gui/morearrows.png"), WINDOW_X * scalingFactor, 
					  	           WINDOW_Y * scalingFactor, true, true);
			} else {
				arrws = new Image(new FileInputStream("./graphics/game_graphics/gui/morearrows.png"));
			}
			arrows = new ImageView(arrws);
			arrows.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					player.turnRight();
					displayPlayerView();
				}
			});
			pane.getChildren().add(arrows);
		} catch (Exception e) {
			System.err.println("Error loading right arrow button!");
		}
		*/
		
		//create scene and scale the window if need be
		Scene scene;
		if (needsScaling) {
			scene = new Scene(pane, WINDOW_X * scalingFactor, WINDOW_Y * scalingFactor);
		} else {
			scene = new Scene(pane, WINDOW_X, WINDOW_Y);
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
	
	public static void showLoadingScreen() {
		//display loading screen
		BorderPane pane = new BorderPane();
		
		Text text = new Text("Loading...");
		text.setFill(Color.WHITE);
		text.setFont(new Font(30));
		pane.setStyle("-fx-background-color: #000000;");
		
		Scene loadScene;
		if (needsScaling) {
			loadScene = new Scene(pane, WINDOW_X * scalingFactor, WINDOW_Y * scalingFactor);
		} else {
			loadScene = new Scene(pane, WINDOW_X, WINDOW_Y);
		}
		stage.setScene(loadScene);
		stage.show();
	}
}
