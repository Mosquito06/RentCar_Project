package kr.or.dgit.RentCar_Project.dto;

public class CarModel {
	private String carModelCode;
	private String carModel;

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

	@Override
	public String toString() {
		return String.format("CarModel %s, %s", carModelCode, carModel);
	}

}
