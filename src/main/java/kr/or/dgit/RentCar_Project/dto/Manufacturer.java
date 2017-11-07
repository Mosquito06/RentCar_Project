package kr.or.dgit.RentCar_Project.dto;

public class Manufacturer {
	private String manufacturerCode;
	private String manufacturerName;

	public Manufacturer(String manufacturerCode, String manufacturerName) {
		super();
		this.manufacturerCode = manufacturerCode;
		this.manufacturerName = manufacturerName;
	}

	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	@Override
	public String toString() {
		return String.format("Manufacturer %s, %s", manufacturerCode, manufacturerName);
	}

}
