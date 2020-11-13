package fpModel;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class RoomObject {
	/*
	 * Graphic variables 
	 */
	
	/**
	 * The file path to the sprite/image of the object
	 */
	private String spritePath; 
	
	/**
	 * The x position of the RoomObject
	 */
	private int xPos;
	
	/**
	 * The y position of the RoomObject
	 */
	private int yPos;
	
	/**
	 * The behaviour of the RoomObject when clicked
	 */
	private EventHandler<MouseEvent> behaviour;
	
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
		xPos = 0;
		yPos = 0;
		display = true;
	}
	
	public RoomObject(String name) {
		this.name = name;
		xPos = 0;
		yPos = 0;
		display = true;
	}
	
	public RoomObject(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		display = true;
	}
	
	public RoomObject(String name, String spritePath) {
		this.name = name;
		this.spritePath = spritePath;
		xPos = 0;
		yPos = 0;
		display = true;
		initialiseImage();
	}
	
	public RoomObject(String name, String spritePath, int xPos, int yPos) {
		this.name = name;
		this.spritePath = spritePath;
		this.xPos = xPos;
		this.yPos = yPos;
		display = true;
		initialiseImage();
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
	 * Graphical method, sets the x and y positions of the object image on the screen
	 */
	public void setPosition(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Sets the x position of the object, and the node if it exists.
	 * @param xPos  The new x position of the object and potentially node
	 */
	public void setXPosition(int xPos) {
		if (node != null) {
			node.setLayoutY(xPos + 0.0);
		}
		this.xPos = xPos;
	}
	
	/**
	 * Sets the y position of the object, and the node if it exists.
	 * @param yPos  The new y position of the object and potentially node
	 */
	public void setYPosition(int yPos) {
		if (node != null) {
			node.setLayoutY(yPos + 0.0);
		}
		this.yPos = yPos;
	}
	
	/**
	 * Returns the x position of the node
	 * @return     The x position of the node
	 */
	public int getXPosition() {
		return xPos;
	}
	
	/**
	 * Returns the y position of the node
	 * @return     The y position of the node
	 */
	public int getYPosition() {
		return yPos;
	}
	
	/**
	 * Sets spritePath to given String. Doesn't change image in node if already initialised, must call initialiseImage
	 * afterwards for that.
	 * 
	 * @param spritePath  The String containing the file path of the sprite/image file
	 */
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
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
	 * Initialises the graphical representation of the RoomObject (an ImageView).
	 */
	public void initialiseImage() {
		if (spritePath != null) {
			try {
				//initialise the ImageView iv
 				Image image = new Image(new FileInputStream(spritePath));
				ImageView iv = new ImageView(image);
				//set the right behaviour on the ImageView
				iv.setOnMouseClicked(behaviour);
				//set the position of the ImageView
				iv.setLayoutX(xPos);
				iv.setLayoutY(yPos);
				//initially set as invisible
				iv.setVisible(false);
				//assign iv to node
				node = iv;
			} catch (Exception e) {
				System.err.println("Error loading graphics for: " + name);
			}
		}
	}
	
	
	/**
	 * Game time method. Returns the graphical representation of the Object.
	 */
	public ImageView render() {
		node.setVisible(true);
		return node;
	}
}
