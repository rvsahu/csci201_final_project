package fpModel;

import java.util.List;
import java.util.ArrayList;

public abstract class ContainerObject extends RoomObject {
	private List<Item> items;
	
	public ContainerObject() {
		items = new ArrayList<Item>();
	}
	
	public ContainerObject(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public boolean hasItems() {
		return items.isEmpty();
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void removeItem(Item item) {
	}
	
	public abstract Item takeItem(int itemIndex);
	
}
