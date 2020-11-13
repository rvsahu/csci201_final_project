package fpModel;

import java.io.FileInputStream;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class RoomObject {
	/*
	 * Graphic variables 
	 */
	
	/**
	 * The file path to the sprite/image of the object as viewable in the front perspective, or null if not
	 * viewable or 'interactable' from that perspective
	 */
	private String frontSpritePath;
	
	/**
	 * The file path to the sprite/image of the object as viewable in the right perspective, or null if not
	 * viewable or 'interactable' from that perspective
	 */
	private String rightSpritePath; 
	
	/**
	 * The file path to the sprite/image of the object as viewable in the back perspective, or null if not
	 * viewable or 'interactable' from that perspective
	 */
	private String backSpritePath; 
	
	/**
	 * The file path to the sprite/image of the object as viewable in the left perspective, or null if not
	 * viewable or 'interactable' from that perspective
	 */
	private String leftSpritePath; 
		
	/**
	 * The behaviour of the RoomObject when clicked
	 */
	private EventHandler<MouseEvent> behaviour;
	
	/**
	 * The sprite of the RoomObject as viewed from the front.
	 */
	private transient Image frontSprite;
	
	/**
	 * The sprite of the RoomObject as viewed from the right.
	 */
	private transient Image rightSprite;
	
	/**
	 * The sprite of the RoomObject as viewed from the back.
	 */
	private transient Image backSprite;
	
	/**
	 * The sprite of the RoomObject as viewed from the left.
	 */
	private transient Image leftSprite;
	
	/**
	 * The graphical representation of the RoomObject
	 */
	private transient ImageView node;
	
	/**
	 * Whether the program should display the RoomObject or not.
	 */
	private boolean display;
	
	/*
	 * Logic variables 
	 */
	
	/**
	 * The unique name of the RoomObject
	 */
	private String name;
	
	/*
	 * Constructors 
	 */
	
	public RoomObject() {
		display = true;
	}
	
	public RoomObject(String name) {
		this.name = name;
		display = true;
	}
	
	/*
	 * Logical methods
	 */
	
	/**
	 * Returns whether the RoomObject wraps an item or otherwise.
	 * 
	 * @return     True if it wraps an item, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean wrapsItem();
	
	/**
	 * Returns whether the RoomObject holds items or otherwise.
	 * 
	 * @return     True if it holds items, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean hasItems();
	
	/**
	 * Returns whether the RoomObject contains information or otherwise.
	 * 
	 * @return     True if it has info, false if it doesn't, regardless of if capable.
	 */
	public abstract boolean hasInfo();
	
	/*
	 * Graphical methods
	 */
	
	/**
	 * Sets frontSpritePath to given String. Doesn't change image in node if already initialised, must call loadImages
	 * afterwards for that.
	 * 
	 * @param frontSpritePath  The String containing the file path of the sprite/image file  
	 */
	public void setFrontSpritePath(String frontSpritePath) {
		this.frontSpritePath = frontSpritePath;
	}
	
	/**
	 * Sets rightSpritePath to given String. Doesn't change image in node if already initialised, must call loadImages
	 * afterwards for that.
	 * 
	 * @param rightSpritePath  The String containing the file path of the sprite/image file  
	 */
	public void setRightSpritePath(String rightSpritePath) {
		this.rightSpritePath = rightSpritePath;
	}
	
	/**
	 * Sets backSpritePath to given String. Doesn't change image in node if already initialised, must call loadImages
	 * afterwards for that.
	 * 
	 * @param backSpritePath  The String containing the file path of the sprite/image file  
	 */
	public void setBackSpritePath(String backSpritePath) {
		this.backSpritePath = backSpritePath;
	}
	
	/**
	 * Sets leftSpritePath to given String. Doesn't change image in node if already initialised, must call loadImages
	 * afterwards for that.
	 * 
	 * @param leftSpritePath  The String containing the file path of the sprite/image file  
	 */
	public void setLeftSpritePath(String leftSpritePath) {
		this.leftSpritePath = leftSpritePath;
	}
	
	/**
	 * Sets the object to be shown when in the right perspective
	 */
	public void display() {
		this.display = true;
	}
	
	/**
	 * Hides the object from view and interaction even when in the right perspective
	 */
	public void hide() {
		node.setVisible(false);
		this.display = false;
	}
	
	/**
	 * Returns a boolean representing whether the object is hidden or otherwise
	 */
	public boolean isHidden() {
		return !(display);
	}
	
	/**
	 * Setup method. Gives the particular RoomObject its unique on-click behaviour.
	 */
	public void setBehaviour(EventHandler<MouseEvent> behaviour) {
		this.behaviour = behaviour;
	}
	
	/**
	 * Attempts to load the sprites for each perspective if given a file path for that perspective. 
	 * If no file path given for a particular angle, then it doesn't try to load.
	 * Should be done as soon as the method is called
	 */
	public void loadSprites() {
		if (frontSpritePath != null) {
			try {
				frontSprite = new Image(new FileInputStream(frontSpritePath));
			} catch (Exception e) {
				frontSprite = null;
				System.err.println("Error loading front sprite for " + name);
			}
		}
		if (rightSpritePath != null) {
			try {
				rightSprite = new Image(new FileInputStream(rightSpritePath));
			} catch (Exception e) {
				rightSprite = null;
				System.err.println("Error loading right sprite for " + name);
			}
		}
		if (backSpritePath != null) {
			try {
				backSprite = new Image(new FileInputStream(backSpritePath));
			} catch (Exception e) {
				backSprite = null;
				System.err.println("Error loading back sprite for " + name);
			}
		}
		if (leftSpritePath != null) {
			try {
				leftSprite = new Image(new FileInputStream(leftSpritePath));
			} catch (Exception e) {
				leftSprite = null;
				System.err.println("Error loading left sprite for " + name);
			}
		}
	}
	
	/**
	 * Returns an ImageView of the RoomObject as it would be seen from the front, or null
	 * if it can't be seen/interacted with from that angle, or if display is set to false.
	 * Assigns field behaviour to the ImageView.
	 * 
	 * @return    An ImageView if the object can be seen and interacted with from the front, and display is true. null otherwise.
	 */
	public ImageView showFront() {
		if (display && frontSprite != null) {
			node = new ImageView(frontSprite);
			return node;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns an ImageView of the RoomObject as it would be seen from the right, or null
	 * if it can't be seen/interacted with from that angle, or if display is set to false.
	 * Assigns field behaviour to the ImageView.
	 * 
	 * @return    An ImageView if the object can be seen and interacted with from the right, and display is true. null otherwise.
	 */
	public ImageView showRight() {
		if (display && rightSprite != null) {
			node = new ImageView(rightSprite);
			return node;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns an ImageView of the RoomObject as it would be seen from the back, or null
	 * if it can't be seen/interacted with from that angle, or if display is set to false.
	 * Assigns field behaviour to the ImageView.
	 * 
	 * @return    An ImageView if the object can be seen and interacted with from the back, and display is true. null otherwise.
	 */
	public ImageView showBack() {
		if (display && backSprite != null) {
			node = new ImageView(backSprite);
			return node;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns an ImageView of the RoomObject as it would be seen from the left, or null
	 * if it can't be seen/interacted with from that angle, or if display is set to false.
	 * Assigns field behaviour to the ImageView.
	 * 
	 * @return    An ImageView if the object can be seen and interacted with from the left, and display is true. null otherwise.
	 */
	public ImageView showLeft() {
		if (display && leftSprite != null) {
			node = new ImageView(leftSprite);
			return node;
		} else {
			return null;
		}
	}
}
