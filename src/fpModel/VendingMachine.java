package fpModel;

import java.util.*;

import fpGame.*;

/**
 * 
 * NOTE: LEGACY CLASS, DO NOT USE
 * Only reason this isn't deleted is to come back and reference how the behaviour was written
 * Implement all behaviour for VendingMachine in a behaviour EventHandler 
 *
 */
public abstract class VendingMachine extends ContainerObject {
	/*
	public VendingMachine() {
		super("vending machine");
		List<Item> item = new ArrayList();
		item.add(new Item("chocolate"));
		item.add(new Item("coffee"));
		item.add(new Item("lab 1 key"));
	}
	
	public VendingMachine(String name) {
		super(name);
		List<Item> item = new ArrayList();
		item.add(new Item("chocolate"));
		item.add(new Item("coffee"));
		item.add(new Item("lab 1 key"));
		
	}
	
	@Override public boolean hasItems() {
		return true;
	}

	@Override public boolean hasInfo() {
		return false;
	}
	
	@Override public boolean wrapsItem() {
		return false;
	}
	public boolean foodBuyable(Player p) {
		if(p.getLevel() >= 3) return true;
		return false;
	}
	*/
}
