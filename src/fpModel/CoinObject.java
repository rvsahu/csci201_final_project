package fpModel;

import java.util.List;

public class CoinObject extends WrapperObject {
	public CoinObject() {
		super("coin_obj", new Item("coin"));
	}
	
	public CoinObject(String name) {
		super(name, new Item("coin"));
	}
	
	public CoinObject(String name, String itemName) {
		super(name, new Item(itemName));
	}
}
