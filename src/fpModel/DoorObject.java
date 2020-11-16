package fpModel;

public class DoorObject extends RoomObject {
	
	boolean isLocked;
	String mKey;
	
	DoorObject(Doorway doorway)
	{
		isLocked = false;
		mKey = "";
	}

	public DoorObject() {
		// TODO Auto-generated constructor stub
	}

	public DoorObject(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void lock() {
		isLocked = true;
	}
	
	/**
	 * Unlocks the door if it is locked. Does nothing if it is already open.
	 */
	public void unlock() {
		isLocked = false;
	}
	
	/**
	 * Locks the door with the provided key. Does nothing otherwise.
	 */
	public void lock(Key key) {
		mKey = key.name();
		isLocked = true;
	}
	
	/**
	 * Unlocks the door if the right key is used. Does nothing otherwise.
	 */
	public void unlock(Key key) {
		if (mKey == key.name()) {
			isLocked = false;
		}
	}
	
	/**
	 * Returns if the door is locked or not.
	 * @return     True if the door is locked and false otherwise.
	 */
	public boolean isLocked() {
		return this.isLocked;
	}

	@Override
	public boolean wrapsItem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasItems() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasInfo() {
		// TODO Auto-generated method stub
		return false;
	}

}
