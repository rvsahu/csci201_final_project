package fpModel;

public abstract class Item {
	/**
	 * Item name, used for quick equality comparisons
	 */
	private String name;
	
	/**
	 * Item in-game image file path
	 */
	private String igSpritePath;
	
	/**
	 * Item in-inventory image file path
	 */
	private String invSpritePath;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, String igSpritePath, String invSpritePath) {
		this.name = name;
		this.igSpritePath = igSpritePath;
		this.invSpritePath = invSpritePath;
	}
	
	public void setIGSpritePath(String igSpritePath) {
		this.igSpritePath = igSpritePath;
	}
	
	public void setINVSpritePath(String invSpritePath) {
		this.invSpritePath = invSpritePath;
	}
	
	public String name() {
		return this.name;
	}
	
	public boolean equals(Item other) {
		return name.equals(other.name());
	}
}
