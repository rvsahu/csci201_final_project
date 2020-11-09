package fpModel;

import java.util.List;
import java.util.ArrayList;

public class Inventory {
	private List<Item> inventory;
	private int capacity; //maybe not necessary? 
	
	public Inventory() {
		inventory = new ArrayList<Item>();
	}
	
	public boolean addItem(Item newItem) {
		if (inventory.size() == capacity)
			return false;
		inventory.add(newItem);
		return true;
	}
	
	public boolean removeItem(Item removeItem) {
		int slotIndex = inventory.indexOf(removeItem);
		if (slotIndex >= 0) { 
			removeItem(slotIndex);
			return true;
		}
		return false;
	}
	
	public Item removeItem(int slotIndex) {
		return inventory.remove(slotIndex);
	}
}
