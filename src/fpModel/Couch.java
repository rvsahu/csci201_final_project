package fpModel;

public class Couch extends RoomObject{

	private boolean standable = false;
	
	public Couch(String name) {
		super(name);
	}
	
	public Couch() {
		super("default_couch");
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
