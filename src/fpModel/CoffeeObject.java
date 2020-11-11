package fpModel;

import java.util.List;

public class CoffeeObject extends ContainerObject{
	public CoffeeObject() {
		//nothing
	}

	public CoffeeObject(List<Item> items) {
		super(items);
	}

	public CoffeeObject(String name) {
		super(name);
	}

	public CoffeeObject(String name, List<Item> items) {
		super(name, items);
	}
	
	@Override
	public Item removeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
