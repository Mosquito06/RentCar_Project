package kr.or.dgit.RentCar_Project.dto;

public class Manufacturer {
	private String manufacturerCode;
	private String manufacturerName;
	private int ComboType = 0;

	public Manufacturer(String manufacturerCode, String manufacturerName) {
		super();
		this.manufacturerCode = manufacturerCode;
		this.manufacturerName = manufacturerName;
	}

	public Manufacturer() {
		super();

	}

	public void setComboType(int comboType) {
		ComboType = comboType;
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
		if (ComboType == 1) {
			return String.format("%s", manufacturerCode);
		}else {
			return String.format("%s", manufacturerName);
		}
	}

	public String toWrite() {
		return String.format("%s", manufacturerName);
	}

}
