package fpModel;

import fpGame.*;

public class Key extends Item {
	public Key(String name) {
		super(name);
	}
	
	public Key(String name, String igSpritePath, String invSpritePath) {
		super(name, igSpritePath, invSpritePath);
	}
	
	public boolean buyable(Player p) {
		if(p.getInventory().CheckNumberOfItem("coin") >= 4) return true;
		return false;
	}
}
