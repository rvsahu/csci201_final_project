package fpModel;

public abstract class InfoObject extends RoomObject {
	String info;
	
	public InfoObject() {
		
	}
	
	public InfoObject(String name) {
		super(name);
	}
	
	public InfoObject(String name, String info) {
		super(name);
		this.info = info;
	}

	@Override
	public boolean hasItems() {
		return false;
	}

	@Override
	public boolean hasInfo() {
		return !(info == null || info.equals(""));
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		String temp = new String(info);
		info = null;
		return temp;
	}
}
