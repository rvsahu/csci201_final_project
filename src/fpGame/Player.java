package fpGame;

import fpModel.*;

public class Player {
	private transient Room currentRoom;
	private transient Perspective currentView;
	
	private String crName;
	private int cvIndex;
	
	private Inventory inven;
	private Logbook logbook;
	private int currentLevel;
	
	public Player() {
		inven = new Inventory();
		logbook = new Logbook();
	}
	
	public Player(Room startingRoom, int startingLevel) {
		currentRoom = startingRoom;
		currentLevel = startingLevel;
		currentView = currentRoom.getCurrent();
		
		crName = currentRoom.name();
		cvIndex = currentRoom.getCurrentIndex();
		
		inven = new Inventory();
		logbook = new Logbook();
	}
	
	public void turnLeft() {
		currentRoom.changePerspectiveLeft();
		currentView = currentRoom.getCurrent();
		cvIndex = currentRoom.getCurrentIndex();
	}
	
	public void turnRight() {
		currentRoom.changePerspectiveRight();
		currentView = currentRoom.getCurrent();
		cvIndex = currentRoom.getCurrentIndex();
	}
	
	public boolean addToInventory(Item item) {
		return inven.addItem(item);
	}
	
	public boolean removeFromInventory(Item item) {
		return inven.removeItem(item);
	}
	
	public Inventory getInventory() {
		return inven;
	}
	
	public void addToLogbook(String info) {
		logbook.addInfo(info);
	}
	
	public Logbook getLogbook() {
		return logbook;
	}
	
	public int getLevel() {
		return currentLevel;
	}
	
	public Room currentRoom() {
		return currentRoom;
	}
	
	public Perspective currentView() {
		return currentView;
	}
	
	public void setCurrentRoom(Room newRoom) {
		currentRoom = newRoom;
		crName = currentRoom.name();
	}
	
	/**
	 * Sets player user's current perspective, provided that perspective is in the currentRoom of the player.
	 * @param perspective  The desired new perspective of the user.
	 */
	public void setCurrentPerspective(Perspective perspective) {
		if (currentRoom.setPerspective(perspective)) {
			currentView = perspective;
			cvIndex = currentRoom.getCurrentIndex();
		}
	}
	
	/**
	 * Sets player user's current perspective, provided that perspective is in the currentRoom of the player.
	 * @param pIndex  The directional index of the desired new perspective in the Room.
	 */
	public void setCurrentPerspective(int pIndex) {
		if (currentRoom.setPerspective(pIndex)) {
			currentView = currentRoom.getCurrent();
			cvIndex = currentRoom.getCurrentIndex();
		}
	}
	
	public String getCRName() {
		return crName;
	}
	
	public int getCVIndex() {
		return cvIndex;
	}
}
