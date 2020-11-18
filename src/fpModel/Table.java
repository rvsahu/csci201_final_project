package fpModel;

import java.util.List;

public class Table extends ContainerObject{
	
	public Table() {
		super("default_table");
	}
	
	public Table(List<Item> items) {
		super(items);
	}

	public Table(String name) {
		super(name);
	}

	public Table(String name, List<Item> items) {
		super(name, items);
	}

	
	@Override
	public Item removeItem(int itemIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
