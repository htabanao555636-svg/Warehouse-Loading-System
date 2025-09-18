package hampri;

public class Truck {

	private String plate;
	private String driver;


	public Truck(String plate, String driver) {
		this.plate=plate;
		this.driver=driver;

	}
	@Override
	public String toString() {
		return plate + " | "+ driver;
	}
}
