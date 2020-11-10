package fpModel;

import java.util.List;

public class Dustbin extends ContainerObject {

	public Dustbin() {
		//nothing
	}

	public Dustbin(List<Item> items) {
		super(items);
	}

	public Dustbin(String name) {
		super(name);
	}

	public Dustbin(String name, List<Item> items) {
		super(name, items);
	}
}
