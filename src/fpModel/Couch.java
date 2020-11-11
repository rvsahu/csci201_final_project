package fpModel;

public class Couch extends RoomObject{

	private boolean standable = false;
	
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
	
	public void notStandable() {
		standable = false;
	}
	
	public boolean IsStandable() {
		return standable;
	}
}
