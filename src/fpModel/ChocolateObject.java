package fpModel;

public class ChocolateObject extends WrapperObject {
	public ChocolateObject() {
		super("chocolate_obj", new Item("chocolate"));
	}
	
	public ChocolateObject(String name) {
		super(name, new Item("chocolate"));
	}
	
	public ChocolateObject(String name, String itemName) {
		super(name, new Item(itemName));
	}
}
