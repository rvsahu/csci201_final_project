package fpModel;

import java.io.FileInputStream;

import fpGame.GameUtil;
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
	private transient EventHandler<MouseEvent> behaviour;
	
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
	
	
	/**
	 * The 'layer' of the object from the front perspective, can range from 
	 * 0 to arbitrarily high, determines whether the RoomObject image representation
	 * is placed in front of or behind other RoomObjects in the perspective.
	 * 
	 * Is negative 1 if not meant to be rendered in the front perspective.
	 */
	private int layerFront;
	
	/**
	 * The 'layer' of the object from the right perspective, can range from 
	 * 0 to arbitrarily high, determines whether the RoomObject image representation
	 * is placed in front of or behind other RoomObjects in the perspective.
	 * 
	 * Is negative 1 if not meant to be rendered in the right perspective.
	 */
	private int layerRight;
	
	/**
	 * The 'layer' of the object from the back perspective, can range from 
	 * 0 to arbitrarily high, determines whether the RoomObject image representation
	 * is placed in front of or behind other RoomObjects in the perspective.
	 * 
	 * Is negative 1 if not meant to be rendered in the back perspective.
	 */
	private int layerBack;
	
	/**
	 * The 'layer' of the object from the left perspective, can range from 
	 * 0 to arbitrarily high, determines whether the RoomObject image representation
	 * is placed in front of or behind other RoomObjects in the perspective.
	 * 
	 * Is negative 1 if not meant to be rendered in the left perspective.
	 */
	private int layerLeft;
	
	
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
		layerFront = -1;
		layerRight = -1;
		layerBack = -1;
		layerLeft = -1;
	}
	
	public RoomObject(String name) {
		this.name = name;
		display = true;
		layerFront = -1;
		layerRight = -1;
		layerBack = -1;
		layerLeft = -1;
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
	
	/**
	 * Returns the name of the RoomObject.
	 * 
	 * @return     The name of the RoomObject.
	 */
	public String name() {
		return name;
	}
	
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
	 * Sets the layerFront value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the front perspective. 
	 * 
	 * @param layerFront  The new layerFront value.
	 */
	public void setLayerFront(int layerFront) {
		this.layerFront = layerFront;
	}
	
	/**
	 * Sets the layerRight value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the right perspective. 
	 * 
	 * @param layerRight  The new layerRight value.
	 */
	public void setLayerRight(int layerRight) {
		this.layerRight = layerRight;
	}
	
	/**
	 * Sets the layerBack value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the back perspective. 
	 * 
	 * @param layerBack  The new layerBack value.
	 */
	public void setLayerBack(int layerBack) {
		this.layerBack = layerBack;
	}
	
	/**
	 * Sets the layerLeft value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the left perspective. 
	 * 
	 * @param layerLeft  The new layerLeft value.
	 */
	public void setLayerLeft(int layerLeft) {
		this.layerLeft = layerLeft;
	}
	
	
	/** 
	 * Gets the layerFront value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the front perspective. 
	 * 
	 * @return     The value of layerFront
	 */
	public int getLayerFront() {
		return layerFront;
	}
	
	/** 
	 * Gets the layerRight value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the right perspective. 
	 * 
	 * @return     The value of layerRight
	 */
	public int getLayerRight() {
		return layerRight;
	}
	
	/** 
	 * Gets the layerBack value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the back perspective. 
	 * 
	 * @return     The value of layerBack
	 */
	public int getLayerBack() {
		return layerBack;
	}
	
	/** 
	 * Gets the layerLeft value for the RoomObject, which determines in what position (on top or behind) it is rendered
	 * relative to other RoomObjects in the left perspective. 
	 * 
	 * @return     The value of layerLeft
	 */
	public int getLayerLeft() {
		return layerLeft;
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
		if (node != null) {
			node.setVisible(false);
		}
		this.display = false;
	}
	
	/**
	 * Returns a boolean representing whether the object is hidden or otherwise.
	 * 
	 * @return     True if the RoomObject is hidden, false otherwise.
	 */
	public boolean isHidden() {
		return !(display);
	}
	
	/**
	 * Setup method. Gives the particular RoomObject its unique on-click behaviour.
	 * 
	 * @param behaviour  The behaviour of the RoomObject upon being clicked.
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
				if (GameUtil.needsScaling()) {
					frontSprite = new Image(new FileInputStream(frontSpritePath), GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							                GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					frontSprite = new Image(new FileInputStream(frontSpritePath));
				}
			} catch (Exception e) {
				frontSprite = null;
				System.err.println("Error loading front sprite for " + name);
			}
		}
		if (rightSpritePath != null) {
			try {
				if (GameUtil.needsScaling()) {
					rightSprite = new Image(new FileInputStream(rightSpritePath), GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							                GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					rightSprite = new Image(new FileInputStream(rightSpritePath));
				}
			} catch (Exception e) {
				rightSprite = null;
				System.err.println("Error loading right sprite for " + name);
			}
		}
		if (backSpritePath != null) {
			try {
				if (GameUtil.needsScaling()) {
					backSprite = new Image(new FileInputStream(backSpritePath), GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							                GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					backSprite = new Image(new FileInputStream(backSpritePath));
				}
			} catch (Exception e) {
				backSprite = null;
				System.err.println("Error loading back sprite for " + name);
			}
		}
		if (leftSpritePath != null) {
			try {
				if (GameUtil.needsScaling()) {
					leftSprite = new Image(new FileInputStream(leftSpritePath), GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							                GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					leftSprite = new Image(new FileInputStream(leftSpritePath));
				}
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
			if (behaviour != null) {
				node.setOnMouseClicked(behaviour);
			}
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
			if (behaviour != null) {
				node.setOnMouseClicked(behaviour);
			}
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
			if (behaviour != null) {
				node.setOnMouseClicked(behaviour);
			}
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
			if (behaviour != null) {
				node.setOnMouseClicked(behaviour);
			}
			return node;
		} else {
			return null;
		}
	}
}
