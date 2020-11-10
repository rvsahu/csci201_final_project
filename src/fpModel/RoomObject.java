package fpModel;

import java.util.List;

public abstract class RoomObject {
	//graphic variables
	private String spritePath; //e.g. "./couch3.png"
	
	private int xPos;
	private int yPos;
	
	/**
	 * Whether the program should display the object or not
	 */
	private boolean display;
	
	//logic variables
	private String name;
	
	public RoomObject() {
	}
	
	public RoomObject(String name) {
		this.name = name;
	}
	
	/**
	 * Returns whether the RoomObject holds an item or otherwise.
	 * 
	 * @return     True if it holds items, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean hasItems();
	
	/**
	 * Returns whether the RoomObject contains information or otherwise.
	 * 
	 * @return     True if it has info, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean hasInfo();
	
	/**
	 * Graphical method, sets the x and y positions of the object image on the screen
	 *
	 */
	public void setPosition(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void setXPosition(int xPos) {
		this.xPos = xPos;
	}
	
	public void setYPosition(int yPos) {
		this.yPos = yPos;
	}
	
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
	
	/**
	 * Displays the object
	 */
	public void display() {
		this.display = true;
	}
	
	/**
	 * Hides the object from view and interaction
	 */
	public void hide() {
		this.display = false;
	}
}
