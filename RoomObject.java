package fpModel;

import java.util.List;

public abstract class RoomObject {
	//graphic variables
	private transient String filename; //e.g. "./couch3.png"
	
	private transient int xPos;
	private transient int yPos;
	
	//logic variables
	private String name;
	
	/**
	 * Returns whether the RoomObject holds an item or otherwise.
	 * 
	 * @return     True if it holds items, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean hasItems();
	
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
}
