package fpModel;

public class Couch extends RoomObject{

	boolean standable = false;
	
	@Override
	public boolean hasItems() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasInfo() {
		// TODO Auto-generated method stub
		return false;
	}


	public void standable() {
		standable = true;
	}
}