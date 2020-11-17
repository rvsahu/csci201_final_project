package fpModel;

public class Doorlock {
	private String keyName;
	
	public Doorlock(Key key) {
		keyName = key.name();
	}
	
	public Doorlock(String keyName) {
		this.keyName = keyName;
	}
	
	/**
	 * Tries to lock or unlock a door using a key.
	 * 
	 * @param key  The key being used to try on the lock.
	 * @return     True if the given key is the correct key for the door, false otherwise.
	 */
	public boolean tryKey(Key key) {
		return keyName.equals(key.name());
	}
}
