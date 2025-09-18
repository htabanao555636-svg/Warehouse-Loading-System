package hampri;

public class Item {
	private String code;
	private String name;
	private int qty;



	public Item (String code, String name, int qty2) {
		this.code=code;
		this.name=name;
		this.qty=qty2;
	}

	@Override
	public String toString() {
		return code + " | "+ name + " | " + qty;
	}
}

