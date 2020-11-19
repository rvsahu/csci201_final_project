package fpModel;

/**
 * Concrete implementation of RoomObject, represents an object with information to be added to
 * the player's Logbook under some condition, usually handled by the behaviour EventHandler
 * 
 * Implementations of InfoObject pre-consolidation: Computer, CP, Notebook, Phone
 */
public class InfoObject extends RoomObject {
	String info;
	
	public InfoObject() {
		super();
	}
	
	public InfoObject(String name) {
		super(name);
	}
	
	public InfoObject(String name, String info) {
		super(name);
		this.info = info;
	}

	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return !(info == null || info.equals(""));
	}
	
	@Override public boolean wrapsItem() {
		return false;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		if (hasInfo()) {
			String temp = new String(info);
			info = null;
			return temp;
		}
		return null;
		
	}
}
