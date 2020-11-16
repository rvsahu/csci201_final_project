package fpModel;

//java imports
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;

//javafx imports
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
	 *  A list of Doorways representing the exits from this room to another viewable from this perspective
	 */
	private List<Doorway> exits;
	
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
	
	public Perspective(Room containingRoom, String name, Direction direction) {
		this.containingRoom = containingRoom;
		this.name = name;
		this.direction = direction;
		contents = new ArrayList<RoomObject>();
		exits = new ArrayList<Doorway>();
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
	 * A setup method, adds a Doorway (to another Room) to the perspective
	 * 
	 * @param exit  The Doorway to be added
	 */
	public void addExit(Doorway exit) {
		exit.addEndPerspective(this);
		exits.add(exit);
	}
	
	/**
	 * A setup/deserialisation method, resets every Doorway to make sure 
	 * they maintain room connections. Must be called on every Perspective.
	 * Lock state is serialised so this will not effect that.
	 */
	public void resetExits() {
		for (Doorway d: exits) {
			d.addEndPerspective(this);
		}
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
	 * @param containingRoom
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
	 * 
	 * @return a Scene for the given Perspective to be displayed
	 */
	public void generateScene(Stage stage) {
		System.out.println("enter generate scene"); //debug
		Pane pane = new Pane();
		
		for (int i = 0; i < maxLayers; i += 1) {
			System.out.println("enter for loop"); //debug
			displayLayer(i, pane);
		}
		
		/*
		Image backIMG = null;
		if (lightsOff == true && lightsOutBackgroundPath != null) {
			try {
				if (GameInfo.needsScaling) {
					backIMG = new Image(new FileInputStream(lightsOutBackgroundPath), GameInfo.WINDOW_X * GameInfo.scalingFactor,
							            GameInfo.WINDOW_Y * GameInfo.scalingFactor, true, true);
				} else {
					backIMG = new Image(new FileInputStream(lightsOutBackgroundPath));
				}
			} catch (Exception e) {
				System.err.println("Error loading unlit background image for " + name);
			}
		} else {
			try {
				if (GameInfo.needsScaling) {
					backIMG = new Image(new FileInputStream(backgroundPath), GameInfo.WINDOW_X * GameInfo.scalingFactor,
							            GameInfo.WINDOW_Y * GameInfo.scalingFactor, true, true);
				} else {
					backIMG = new Image(new FileInputStream(backgroundPath));
				}
			} catch (Exception e) {
				System.err.println("Error loading background image for " + name);
			}
		}
		
		if (backIMG != null) {
			ImageView background = new ImageView(backIMG);
			background.toBack();
			pane.getChildren().add(background);
		} else {
			System.err.println("Error displaying background image for " + name);
		}
		
		for (RoomObject rObj : contents) {
			if (direction == Perspective.Direction.FRONT) {
				ImageView iv = rObj.showFront();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else if (direction == Perspective.Direction.RIGHT) {
				ImageView iv = rObj.showRight();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else if (direction == Perspective.Direction.BACK) {
				ImageView iv = rObj.showBack();
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			} else {
				//direction == Perspective.Direction.LEFT
				ImageView iv = rObj.showLeft();
				//iv.scale(scalingFactor)
				if (iv != null) {
					pane.getChildren().add(iv);
				}
			}
		}
		*/
		
		if (GameUtil.needsScaling) {
			System.out.println("setting scene with scaling");
			stage.setScene(new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor, GameUtil.WINDOW_Y * GameUtil.scalingFactor));
		} else {
			System.out.println("setting scene without scaling");
			stage.setScene(new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y));
		}
		stage.show();
	}
	
	private void displayLayer(int layer, Pane pane) {
		//display background of the layer first
		Image backIMG = null;
		if (lightsOff == true && unlitLayerPaths[layer] != null) {
			System.out.println("lights off");
			System.out.println(unlitLayerPaths[layer]);
			try {
				if (GameUtil.needsScaling) {
					backIMG = new Image(new FileInputStream(unlitLayerPaths[layer]), GameUtil.WINDOW_X * GameUtil.scalingFactor,
							            GameUtil.WINDOW_Y * GameUtil.scalingFactor, true, true);
				} else {
					backIMG = new Image(new FileInputStream(unlitLayerPaths[layer]));
				}
			} catch (Exception e) {
				System.err.println("Error loading unlit layer (" + layer + ") background image for " + name);
			}
		} else {
			System.out.println("lights on");
			System.out.println(layerPaths[layer]);
			try {
				if (GameUtil.needsScaling) { 
					System.out.println("test scale"); //debug
					backIMG = new Image(new FileInputStream(layerPaths[layer]), GameUtil.WINDOW_X * GameUtil.scalingFactor,
							            GameUtil.WINDOW_Y * GameUtil.scalingFactor, true, true);
				} else {
					System.out.println("test no scale"); //debug
					backIMG = new Image(new FileInputStream(layerPaths[layer]));
				}
			} catch (Exception e) {
				System.err.println("Error loading layer (" + layer + ") background image for " + name);
			}
		}
		
		if (backIMG != null) {
			System.out.println("creating ImageView for layer " + layer + " background"); //debug
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
	
	/*
	 **
	 * Setup method, adds the file path for the background image
	 * 
	 * @param backgroundPath  The file path to the image of the background for this perspective
	 *
	public void setBackground(String backgroundPath) {
		this.backgroundPath = backgroundPath;
	}
	
	 **
	 * Setup method, adds the file path for the background image with the lights out
	 * 
	 * @param lightsOutBackgroundPath  The file path to the image of the unlit background for this perspective
	 *
	public void setUnlitBackground(String lightsOutBackgroundPath) {
		this.lightsOutBackgroundPath = lightsOutBackgroundPath;
	}
	*/
	
	/**
	 * Setup method, primarily for deserialisation. Reloads the sprites for every RoomObject viewable
	 * from this perspective.
	 */
	public void loadAllImages() {
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
	 * @param layerPaths  The layer file paths as an array of Strings from back to front.
	 */
	public void setUnlitLayerPaths(String[] unlitLayerPaths) {
		this.unlitLayerPaths = unlitLayerPaths;
	}
}
