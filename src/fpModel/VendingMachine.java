package fpModel;

import java.util.*;

import fpGame.*;

public class VendingMachine extends ContainerObject{

	
	public VendingMachine()
	{
		List<Item> item = new ArrayList();
		item.add(new ChocolateItem());
		item.add(new CoffeeItem());
		item.add(new Key("lab 1 key"));
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
}
