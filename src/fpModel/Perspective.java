package fpModel;

//java imports
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;

//javafx imports
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//package imports
import fpGame.GameUtil;

public class Perspective {
	/**
	 * An enumeration of all the possible directions a perspective can be viewing
	 */
	public static enum Direction {
		FRONT, BACK, RIGHT, LEFT;
	}
	
	/*
	 *  Graphic Fields 
	 */
	
	/**
	 * Contains file paths to the non-interactable parts of each layer of the perspective
	 */
	private String[] layerPaths;
	
	/**
	 * Contains file paths to the non-interactable parts of each layer of the perspective when unlit (if possible)
	 */
	private String[] unlitLayerPaths;
	
	/*
	 **
	 * Filepath to the background image for this perspective
	 *
	private String backgroundPath;
	
	 **
	 * Filepath to the background image with the lights out for this perspective
	 * (Not every perspective has or needs this)
	 *
	private String lightsOutBackgroundPath;
	*/
	
	/**
	 * The maximum number of layers the given perspective has
	 */
	private int maxLayers;
	
	//private transient Behaviour b;
	
	/*
	 *  Model Fields 
	 */
	
	/**
	 *  The name of the perspective, should be a unique string, used to check equality
	 */
	private String name;
	
	/**
	 *  The room the perspective is in. For example, if the perspective is annex-left, the room is annex.
	 */
	private transient Room containingRoom;
	
	/**
	 *  A list of RoomObjects representing the contents of the room viewable from this perspective
	 */
	private List<RoomObject> contents;
	
	/**
	 * The direction the perspective is facing.
	 */
	private Direction direction;
	
	/**
	 * Whether the lights are off for the current perspective or not.
	 */
	private boolean lightsOff;
	
	/*
	 * Constructor(s)
	 */
	
	/**
	 * 
	 * @param containingRoom  The room containing the perspective
	 * @param name  The name of the perspective
	 * @param direction  The direction the perspective is facing
	 */
	public Perspective(Room containingRoom, String name, Direction direction) {
		this.containingRoom = containingRoom;
		this.name = name;
		this.direction = direction;
		contents = new ArrayList<RoomObject>();
	}
	
	/*
	 * Model methods
	 */
	
	/**
	 * A setup method, adds a RoomObject to the perspective
	 * 
	 * @param rObj  The RoomObject to be added
	 */
	public void addRoomObject(RoomObject rObj) {
		contents.add(rObj);
	}
	
	/**
	 * Returns the room containing this perspective
	 * 
	 * @return     The room containing this perspective
	 */
	public Room containingRoom() {
		return containingRoom;
	}
	
	/**
	 * Sets/updates the Room containing this Perspective. Should only be used during deserialisation.
	 * 
	 * @param containingRoom  The Room containing this Perspective.
	 */
	public void setContainingRoom(Room containingRoom) {
		this.containingRoom = containingRoom;
	}
	
	
	public boolean equals(Perspective other) {
		return name.equals(other.name());
	}
	
	public String name() {
		return this.name;
	}
	
	/*
	 * Graphic Methods
	 */
	
	/**
	 * Generates a Pane (ignore the misnomer please) for the current Perspective.
	 * 
	 * @param stage  The stage/window the game is running in.
	 * @return a Scene for the given Perspective to be displayed
	 */
	public BorderPane generatePane(Stage stage) {
		BorderPane pane = new BorderPane();
		
		for (int i = 0; i < maxLayers; i += 1) {
			displayLayer(i, pane);
		}
		
		return pane;
	}
	
	private void displayLayer(int layer, Pane pane) {
		//display background of the layer first
		Image backIMG = null;
		if (lightsOff == true && unlitLayerPaths[layer] != null) {
			try {
				if (GameUtil.needsScaling()) {
					backIMG = new Image(new FileInputStream(unlitLayerPaths[layer]), GameUtil.WINDOW_X * GameUtil.scalingFactor(),
							            GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					backIMG = new Image(new FileInputStream(unlitLayerPaths[layer]));
				}
			} catch (Exception e) {
				System.err.println("Error loading unlit layer (" + layer + ") background image for " + name);
				e.printStackTrace();
			}
		} else {
			try {
				if (GameUtil.needsScaling()) { 
					backIMG = new Image(new FileInputStream(layerPaths[layer]), GameUtil.WINDOW_X * GameUtil.scalingFactor(),
							            GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					backIMG = new Image(new FileInputStream(layerPaths[layer]));
				}
			} catch (Exception e) {
				System.err.println("Error loading layer (" + layer + ") background image for " + name);
				e.printStackTrace();
			}
		}
		
		if (backIMG != null) {
			ImageView layerBackground = new ImageView(backIMG);
			pane.getChildren().add(layerBackground);
		} else {
			System.err.println("Error displaying background image for " + name);
		}
		//display interactables on top of layer background
		for (RoomObject rObj : contents) {
			if (direction == Perspective.Direction.FRONT) {
				if (rObj.getLayerFront() != layer) {
					continue;
				}
				ImageView iv = rObj.showFront();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else if (direction == Perspective.Direction.RIGHT) {
				if (rObj.getLayerRight() != layer) {
					continue;
				}
				ImageView iv = rObj.showRight();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else if (direction == Perspective.Direction.BACK) {
				if (rObj.getLayerBack() != layer) {
					continue;
				}
				ImageView iv = rObj.showBack();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else {
				//direction == Perspective.Direction.LEFT
				if (rObj.getLayerLeft() != layer) {
					continue;
				}
				ImageView iv = rObj.showLeft();
				//iv.scale(scalingFactor)
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			}
		}
	}
	
	/**
	 * Setup method, primarily for deserialisation. Reloads the sprites for every RoomObject viewable
	 * from this perspective.
	 */
	public void loadAllSprites() {
		for (RoomObject rObj : contents) {
			rObj.loadSprites();
		}
	}
	
	/**
	 * Turns lights on if off and off if on.
	 */
	public void flipLights() {
		lightsOff = !(lightsOff);
	}
	
	/**
	 * Sets the maximum number of layers for the given perspective
	 * 
	 * @param maxLayers  The maximum number of layers for this perspective
	 */
	public void setMaxLayers(int maxLayers) {
		this.maxLayers = maxLayers;
	}
	
	/**
	 * Sets the file paths of the background images of each layer.
	 * 
	 * @param layerPaths  The layer file paths as an array of Strings from back to front.
	 */
	public void setLayerPaths(String[] layerPaths) {
		this.layerPaths = layerPaths;
		setMaxLayers(layerPaths.length);
	}
	
	/**
	 * Sets the file paths of the unlit background images of each layer.
	 * 
	 * @param unlitLayerPaths  The layer file paths as an array of Strings from back to front.
	 */
	public void setUnlitLayerPaths(String[] unlitLayerPaths) {
		this.unlitLayerPaths = unlitLayerPaths;
	}
}
