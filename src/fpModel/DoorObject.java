package fpModel;

public class DoorObject extends RoomObject {
	
	public Doorway doorway;
	
	DoorObject(Doorway doorway, Room myroom)
	{
		super("doorway");
		this.doorway = doorway;
		
	}

	public DoorObject() {
		// TODO Auto-generated constructor stub
	}

	public DoorObject(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean wrapsItem() {
		// TODO Auto-generated method stub
		return false;
	}

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

}
