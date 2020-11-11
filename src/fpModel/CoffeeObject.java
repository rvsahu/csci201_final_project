package fpModel;

public class CoffeeObject extends WrapperObject {
	public CoffeeObject() {
		super("coffee_obj", new Item("coffee"));
	}
	
	public CoffeeObject(String name) {
		super(name, new Item("coffee"));
	}
	
	public CoffeeObject(String name, String itemName) {
		super(name, new Item(itemName));
	}
}
