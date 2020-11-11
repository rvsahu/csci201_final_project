package fpModel;

import java.util.List;

import javafx.scene.Scene;

public class Room {
	private transient int currentPerspective;
	
	private String name;
	//p[0] => front, p[1] => right, p[2] => back, p[3] => left
	private Perspective[] perspectives = new Perspective[4];
	
	/*
	 * Setup methods
	 */
	
	/**
	 * Constructs an empty room
	 * 
	 * @param name  The name of the room
	 */
	public Room(String name) {
		perspectives[0] = new Perspective(this, name + "_front");
		perspectives[1] = new Perspective(this, name + "_right");
		perspectives[2] = new Perspective(this, name + "_back");
		perspectives[3] = new Perspective(this, name + "_left");
		currentPerspective = 0;
	}
	
	/**
	 * Adds an individual object to the currently selected perspective
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToCurrent(RoomObject rObj) {
		perspectives[currentPerspective].addRoomObject(rObj);
	}
	
	/**
	 * Adds an individual object to the front perspective
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToFront(RoomObject rObj) {
		perspectives[0].addRoomObject(rObj);
	}	
	
	/**
	 * Adds an individual object to the right perspective
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToRight(RoomObject rObj) {
		perspectives[1].addRoomObject(rObj);
	}
	
	/**
	 * Adds an individual object to the back perspective
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToBack(RoomObject rObj) {
		perspectives[2].addRoomObject(rObj);
	}
	
	/**
	 * Adds an individual object to the left perspective
	 * 
	 * @param rObj  The object to be added.
	 */
	public void addToLeft(RoomObject rObj) {
		perspectives[3].addRoomObject(rObj);
	}
	
	/**
	 * Adds a list of RoomObjects to the currently selected perspective
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToCurrent(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToCurrent(rObj);
		}
	}
	
	/**
	 * Adds a list of RoomObjects to the front perspective
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToFront(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToFront(rObj);
		}
	}	
	
	/**
	 * Adds a list of RoomObjects to the right perspective
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToRight(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToRight(rObj);
		}
	}
	
	/**
	 * Adds a list of RoomObjects to the back perspective
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToBack(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToBack(rObj);
		} 
	}
	
	/**
	 * Adds a list of RoomObjects to the left perspective
	 * 
	 * @param rObj  The list of objects to be added.
	 */
	public void addToLeft(List<RoomObject> rObjs) {
		for (RoomObject rObj : rObjs) {
			addToLeft(rObj);
		}
	}
	
	/**
	 * Adds a Doorway to the currently selected perspective
	 * 
	 * @param exit  The Doorway to be added.
	 */
	public void addExitCurrent(Doorway exit) {
		perspectives[currentPerspective].addExit(exit);
	}
	
	/**
	 * Adds a Doorway to the currently selected perspective
	 * 
	 * @param exit  The Doorway to be added.
	 */
	public void addExitFront(Doorway exit) {
		perspectives[0].addExit(exit);
	}	
	
	/**
	 * Adds a Doorway to the currently selected perspective
	 * 
	 * @param exit  The Doorway to be added.
	 */
	public void addExitRight(Doorway exit) {
		perspectives[1].addExit(exit);
	}
	
	/**
	 * Adds a Doorway to the currently selected perspective
	 * 
	 * @param exit  The Doorway to be added.
	 */
	public void addExitBack(Doorway exit) {
		perspectives[2].addExit(exit);
	}
	
	/**
	 * Adds a Doorway to the currently selected perspective
	 * 
	 * @param exit  The Doorway to be added.
	 */
	public void addExitLeft(Doorway exit) {
		perspectives[3].addExit(exit);
	}
	
	/*
	 * Game-time methods
	 */
	
	public Perspective changePerspectiveLeft() {
		currentPerspective = ((currentPerspective - 1) % 4);
		return getCurrent();
	}
	
	public Perspective changePerspectiveRight() {
		currentPerspective = ((currentPerspective + 1) % 4);
		return getCurrent();
	}
	
	public Perspective getCurrent() {
		return perspectives[currentPerspective];
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
			boolean isEqual = perspectives[i].equals(perspective);
			if (isEqual) {
				currentPerspective = i;
				return true;
			}
		}
		return false;
	}
	
	public Scene generateScene() {
		return perspectives[currentPerspective].generateScene();
	}
}
