package fpModel;

//java imports
import java.util.List;
import java.util.ArrayList;

//javafx imports
import javafx.scene.Scene;

public class Perspective {
	
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
	private Room containingRoom;
	
	/**
	 *  A list of RoomObjects representing the contents of the room viewable from this perspective
	 */
	private List<RoomObject> contents;
	
	/**
	 *  A list of Doorways representing the exits from this room to another viewable from this perspective
	 */
	private List<Doorway> exits;
	
	/*
	 * Model Methods
	 */
	
	public Perspective(Room containingRoom, String name) {
		this.containingRoom = containingRoom;
		this.name = name;
		contents = new ArrayList<RoomObject>();
		exits = new ArrayList<Doorway>();
	}
	
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
	
	/*
	 * Game-time methods
	 */
	
	public Room containingRoom() {
		return containingRoom;
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
	public Scene generateScene() {
		/*
		for (RoomObject rObj : contents) {
			//TO BE IMPLEMENTED
		}
		*/
		return null;
	}
	
	
}
