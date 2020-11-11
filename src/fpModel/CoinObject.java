package fpModel;

import java.util.List;

public class CoinObject extends ContainerObject{

	public CoinObject() {
		//nothing
	}

	public CoinObject(List<Item> items) {
		super(items);
	}

	public CoinObject(String name) {
		super(name);
	}

	public CoinObject(String name, List<Item> items) {
		super(name, items);
	}
	
	@Override
	public Item removeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
