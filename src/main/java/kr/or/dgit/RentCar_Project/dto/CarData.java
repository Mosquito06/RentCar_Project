package kr.or.dgit.RentCar_Project.dto;

import java.util.Arrays;

public class CarData {
	private String carCode;
	private String carName;
	private byte[] carImg;
	private int carOld;
	private int carNumder;
	private IsAuto isAuto;
	private String carSeater;
	private CarModel carModelCode;
	private Manufacturer manufacturerCode;
	private Fuel fuelCode;

	public CarData(String carCode, String carName, byte[] carImg, int carOld, int carNumder, IsAuto isAuto,
			String carSeater, CarModel carModelCode, Manufacturer manufacturerCode, Fuel fuelCode) {
		super();
		this.carCode = carCode;
		this.carName = carName;
		this.carImg = carImg;
		this.carOld = carOld;
		this.carNumder = carNumder;
		this.isAuto = isAuto;
		this.carSeater = carSeater;
		this.carModelCode = carModelCode;
		this.manufacturerCode = manufacturerCode;
		this.fuelCode = fuelCode;
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

	public byte[] getCarImg() {
		return carImg;
	}

	public void setCarImg(byte[] carImg) {
		this.carImg = carImg;
	}

	public int getCarOld() {
		return carOld;
	}

	public void setCarOld(int carOld) {
		this.carOld = carOld;
	}

	public int getCarNumder() {
		return carNumder;
	}

	public void setCarNumder(int carNumder) {
		this.carNumder = carNumder;
	}

	public IsAuto isAuto() {
		return isAuto;
	}

	public void setAuto(IsAuto isAuto) {
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
		return String.format("CarData %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", carCode, carName,
				Arrays.toString(carImg), carOld, carNumder, isAuto, carSeater, carModelCode, manufacturerCode,
				fuelCode);
	}

}
