package fpModel;

public class Phone extends InfoObject{
	public Phone() {
		
	}
	
	public Phone(String name) {
		super(name);
	}
	
	public Phone(String name, String info) {
		super(name);
		this.info = info;
	}

	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return !(info == null || info.equals(""));
	}
	
	@Override public boolean wrapsItem() {
		return false;
	}

}
