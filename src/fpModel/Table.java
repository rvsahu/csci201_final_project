package fpModel;

public class Table extends RoomObject{
	
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
