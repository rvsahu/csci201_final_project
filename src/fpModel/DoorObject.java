package fpModel;

public class DoorObject extends RoomObject {
<<<<<<< HEAD
	
	public Doorway doorway;
	
	DoorObject(Doorway doorway, Room myroom)
	{
		super("doorway");
		this.doorway = doorway;
		
	}
=======

	public DoorObject() {
		// TODO Auto-generated constructor stub
	}

	public DoorObject(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

>>>>>>> 2bd3f6fe5f390506dfca93013a3441ea7673c31b
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
