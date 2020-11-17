package fpModel;

//java imports
import java.util.List;

//javafx imports
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Room {
	private transient int currentPerspective;
	
	private String name;
	//p[0] => front, p[1] => right, p[2] => back, p[3] => left
	private Perspective[] perspectives = new Perspective[4];
	
	/*
	 * Constructor(s)
	 */
	
	/**
	 * Constructs an empty room, with a default of four perspectives. 
	 * 
	 * @param name  The name of the room
	 */
	public Room(String name) {
		perspectives[0] = new Perspective(this, name + " Front", Perspective.Direction.FRONT);
		perspectives[1] = new Perspective(this, name + " Right", Perspective.Direction.RIGHT);
		perspectives[2] = new Perspective(this, name + " Back", Perspective.Direction.BACK);
		perspectives[3] = new Perspective(this, name + " Left", Perspective.Direction.LEFT);
		currentPerspective = 0;
	}
	
	/**
	 * Constructs an empty room, with perspectives created as specified.
	 * 
	 * @param name  The name of the room.
	 * @param hasFront  Whether the Room has a front view or not.
	 * @param hasRight  Whether the Room has a right view or not.
	 * @param hasBack  Whether the Room has a back view or not.
	 * @param hasLeft  Whether the Room has a left view or not.
	 */
	public Room(String name, boolean hasFront, boolean hasRight, boolean hasBack, boolean hasLeft) throws Exception {
		if (!(hasFront || hasRight || hasBack ||hasLeft)) {
			throw new Exception(name + " needs to have at least one perspective!");
		}
		boolean cdAssigned = false;
		if (hasFront) {
			perspectives[0] = new Perspective(this, name + " Front", Perspective.Direction.FRONT);
			currentPerspective = 0;
			cdAssigned = true;
		}
		if (hasRight) {
			perspectives[1] = new Perspective(this, name + " Right", Perspective.Direction.RIGHT);
			if (!(cdAssigned)) {
				currentPerspective = 1;
				cdAssigned = true;
			}
		}
		if (hasBack) {
			perspectives[2] = new Perspective(this, name + " Back", Perspective.Direction.BACK);
			if (!(cdAssigned)) {
				currentPerspective = 2;
				cdAssigned = true;
			}
		}
		if (hasLeft) {
			perspectives[3] = new Perspective(this, name + " Left", Perspective.Direction.LEFT);
			if (!(cdAssigned)) {
				currentPerspective = 3;
				cdAssigned = true;
			}
		}		
	}
	
	/*
	 * Model methods 
	 */
	
	/**
	 * Returns the name of the Room.
	 * 
	 * @return     The name of the Room.
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Adds a RoomObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToCurrent(RoomObject rObj) {
		perspectives[currentPerspective].addRoomObject(rObj);
	}
	
	/**
	 * Adds a RoomObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToFront(RoomObject rObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addRoomObject(rObj);
	}	
	
	/**
	 * Adds a RoomObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToRight(RoomObject rObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addRoomObject(rObj);
	}
	
	/**
	 * Adds a RoomObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToBack(RoomObject rObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addRoomObject(rObj);
	}
	
	/**
	 * Adds a RoomObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToLeft(RoomObject rObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addRoomObject(rObj);
	}
	
	/**
	 * Adds a list of RoomObjects to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToCurrent(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToCurrent(rObj);
		}
	}
	
	/**
	 * Adds a list of RoomObjects to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToFront(List<RoomObject> rObjs) {
		if (perspectives[0] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToFront(rObj);
		}
	}	
	
	/**
	 * Adds a list of RoomObjects to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToRight(List<RoomObject> rObjs) {
		if (perspectives[1] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToRight(rObj);
		}
	}
	
	/**
	 * Adds a list of RoomObjects to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToBack(List<RoomObject> rObjs) {
		if (perspectives[2] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToBack(rObj);
		} 
	}
	
	/**
	 * Adds a list of RoomObjects to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToLeft(List<RoomObject> rObjs) {
		if (perspectives[3] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToLeft(rObj);
		}
	}
	
	public void changePerspectiveLeft() {
		while (true) {
			currentPerspective = ((currentPerspective - 1) % 4);
			if (perspectives[currentPerspective] != null) {
				break;
			}
		}
	}
	
	public void changePerspectiveRight() {
		while (true) {
			currentPerspective = ((currentPerspective + 1) % 4);
			if (perspectives[currentPerspective] != null) {
				break;
			}
		}
	}
	
	public Perspective getCurrent() {
		return perspectives[currentPerspective];
	}
	
	public int getCurrentIndex() {
		return currentPerspective;
	}
	
	public boolean equals(Room other) {
		return this.name.equals(other.name);
	}
	
	
	/**
	 * Given a perspective, checks whether if it's in the current room and if
	 * it does then updates currentPerspective to match that. Only called
	 * when a player is entering through a doorway, or loading up a game save.
	 * otherwise perspective is changed via the changePerspectiveLeft() 
	 * and changePerspectiveRight() methods
	 * 
	 * @param perspective  A perspective that may or may not be in this room
	 * @return     True if the perspective is in the room and false otherwise 
	 */
	public boolean setPerspective(Perspective perspective) {
		for (int i = 0; i < 3; i += 1) {
			if (perspectives[i] == null)
				continue;
			boolean isEqual = perspectives[i].equals(perspective);
			if (isEqual) {
				currentPerspective = i;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Given an index that corresponds to a direction (0 is front, 1 is right, 2 is back, 3 is left), sets the current
	 * perspective to that index.
	 * 
	 * @param pIndex  The index of the perspective.
	 * @return     True if the perspective exists, false if it doesn't.
	 */
	public boolean setPerspective(int pIndex) {
		if (perspectives[pIndex] == null)
			return false;
		currentPerspective = pIndex;
		return true;
	}
	
	/**
	 * Setup/deserialisation method. Gives each perspective a reference to this Room as their containing room.
	 */
	public void addContainingRooms() {
		for (int i = 0; i < 4; i += 1) {
			if (perspectives[i] == null) 
				continue;
			perspectives[i].setContainingRoom(this);
		}
	}
	
	/*
	 * Graphics methods 
	 */
	
	public Pane generateScene(Stage stage) {
		return perspectives[currentPerspective].generateScene(stage);
	}
	
	/*
	 **
	 * Sets the background file path of the front perspective to the given string.
	 * 
	 * @param backgroundPath  The path to the background image of the front perspective.
	 *
	public void setBackgroundFront(String backgroundPath) {
		perspectives[0].setBackground(backgroundPath);
	}
	
	 **
	 * Sets the unlit background file path of the front perspective to the given string.
	 * 
	 * @param unlitBackgroundPath  The path to the unlit background image of the front perspective.
	 *
	public void setUnlitBackgroundFront(String unlitBackgroundPath) {
		perspectives[0].setUnlitBackground(unlitBackgroundPath);
	}
	
	 **
	 * Sets the background file path of the right perspective to the given string.
	 * 
	 * @param backgroundPath  The path to the background image of the right perspective.
	 *
	public void setBackgroundRight(String backgroundPath) {
		perspectives[1].setBackground(backgroundPath);
	}
	
	 **
	 * Sets the unlit background file path of the right perspective to the given string.
	 * 
	 * @param unlitBackgroundPath  The path to the unlit background image of the right perspective.
	 *
	public void setUnlitBackgroundRight(String unlitBackgroundPath) {
		perspectives[1].setUnlitBackground(unlitBackgroundPath);
	}
	
	 **
	 * Sets the background file path of the back perspective to the given string.
	 * 
	 * @param backgroundPath  The path to the background image of the back perspective.
	 *
	public void setBackgroundBack(String backgroundPath) {
		perspectives[2].setBackground(backgroundPath);
	}
	
	 **
	 * Sets the unlit background file path of the back perspective to the given string.
	 * 
	 * @param unlitBackgroundPath  The path to the unlit background image of the back perspective.
	 *
	public void setUnlitBackgroundBack(String unlitBackgroundPath) {
		perspectives[2].setUnlitBackground(unlitBackgroundPath);
	}
	
	 **
	 * Sets the background file path of the left perspective to the given string.
	 * 
	 * @param backgroundPath  The path to the background image of the left perspective.
	 * 
	public void setBackgroundLeft(String backgroundPath) {
		perspectives[3].setBackground(backgroundPath);
	}
	
	 **
	 * Sets the unlit background file path of the left perspective to the given string.
	 * 
	 * @param unlitBackgroundPath  The path to the unlit background image of the left perspective.
	 * 
	public void setUnlitBackgroundLeft(String unlitBackgroundPath) {
		perspectives[3].setUnlitBackground(unlitBackgroundPath);
	}
	*/
	
	/**
	 * Sets the layer backgrounds of the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param layerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setLayerBackgroundsFront(String[] layerPaths) {
		if (perspectives[0] == null)
			return;
		perspectives[0].setLayerPaths(layerPaths);
	}
	
	/**
	 * Sets the layer backgrounds of the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param layerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setLayerBackgroundsRight(String[] layerPaths) {
		if (perspectives[1] == null)
			return;
		perspectives[1].setLayerPaths(layerPaths);
	}
	
	/**
	 * Sets the layer backgrounds of the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param layerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setLayerBackgroundsBack(String[] layerPaths) {
		if (perspectives[2] == null)
			return;
		perspectives[2].setLayerPaths(layerPaths);
	}
	
	/**
	 * Sets the layer backgrounds of the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param layerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setLayerBackgroundsLeft(String[] layerPaths) {
		if (perspectives[3] == null)
			return;
		perspectives[3].setLayerPaths(layerPaths);
	}
	
	/**
	 * Sets the unlit layer backgrounds of the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param unlitLayerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setUnlitLayerBackgroundsFront(String[] unlitLayerPaths) {
		if (perspectives[0] == null)
			return;
		perspectives[0].setUnlitLayerPaths(unlitLayerPaths);
	}
	
	/**
	 * Sets the unlit layer backgrounds of the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param unlitLayerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setUnlitLayerBackgroundsRight(String[] unlitLayerPaths) {
		if (perspectives[1] == null)
			return;
		perspectives[1].setUnlitLayerPaths(unlitLayerPaths);
	}
	
	/**
	 * Sets the layer backgrounds of the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param unliLlayerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setUnlitLayerBackgroundsBack(String[] unlitLayerPaths) {
		if (perspectives[2] == null)
			return;
		perspectives[2].setUnlitLayerPaths(unlitLayerPaths);
	}
	
	/**
	 * Sets the layer backgrounds of the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param unlitLayerPaths  An array of strings containing the file paths to each layer in ascending order.
	 */
	public void setUnlitLayerBackgroundsLeft(String[] unlitLayerPaths) {
		if (perspectives[3] == null)
			return;
		perspectives[3].setUnlitLayerPaths(unlitLayerPaths);
	}
}
