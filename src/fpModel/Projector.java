package fpModel;

public class Projector extends RoomObject {
	
	/**
	 * Graphic variable, String filepath to the image of what the projector projects.
	 */
	private String projectionPath;
	
	/**
	 * The x position of the projection image (from the top left)
	 */
	private int projectionX;
	
	/**
	 * The y position of the projection image (from the top left)
	 */
	private int projectionY;
	
	/**
	 * Boolean representing whether the projector is on/projecting an image or not.
	 */
	private boolean projecting; 
	
	/**
	 * Default constructor to a projector
	 */
	public Projector() {
		projecting = false;
	}

	/**
	 * Projector constructor, takes a name
	 * 
	 * @param name  The name of the projector, used for equality comparisons
	 */
	public Projector(String name) {
		super(name);
		projecting = false;
	}
	
	
	/**
	 * Projector constructor, takes a name and filepath to an image to be displayed when projected
	 * 
	 * @param name  The name of the projector, used for equality comparisons
	 * @param projectionPath  The filepath to the image that gets displayed
	 */
	public Projector(String name, String projectionPath) {
		super(name);
		this.projectionPath = projectionPath;
		projecting = false;
	}

	/**
	 * Returns whether the projector has items or not, always false.
	 */
	@Override public boolean hasItems() {
		return false;
	}

	/**
	 * Returns whether the projector has information or not, always false.
	 */
	@Override public boolean hasInfo() {
		return false;
	}
	
	/**
	 * Turns the projector on
	 */
	public void startProjecting() {
		projecting = true;
	}
	
	/**
	 * Turns the projector on
	 */
	public void stopProjecting() {
		projecting = false;
	}
	
	/**
	 * Graphical method, set x and y of projection 
	 */
	public void setProjectionPos(int projectionX, int projectionY) {
		this.projectionX = projectionX;
		this.projectionY = projectionY;
	}
}

