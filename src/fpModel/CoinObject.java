package fpModel;

import java.util.List;

public class CoinObject extends ContainerObject{
	private CoinItem coin;

	public CoinObject() {
		super("coin_obj");
		coin = new CoinItem("coin");
	}
	
	public CoinObject(String name) {
		super(name);
		coin = new CoinItem("coin");
	}
	
	public CoinObject(String name, List<Item> items) {
		super(name, items);
	}
	
	@Override
	public Item removeItem() {
		CoinItem temp = coin;
		coin = null;
		return temp;
	}
	
	@Override
	public boolean hasItems() {
		return !(coin == null);
	}

}
