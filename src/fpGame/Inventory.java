package fpGame;

import java.util.List;

import fpModel.Item;

import java.util.ArrayList;

public class Inventory {
	private List<Item> inventory;
	private int capacity; //maybe not necessary? 
	
	public Inventory() {
		inventory = new ArrayList<Item>();
		capacity = Integer.MAX_VALUE;
	}
	
	public Inventory(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Item> getUnderlyingList() {
		return inventory;
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
	
	public boolean contains(String itemName) {
		for (Item i : inventory) {
			if (i.name().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(Item item) {
		return inventory.contains(item);
	}
	
	public int checkNumberOfItem(String itemName) {
		int ret = 0;
		for(int i = 0;i <inventory.size();i++) {
			if(inventory.get(i).name().equals(itemName))
				ret += 1;
		}
		return ret;
	}
	
	public Item getItem(String item) {
		for(int i = 0;i <inventory.size();i++)
		{
			if(inventory.get(i).name() == item)
				return inventory.get(i);
		}
		return null;
	}
	
	public Item getItem(int index) {
		if (index >= inventory.size()) {
			return null;
		}
		return inventory.get(index);
	}
	
	public Item removeItem(int slotIndex) {
		return inventory.remove(slotIndex);
	}
	
	public int size() {
		return inventory.size();
	}
	
	public int capacity() {
		return capacity;
	}
	
	public void addItems(List<Item> items) {
		int i1;
		for (i1 = 0; i1 < items.size(); i1 += 1) {
			boolean noSpace = addItem(items.get(i1));
			if (noSpace) {
				break;
			}
		}
		for (int i2 = 0; i2 < i1; i2 += 1) {
			items.remove(i2);
		}
	}
	
	/**
	 * Generates and returns a string representation of the inventory.
	 * 
	 * @return     A string representation of the item list.
	 */
	public String stringRep() {
		String rep = "";
		for (Item item : inventory) {
			rep += item.name() + "\n";
		}
		return rep;
	}
}
