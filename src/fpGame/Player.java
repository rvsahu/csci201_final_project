package fpGame;

import fpModel.*;

public class Player {
	private Room currentRoom;
	private Inventory inven;
	private Logbook logbook;
	private int currentLevel;
	
	private transient Perspective currentView;
	private String cvName;
	
	public Player(Room startingRoom, int startingLevel) {
		currentRoom = startingRoom;
		currentLevel = startingLevel;
		currentView = currentRoom.getCurrent();
		cvName = currentView.name();
		inven = new Inventory();
		logbook = new Logbook();
	}
	
	public void turnLeft() {
		currentRoom.changePerspectiveLeft();
		currentView = currentRoom.getCurrent();
	}
	
	public void turnRight() {
		currentRoom.changePerspectiveRight();
		currentView = currentRoom.getCurrent();
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
	
	public int getLevel() {
		return currentLevel;
	}
	
	public Room currentRoom() {
		return currentRoom;
	}
	
	public Perspective currentView() {
		return currentView;
	}
}
