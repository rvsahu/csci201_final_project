package fpModel;

import java.util.List;
import java.util.ArrayList;

public abstract class ContainerObject extends RoomObject {
	/*
	 * Logical Fields
	 */
	
	private List<Item> items;
	
	/*
	 * Constructors
	 */
	
	public ContainerObject() {
		super();
		items = new ArrayList<Item>();
	}
	
	public ContainerObject(List<Item> items) {
		super();
		this.items = items;
	}
	
	public ContainerObject(String name) {
		super(name);
		items = new ArrayList<Item>();
	}
	
	public ContainerObject(String name, List<Item> items) {
		super(name);
		this.items = items;
	}
	
	@Override public boolean hasItems() {
		return (items == null || items.isEmpty());
	}
	
	@Override public boolean hasInfo() {
		return false;
	}
	
	@Override public boolean wrapsItem() {
		return false;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void removeItem(Item item) {
		if (items.contains(item)) {
			items.remove(items.indexOf(item));
		}
	}
	
	public Item removeItem(int itemIndex) {
		return items.remove(itemIndex);
	}
	
	public Item getItem(int itemIndex) {
		return items.get(itemIndex);
	}
}
