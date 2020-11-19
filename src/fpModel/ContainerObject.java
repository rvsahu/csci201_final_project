package fpModel;

import java.util.List;
import java.util.ArrayList;

public class ContainerObject extends RoomObject {
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
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Returns an index to an item that you are looking for. 
	 * 
	 * @param itemName  The name of the item you are searching for.
	 * @return     The internal index of the first occurance of the desired item, or -1 if the item doesn't in the inventory.
	 */
	public int getItemIndex(String itemName) {
		for (int i = 0; i < items.size(); i += 1) {
			if (items.get(i).name().equals(itemName))
				return i;
		}
		return -1;
	}
}
