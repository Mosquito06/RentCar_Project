package kr.or.dgit.RentCar_Project.dto;

public class Fuel {
	private String fuelCode;
	private String fuelType;

	public Fuel(String fuelCode, String fuelType) {
		super();
		this.fuelCode = fuelCode;
		this.fuelType = fuelType;
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

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return String.format("%s", getToString());
	}

	private Object getToString() {
		if(fuelCode==null) {
			return fuelType;
		}else if(fuelType == null){
			return fuelCode;
		}else {
			
		}
		
		
		return null;
	}

}
