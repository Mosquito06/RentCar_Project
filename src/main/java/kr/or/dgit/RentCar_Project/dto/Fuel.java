package kr.or.dgit.RentCar_Project.dto;

public class Fuel {
	private String fuelCode;
	private String fuelType;
	private int comboType = 0;

	public void setComboType(int comboType) {
		this.comboType = comboType;
	}

	public Fuel(String fuelCode, String fuelType) {
		super();
		this.fuelCode = fuelCode;
		this.fuelType = fuelType;
	}
	
	public Fuel(String fuelCode) {
		super();
		this.fuelCode = fuelCode;
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
		if(comboType==0) {
			return String.format("%s",fuelType);
		}else if(comboType==1) {
			return String.format("%s",fuelCode);
		}else {
			return String.format("%s(%s)",fuelCode,fuelType);
		}
		
	}

	public Object[] toArray() {
		return new Object[] {fuelCode,fuelType};
	}
	
	


}
