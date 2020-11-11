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
	
	public int CheckNumberOfItem(String item) {
		int ret = 0;
		for(int i = 0;i <inventory.size();i++) {
			if(inventory.get(i).name() == item)ret ++;
		}
		return ret;
	}
	
	public void RemoveNumberOfItem(String item, int r) {
		int slotIndex = 0;
		while(r > 0 && slotIndex < inventory.size()) {
			if(inventory.get(slotIndex).name() == item) inventory.remove(slotIndex);
			slotIndex++;
		}
	}
	
	public Item removeItem(int slotIndex) {
		return inventory.remove(slotIndex);
	}
	
	/*
	 * Graphical methods
	 */
	//INSERT HERE
}
