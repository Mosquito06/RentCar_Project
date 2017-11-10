package kr.or.dgit.RentCar_Project.dto;

import java.util.Arrays;

public class CarData {
	private String carCode;
	private String carName;
	private byte[] carImage;
	private int carOld;
	private int carNumber;
	private IsAuto isAuto;
	private String carSeater;
	private CarModel carModelCode;
	private Manufacturer manufacturerCode;
	private Fuel fuelCode;

	public CarData(String carCode, String carName, byte[] carImage, int carOld, int carNumber, IsAuto isAuto,
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

	public byte[] getCarImage() {
		return carImage;
	}

	public void setCarImage(byte[] carImage) {
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
		if(isAuto==null) {
			return String.format(
					"%s %s %s %s %s %s %s %s %s %s",
					carCode, carName, Arrays.toString(carImage), carOld, carNumber, isAuto, carSeater, carModelCode,
					manufacturerCode, fuelCode);
		}
		return String.format(
				"%s %s %s %s %s %s %s %s %s %s",
				carCode, carName, Arrays.toString(carImage), carOld, carNumber, isAuto, carSeater, carModelCode,
				manufacturerCode, fuelCode);
	}

}
