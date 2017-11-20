package kr.or.dgit.RentCar_Project.dto;

import java.util.Arrays;

public class CarData {
	private String carCode;
	private String carName;
	private String carImage;
	private int carOld;
	private int carNumber;
	private IsAuto isAuto;
	private String carSeater;
	private CarModel carModelCode;
	private Manufacturer manufacturerCode;
	private Fuel fuelCode;
	private int comboType = 0;

	public void setComboType(int comboType) {
		this.comboType = comboType;
	}

	public CarData(String carCode, String carName, String carImage, int carOld, int carNumber, IsAuto isAuto,
			String carSeater, CarModel carModelCode, Manufacturer manufacturerCode, Fuel fuelCode) {
		super();
		this.carCode = carCode;
		this.carName = carName;
		this.carImage = carImage;
		this.carOld = carOld;
		this.carNumber = carNumber;
		this.isAuto = isAuto;
		this.carSeater = carSeater;
		this.carModelCode = carModelCode;
		this.manufacturerCode = manufacturerCode;
		this.fuelCode = fuelCode;
	}

	public int getComboType() {
		return comboType;
	}

	public CarData(String carCode) {
		super();
		this.carCode = carCode;
	}

	public CarData(String carCode, String carName) {
		super();
		this.carCode = carCode;
		this.carName = carName;
	}

	public CarData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public int getCarOld() {
		return carOld;
	}

	public void setCarOld(int carOld) {
		this.carOld = carOld;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public IsAuto getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(IsAuto isAuto) {
		this.isAuto = isAuto;
	}

	public String getCarSeater() {
		return carSeater;
	}

	public void setCarSeater(String carSeater) {
		this.carSeater = carSeater;
	}

	public CarModel getCarModelCode() {
		return carModelCode;
	}

	public void setCarModelCode(CarModel carModelCode) {
		this.carModelCode = carModelCode;
	}

	public Manufacturer getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(Manufacturer manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public Fuel getFuelCode() {
		return fuelCode;
	}

	public void setFuelCode(Fuel fuelCode) {
		this.fuelCode = fuelCode;
	}

	@Override
	public String toString() {
		if (comboType == 0) {
			return String.format("%s", carCode);
		} else if (comboType == 1) {
			return String.format("%s", carName);
		} else if (comboType == 2) {
			return String.format("%s", carOld);
		} else if (comboType == 3) {
			return String.format("%s", carSeater);
		} else {
			return String.format("%s %s %s %s %s %s %s %s %s %s %s", carCode, carName, carImage, carOld, carNumber,
					isAuto, carSeater, carModelCode, manufacturerCode, fuelCode, comboType);
		}
	}

	public Object[] toArray() {
		return new Object[] { carCode, carName, carOld, carNumber, isAuto, carSeater, carModelCode.getCarModelCode(),
				manufacturerCode.getManufacturerCode(), fuelCode.getFuelCode() };
	}

}
