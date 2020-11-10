package fpModel;

public class Doorway {
	/*
	 * Logic variables - These are transient to prevent infinite loops during
	 * serialisation, and must be re-added during deserialisation.
	 * 
	 * As of 09/11 I have not determined how exactly to approach this because
	 * I need a little more information on how it is serialised in the first place.
	 */
	
	private transient Room roomA;
	private transient Perspective viewA;
	
	private transient Room roomB;
	private transient Perspective viewB;
	
	/**
	 * Boolean representing whether the door is locked or not.
	 */
	private boolean isLocked;
	
	/**
	 * Name of the door, used for quick equality comparisons
	 */
	private String doorName;
	
	/**
	 * Optional field, a Doorlock for when the door needs a specific key.
	 */
	private Doorlock doorlock;
	
	//graphic variables
	private int xPos;
	private int yPos;
	
	/*
	 * Setup methods
	 */
	
	/**
	 * Specific constructor for doorway, represents doorways between rooms. 
	 * 
	 * @param a  One of the rooms the doorway is between (doesn't matter which one).
	 * @param b  The other room the doorway is between (doesn't matter which one).
	 * @param e_A  The perspective the player faces when they enter room A.
	 * @param e_B  The perspective the player faes when they enter room B.
	 */
	public Doorway(Room a, Room b, Perspective e_A, Perspective e_B) {
		roomA = a;
		roomB = b;
		viewA = e_A;
		viewB = e_B;
		isLocked = false;
	}
	
	/**
	 * Default constructor for Doorway, initialises nothing. Should be used during game setup
	 * The doorway has its ends set when its added to Pespectives.
	 */
	public Doorway() {
		//nothing
	}
	
	/**
	 * Default constructor for Doorway with a lock, initialises the lock. Should be used during game setup
	 * The doorway has its ends set when its added to Pespectives.
	 */
	public Doorway(Doorlock doorlock) {
		this.doorlock = doorlock;
	}
	
	/**
	 * Given a perspective, adds it and the room it is in as one of the ends. 
	 * If both ends are already assigned then it does nothing.
	 */
	public void addEndPerspective(Perspective end) {
		if (viewA == null) {
			viewA = end;
			roomA = end.containingRoom();
		} else if (viewB == null) {
			viewB = end;
			roomB = end.containingRoom();
			doorName = viewA.name() + ":" + viewB.name();
		}
	}
	
	
	/*
	 * Game-time methods
	 */
	
	/**
	 * Locks the door if there is no Doorlock. Does nothing if there is.
	 */
	public void lock() {
		if (doorlock == null) {
			isLocked = true;
		}
	}
	
	/**
	 * Unlocks the door if there is no Doorlock. Does nothing if there is.
	 */
	public void unlock() {
		if (doorlock == null) {
			isLocked = false;
		}
	}
	
	/**
	 * Unlocks the door if there is a Doorlock and the right key is used. Does nothing otherwise.
	 */
	public void lock(Key key) {
		if (doorlock != null && doorlock.tryKey(key)) {
			isLocked = true;
		}
	}
	
	/**
	 * Unlocks the door if there a Doorlock and the right key is used. Does nothing otherwise.
	 */
	public void unlock(Key key) {
		if (doorlock != null && doorlock.tryKey(key)) {
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
	
	public String name() {
		return this.doorName;
	}
	
	public boolean equals(Doorway other) {
		return doorName.equals(other.name());
	}
	
	/**
	 * Given the perspective the user is currently in, returns the perspective 
	 * on the other side of the Doorway. Throws exception if passed a perspective
	 * that the Doorway doesn't connect to.
	 * 
	 * @param movedFrom  The perspective the user moved from through the doorway
	 * @return     The perspective the user enters after moving through the doorway
	 */
	public Perspective moveThrough(Perspective movedFrom) throws Exception {
		if (viewA.equals(movedFrom))
			return viewB;
		else if (viewB.equals(movedFrom))
			return viewA;
		throw new Exception();
	}
	
	//graphic methods
	/* stuff goes here */
	
	public void setPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
}
