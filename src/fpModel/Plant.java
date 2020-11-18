package fpModel;

public class Plant extends RoomObject {
	public Plant(String string) {
		super(string);
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
