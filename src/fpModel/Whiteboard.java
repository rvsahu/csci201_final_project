package fpModel;

public class Whiteboard extends RoomObject{
	
	@Override public boolean hasItems() {
		return false;
	}
	
	@Override public boolean wrapsItem() {
		return false;
	}
	
	@Override public boolean hasInfo() {
		return false;
	}

}
