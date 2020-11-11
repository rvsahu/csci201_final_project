package fpModel;

public class Cat extends RoomObject{

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
