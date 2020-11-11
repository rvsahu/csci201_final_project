package fpModel;

public abstract class WrapperObject extends RoomObject {
	private Item wrapped;
	
	public WrapperObject(String name) {
		super(name);
	}
	
	public WrapperObject(String name, Item wrapped) {
		super(name);
		this.wrapped = wrapped;
	}

	@Override public boolean wrapsItem() {
		return (wrapped == null);
	}

	@Override public boolean hasItems() {
		return false;
	}

	@Override public boolean hasInfo() {
		return false;
	}
	
	public Item removeItem() {
		Item temp = wrapped;
		wrapped = null;
		super.hide();
		return wrapped;
	}
	
	public Item peekItem() {
		return wrapped;
	}
}
