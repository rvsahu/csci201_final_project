package fpModel;

public class Player {
	private Room currentRoom;
	private Inventory inven;
	private Logbook logbook;
	private int currlevel = 1;
	
	private transient Perspective currentView;
	private String cvName;
	
	public void turnLeft() {
		currentView = currentRoom.changePerspectiveLeft();
	}
	
	public void turnRight() {
		currentView = currentRoom.changePerspectiveRight();
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
	
	public int getLevel()
	{
		return currlevel;
	}
	public void addToLogbook(String info) {
		logbook.addInfo(info);
	}
}
