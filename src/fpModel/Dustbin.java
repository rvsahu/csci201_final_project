package fpModel;

import java.util.List;

public class Dustbin extends ContainerObject {

	public Dustbin() {
		// TODO Auto-generated constructor stub
	}

	public Dustbin(List<Item> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public Dustbin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Dustbin(String name, List<Item> items) {
		super(name, items);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item takeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasInfo() {
		// TODO Auto-generated method stub
		return false;
	}

}
