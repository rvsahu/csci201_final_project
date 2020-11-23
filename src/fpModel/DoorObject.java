package fpModel;

public class DoorObject extends RoomObject {
	
	private boolean isLocked;
	private String mKey;
	
	public DoorObject() {
		isLocked = false;
		mKey = "";
	}

	public DoorObject(String name) {
		super(name);
		isLocked = false;
		mKey = "";
	}
	
	public void lock() {
		isLocked = true;
	}
	
	/**
	 * Unlocks the door if it is locked. Does nothing if it is already open.
	 */
	public void unlock() {
		if (mKey == null || mKey.equals("")) {
			isLocked = false;
		}
	}
	
	/**
	 * Locks the door with the provided key.
	 * 
	 * @param key  The key the door is being locked with. Updates key name to match the new key.
	 */
	public void lock(Item key) {
		mKey = key.name();
		isLocked = true;
	}
	
	/**
	 * Unlocks the door if the right key is used. Does nothing otherwise.
	 * 
	 * @param key  The key being tried on the door.
	 */
	public void unlock(Item key) {
		if (mKey.equals(key.name())) {
			isLocked = false;
		}
	}
	
	/**
	 * Locks a door with the name of an item (meant to be a key), but does nothing if the door is already locked.
	 * 
	 * @param keyName  The name of the key being used to lock the door.
	 */
	public void lock(String keyName) {
		if (isLocked)
			return;
		mKey = keyName;
		isLocked = true;
	}
	
	/**
	 * Returns if the door is locked or not.
	 * @return     True if the door is locked and false otherwise.
	 */
	public boolean isLocked() {
		return this.isLocked;
	}
	

	@Override public boolean wrapsItem() {
		return false;
	}

	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return false;
	}

}
