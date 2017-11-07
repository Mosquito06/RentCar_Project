package kr.or.dgit.RentCar_Project.dto;

public class Fuel {
	private String fuelCode;
	private String fuelName;

	public Fuel(String fuelCode, String fuelName) {
		super();
		this.fuelCode = fuelCode;
		this.fuelName = fuelName;
	}

	public Fuel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFuelCode() {
		return fuelCode;
	}

	public void setFuelCode(String fuelCode) {
		this.fuelCode = fuelCode;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	@Override
	public String toString() {
		return String.format("Fuel %s, %s", fuelCode, fuelName);
	}

}
