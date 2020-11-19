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
	 *  A list of RoomObjects representing the contents of the room viewable from this perspective. This is transient to guarantee
	 *  RoomObject subclasses get serialised properly, by having their own dedicated container, but they get re-added to and used by
	 *  this list upon deserialisation.
	 */
	private transient List<RoomObject> contents;
	
	/**
	 * A list of GenericObjects. Serves as a dedicated container for GenericObjects such that they serialise properly, but not 
	 * used by the game save during deserialisation.
	 */
	private List<GenericObject> generics;
	
	/**
	 * A list of DoorObjects. Serves as a dedicated container for DoorObjects such that they serialise properly, but not 
	 * used by the game save during deserialisation.
	 */
	private List<DoorObject> doors;
	
	/**
	 * A list of WrapperObjects. Serves as a dedicated container for WrapperObjects such that they serialise properly, but not 
	 * used by the game save during deserialisation.
	 */
	private List<WrapperObject> wrappers;
	
	/**
	 * A list of ContainerObjects. Serves as a dedicated container for ContainerObjects such that they serialise properly, but not 
	 * used by the game save during deserialisation.
	 */
	private List<ContainerObject> containers;
	
	/**
	 * A list of InfoObjects. Serves as a dedicated container for InfoObjects such that they serialise properly, but not 
	 * used by the game save during deserialisation.
	 */
	private List<InfoObject> infos;
	
	/**
	 * A list of RoomObject names (Strings) in the order they were added to the Perspective. Used for deserialisation.
	 */
	private List<String> additionLog;
	
	/**
	 * The direction the perspective is facing.
	 */
	private transient Direction direction;
	
	/**
	 * The number representation the perspective is facing
	 */
	private int directionInd;
	
	/**
	 * Whether the lights are off for the current perspective or not.
	 */
	private boolean lightsOff;
	
	/*
	 * Constructor(s)
	 */
	
	/**
	 * Constructor for a Perspective, called within Room
	 * 
	 * @param containingRoom  The room containing the perspective
	 * @param name  The name of the perspective
	 * @param direction  The direction the perspective is facing
	 */
	public Perspective(Room containingRoom, String name, Direction direction) {
		this.containingRoom = containingRoom;
		this.name = name;
		this.direction = direction;
		setDirectionInd();
		//list initialisation
		contents = new ArrayList<RoomObject>();
		additionLog = new ArrayList<String>();
		generics = new ArrayList<GenericObject>();
		doors = new ArrayList<DoorObject>();
		wrappers = new ArrayList<WrapperObject>();
		containers = new ArrayList<ContainerObject>();
		infos = new ArrayList<InfoObject>();
	}
	
	/*
	 * Model methods
	 */
	
	/**
	 * A setup helper method, adds a RoomObject to the contents list and its name to the additionLog.
	 * 
	 * @param rObj  The RoomObject to be added
	 */
	private void addRoomObject(RoomObject rObj) {
		contents.add(rObj);
		additionLog.add(rObj.name());
	}
	
	/**
	 * A setup method, adds a GenericObject to the Perspective.
	 * 
	 * @param gObj  The GenericObject to be added
	 */
	public void addGenericObject(GenericObject gObj) {
		generics.add(gObj);
		addRoomObject(gObj);
	}
	
	/**
	 * A setup method, adds a ContainerObject to the Perspective.
	 * 
	 * @param cObj  The ContainerObject to be added
	 */
	public void addContainerObject(ContainerObject cObj) {
		containers.add(cObj);
		addRoomObject(cObj);
	}
	
	/**
	 * A setup method, adds a DoorObject to the Perspective.
	 * 
	 * @param dObj  The DoorObject to be added
	 */
	public void addDoorObject(DoorObject dObj) {
		doors.add(dObj);
		addRoomObject(dObj);
	}
	
	/**
	 * A setup method, adds a WrapperObject to the Perspective.
	 * 
	 * @param wObj  The WrapperObject to be added
	 */
	public void addWrapperObject(WrapperObject wObj) {
		wrappers.add(wObj);
		addRoomObject(wObj);
	}
	
	/**
	 * A setup method, adds a InfoObject to the Perspective.
	 * 
	 * @param iObj  The InfoObject to be added
	 */
	public void addInfoObject(InfoObject iObj) {
		infos.add(iObj);
		addRoomObject(iObj);
	}
	
	/**
	 * A deserialisation method, takes the five specific RoomObject child containers and additionLog and rebuilds the contents list.
	 */
	public void rebuildContentsList() {
		//reinitialise contents
		contents = new ArrayList<RoomObject>();
		//use additionLog to chronologically add things back in their original order
		for (String objectName : additionLog) {
			if (isInList(generics, objectName)) {
				continue;
			}
			if (isInList(doors, objectName)) {
				continue;
			}
			if (isInList(wrappers, objectName)) {
				continue;
			}
			if (isInList(containers, objectName)) {
				continue;
			}
			if (isInList(infos, objectName)) {
				continue;
			}
			System.err.println("Error adding " + objectName + " back to the contents list! Couldn't be found in the the subclass lists.");
		}
	}
	
	private boolean isInList(List<? extends RoomObject> objList, String objectName) {
		for (RoomObject rObj : objList) {
			if (rObj.name().equals(objectName)) {
				contents.add(rObj);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sets the number representation of the direction.
	 */
	public void setDirectionInd() { 
		if (direction == Direction.FRONT) {
			directionInd = 0;
			return;
		} 
		if (direction == Direction.RIGHT) {
			directionInd = 1;
			return;
		} 
		if (direction == Direction.BACK) {
			directionInd = 2;
			return;
		} 
		if (direction == Direction.LEFT) {
			directionInd = 3;
			return;
		} 
	}
	
	/**
	 * Sets the direction based on directionInd.
	 */
	public void resetDirection() {
		if (directionInd == 0) {
			direction = Direction.FRONT;
			return;
		}
		if (directionInd == 1) {
			direction = Direction.RIGHT;
			return;
		}
		if (directionInd == 2) {
			direction = Direction.BACK;
			return;
		}
		if (directionInd == 3) {
			direction = Direction.LEFT;
			return;
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
	 * 
	 * @param containingRoom  The Room containing this Perspective.
	 */
	public void setContainingRoom(Room containingRoom) {
		this.containingRoom = containingRoom;
	}
	
	/**
	 * Compares two perspectives and determines equality based on their names.
	 * 
	 * @param other  The other perspective being compared to this one.
	 * @return     True if the perspectives are equal (as defined) and false otherwise.
	 */
	public boolean equals(Perspective other) {
		return name.equals(other.name());
	}
	
	/**
	 * Returns the name of the perspective.
	 * 
	 * @return     The name of the perspective.
	 */
	public String name() {
		return this.name;
	}
	
	/**
	 * Searches for a RoomObject of a given name in this Perspective, and returns it.
	 * 
	 * @param objName  The name of the RoomObject being looked for.
	 * @return     The RoomObject being looked for, or null if it doesn't exist.
	 */
	public RoomObject findObject(String objName) {
		for (RoomObject r : contents) {
			if (r.name().equals(objName)) {
				return r;
			}
		}
		return null;
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
