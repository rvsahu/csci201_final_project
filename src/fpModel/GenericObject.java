package fpModel;

/**
 * Most basic concrete implementation of RoomObject, has no special properties, contains no items or info.
 */
public class GenericObject extends RoomObject {
	public GenericObject(String name) {
		super(name);
	}
	
	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return false;
	}

	@Override public boolean wrapsItem() {
		return false;
	}
}
