package fpModel;

//java imports
import java.util.List;

//javafx imports
import javafx.scene.layout.BorderPane;
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
	 * @throws Exception  Exception thrown when the Room doesn't have any perspective.
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
	 * Adds a GenericObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param gObj  The GenericObject to be added to the current perspectives.
	 */
	public void addGenericCurrent(GenericObject gObj) {
		perspectives[currentPerspective].addGenericObject(gObj);
	}
	
	/**
	 * Adds a GenericObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param gObj  The GenericObject to be added to the front.
	 */
	public void addGenericFront(GenericObject gObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addGenericObject(gObj);
	}	
	
	/**
	 * Adds a GenericObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param gObj  The GenericObject to be added to the right.
	 */
	public void addGenericRight(GenericObject gObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addGenericObject(gObj);
	}
	
	/**
	 * Adds a GenericObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param gObj  The GenericObject to to be added to the back.
	 */
	public void addGenericBack(GenericObject gObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addGenericObject(gObj);
	}
	
	/**
	 * Adds a GenericObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param gObj  The GenericObject to be added to the left.
	 */
	public void addGenericLeft(GenericObject gObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addGenericObject(gObj);
	}
	
	/**
	 * Adds a InfoObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param iObj  The InfoObject to be added to the current perspectives.
	 */
	public void addInfoCurrent(InfoObject iObj) {
		perspectives[currentPerspective].addInfoObject(iObj);
	}
	
	/**
	 * Adds a InfoObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param iObj  The InfoObject to be added to the front.
	 */
	public void addInfoFront(InfoObject iObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addInfoObject(iObj);
	}	
	
	/**
	 * Adds a InfoObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param iObj  The InfoObject to be added to the right.
	 */
	public void addInfoRight(InfoObject iObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addInfoObject(iObj);
	}
	
	/**
	 * Adds a InfoObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param iObj  The InfoObject to to be added to the back.
	 */
	public void addInfoBack(InfoObject iObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addInfoObject(iObj);
	}
	
	/**
	 * Adds a InfoObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param iObj  The InfoObject to be added to the left.
	 */
	public void addInfoLeft(InfoObject iObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addInfoObject(iObj);
	}
	
	/**
	 * Adds a DoorObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param dObj  The DoorObject to be added to the current perspectives.
	 */
	public void addDoorCurrent(DoorObject dObj) {
		perspectives[currentPerspective].addDoorObject(dObj);
	}
	
	/**
	 * Adds a DoorObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param dObj  The DoorObject to be added to the front.
	 */
	public void addDoorFront(DoorObject dObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addDoorObject(dObj);
	}	
	
	/**
	 * Adds a DoorObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param dObj  The DoorObject to be added to the right.
	 */
	public void addDoorRight(DoorObject dObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addDoorObject(dObj);
	}
	
	/**
	 * Adds a DoorObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param dObj  The DoorObject to to be added to the back.
	 */
	public void addDoorBack(DoorObject dObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addDoorObject(dObj);
	}
	
	/**
	 * Adds a DoorObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param dObj  The DoorObject to be added to the left.
	 */
	public void addDoorLeft(DoorObject dObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addDoorObject(dObj);
	}
	
	/**
	 * Adds a WrapperObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param wObj  The WrapperObject to be added to the current perspectives.
	 */
	public void addWrapperCurrent(WrapperObject wObj) {
		perspectives[currentPerspective].addWrapperObject(wObj);
	}
	
	/**
	 * Adds a WrapperObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param wObj  The WrapperObject to be added to the front.
	 */
	public void addWrapperFront(WrapperObject wObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addWrapperObject(wObj);
	}	
	
	/**
	 * Adds a WrapperObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param wObj  The WrapperObject to be added to the right.
	 */
	public void addWrapperRight(WrapperObject wObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addWrapperObject(wObj);
	}
	
	/**
	 * Adds a WrapperObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param wObj  The WrapperObject to to be added to the back.
	 */
	public void addWrapperBack(WrapperObject wObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addWrapperObject(wObj);
	}
	
	/**
	 * Adds a WrapperObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param wObj  The WrapperObject to be added to the left.
	 */
	public void addWrapperLeft(WrapperObject wObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addWrapperObject(wObj);
	}
	
	/**
	 * Adds a ContainerObject to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param cObj  The ContainerObject to be added to the current perspectives.
	 */
	public void addContainerCurrent(ContainerObject cObj) {
		perspectives[currentPerspective].addContainerObject(cObj);
	}
	
	/**
	 * Adds a ContainerObject to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param cObj  The ContainerObject to be added to the front.
	 */
	public void addContainerFront(ContainerObject cObj) {
		if (perspectives[0] == null)
			return;
		perspectives[0].addContainerObject(cObj);
	}	
	
	/**
	 * Adds a ContainerObject to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param cObj  The ContainerObject to be added to the right.
	 */
	public void addContainerRight(ContainerObject cObj) {
		if (perspectives[1] == null)
			return;
		perspectives[1].addContainerObject(cObj);
	}
	
	/**
	 * Adds a ContainerObject to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param cObj  The ContainerObject to to be added to the back.
	 */
	public void addContainerBack(ContainerObject cObj) {
		if (perspectives[2] == null)
			return;
		perspectives[2].addContainerObject(cObj);
	}
	
	/**
	 * Adds a ContainerObject to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param cObj  The ContainerObject to be added to the left.
	 */
	public void addContainerLeft(ContainerObject cObj) {
		if (perspectives[3] == null)
			return;
		perspectives[3].addContainerObject(cObj);
	}
	
	/*
	 **
	 * Adds a list of RoomObjects to the currently selected perspective. currentPerspective is guaranteed to exist.
	 * 
	 * @param rObjs  The list of objects to be added.
	 *
	public void addToCurrent(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToCurrent(rObj);
		}
	}
	
	 **
	 * Adds a list of RoomObjects to the front perspective. Does nothing if the front perspective doesn't exist.
	 * 
	 * @param rObjs  The list of objects to be added.
	 *
	public void addToFront(List<RoomObject> rObjs) {
		if (perspectives[0] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToFront(rObj);
		}
	}	
	
	 **
	 * Adds a list of RoomObjects to the right perspective. Does nothing if the right perspective doesn't exist.
	 * 
	 * @param rObjs  The list of objects to be added.
	 * 
	public void addToRight(List<RoomObject> rObjs) {
		if (perspectives[1] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToRight(rObj);
		}
	}
	
	 **
	 * Adds a list of RoomObjects to the back perspective. Does nothing if the back perspective doesn't exist.
	 * 
	 * @param rObjs  The list of objects to be added.
	 * 
	public void addToBack(List<RoomObject> rObjs) {
		if (perspectives[2] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToBack(rObj);
		} 
	}
	
	 **
	 * Adds a list of RoomObjects to the left perspective. Does nothing if the left perspective doesn't exist.
	 * 
	 * @param rObjs  The list of objects to be added.
	 * 
	public void addToLeft(List<RoomObject> rObjs) {
		if (perspectives[3] == null)
			return;
		for (RoomObject rObj : rObjs) {
			addToLeft(rObj);
		}
	}
	*/
	
	/**
	 * Changes the current perspective one to the left.
	 */
	public void changePerspectiveLeft() {
		while (true) {
			decrementCPIndex();
			if (perspectives[currentPerspective] != null) {
				break;
			}
		}
	}
	
	/**
	 * Helper for changePerspectiveLeft(), decrements currentPerspective and wraps it around.
	 */
	private void decrementCPIndex() {
		currentPerspective -= 1;
		if (currentPerspective == -1) {
			currentPerspective = 3;
		}	
	}
	
	/**
	 * Changes the current perspective one to the right.
	 */
	public void changePerspectiveRight() {
		while (true) {
			incrementCPIndex();
			if (perspectives[currentPerspective] != null) {
				break;
			}
		}
	}
	
	/**
	 * Helper for changePerspectiveRight(), increments currentPerspective and wraps it around.
	 */
	private void incrementCPIndex() {
		currentPerspective += 1;
		if (currentPerspective == 4) {
			currentPerspective = 0;
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
	
	public BorderPane generatePane(Stage stage) {
		return perspectives[currentPerspective].generatePane(stage);
	}
	
	/**
	 * Deserialisation method, reloads all the sprites in every perspective.
	 */
	public void loadAllSprites() {
		for (int i = 0; i < 3; i += 1) {
			if (perspectives[i] == null) 
				continue;
			perspectives[i].loadAllSprites();
		}
	}
	
	/**
	 * Deserialisation method, rebuilds the contents list of every perspective.
	 */
	public void rebuildAllContentsLists() {
		for (int i = 0; i < 3; i += 1) {
			if (perspectives[i] == null) 
				continue;
			perspectives[i].rebuildContentsList();
		}
	}
	
	
	
	/**
	 * Deserialisation method, resets the direction of every perspective.
	 */
	public void resetAllDirections() {
		for (int i = 0; i < 3; i += 1) {
			if (perspectives[i] == null) 
				continue;
			perspectives[i].resetDirection();
		}
	}
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
	 * @param unlitLayerPaths  An array of strings containing the file paths to each layer in ascending order.
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
