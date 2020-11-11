package fpModel;

import java.util.List;

public class ChocolateObject extends ContainerObject{

	public ChocolateObject() {
		//nothing
	}

	public ChocolateObject(List<Item> items) {
		super(items);
	}

	public ChocolateObject(String name) {
		super(name);
	}

	public ChocolateObject(String name, List<Item> items) {
		super(name, items);
	}
	
	@Override
	public Item removeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
