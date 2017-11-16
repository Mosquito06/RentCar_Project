package kr.or.dgit.RentCar_Project.dto;

public class CarModel {
	private String carModelCode;
	private String carModel;
	private int comboType=0;
	
	public CarModel(String carModelCode, String carModel) {
		super();
		this.carModelCode = carModelCode;
		this.carModel = carModel;
	}

	public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCarModelCode() {
		return carModelCode;
	}

	public void setCarModelCode(String carModelCode) {
		this.carModelCode = carModelCode;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public void setComboType(int comboType) {
		this.comboType = comboType;
	}
	@Override
	public String toString() {
		if(comboType==0) {
			return String.format("%s", carModelCode);
		}else if(comboType==1){
			return String.format("%s", carModel);
		}else {
			return String.format("CarModel %s, %s", carModelCode, carModel);
		}
		
	}

	public Object[] toArray() {
		return new Object[] {carModelCode,carModel};
	}

}
