package fpModel;

public class Notebook extends InfoObject {

	public Notebook() {
		super();
	}
	
	public Notebook(String name) {
		super(name);
	}
	
	public Notebook(String name, String info) {
		super(name);
		this.info = info;
	}
}
