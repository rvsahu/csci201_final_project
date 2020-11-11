package fpModel;

import java.util.List;

public class Wallet extends ContainerObject{

	public Wallet() {
		//nothing
	}

	public Wallet(List<Item> items) {
		super(items);
	}

	public Wallet(String name) {
		super(name);
	}

	public Wallet(String name, List<Item> items) {
		super(name, items);
	}

	
	@Override
	public Item removeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
