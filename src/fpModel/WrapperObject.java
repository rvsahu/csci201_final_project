package fpModel;

/**
 * Concrete implementation of RoomObject, represents an object that is meant to be acquired by the user, e.g coin, key.
 * 
 */
public class WrapperObject extends RoomObject {
	private Item wrapped;
	
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
	
	/**
	 * Returns the wrapped item and hides the WrapperObject. 
	 * 
	 * @return     A reference to the formerly wrapped Item.
	 */
	public Item removeItem() {
		Item temp = wrapped;
		wrapped = null;
		super.hide();
		return temp;
	}
	
	/**
	 * Returns a reference to the wrapped Item without removing it and hiding the WrapperObject.
	 * 
	 * @return     A reference to the wrapped Item.
	 */
	public Item peekItem() {
		return wrapped;
	}
}
