package fpModel;

public class Keypad extends RoomObject {	
	public Keypad(String name) {
		super(name);
	}
	
	public Keypad() {
		super("default_keypad");
	}

	@Override public boolean wrapsItem() {
		return false;
	}

	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return false;
	}
}
