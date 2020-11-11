package fpModel;

import java.util.List;

public class KeyObject extends WrapperObject {
	public KeyObject() {
		super("key_obj", new Item("key"));
	}
	
	public KeyObject(String name) {
		super(name, new Item("key"));
	}
	
	public KeyObject(String name, String itemName) {
		super(name, new Item(itemName));
	}
}
