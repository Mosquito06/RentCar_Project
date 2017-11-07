package kr.or.dgit.RentCar_Project.dto;

import java.util.Date;

public class Rent {
	private User userCode;
	private String userTime;
	private IsInsurance isInsurance;
	private Date dayStart;
	private Date dayEnd;
	private int finalPrice;
	private CarData carCode;
	public Rent(User userCode, String userTime, IsInsurance isInsurance, Date dayStart, Date dayEnd, int finalPrice,
			CarData carCode) {
		super();
		this.userCode = userCode;
		this.userTime = userTime;
		this.isInsurance = isInsurance;
		this.dayStart = dayStart;
		this.dayEnd = dayEnd;
		this.finalPrice = finalPrice;
		this.carCode = carCode;
	}
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUserCode() {
		return userCode;
	}
	public void setUserCode(User userCode) {
		this.userCode = userCode;
	}
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	public IsInsurance getIsInsurance() {
		return isInsurance;
	}
	public void setIsInsurance(IsInsurance isInsurance) {
		this.isInsurance = isInsurance;
	}
	public Date getDayStart() {
		return dayStart;
	}
	public void setDayStart(Date dayStart) {
		this.dayStart = dayStart;
	}
	public Date getDayEnd() {
		return dayEnd;
	}
	public void setDayEnd(Date dayEnd) {
		this.dayEnd = dayEnd;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public CarData getCarCode() {
		return carCode;
	}
	public void setCarCode(CarData carCode) {
		this.carCode = carCode;
	}
	@Override
	public String toString() {
		return String.format("Rent %s, %s, %s, %s, %s, %s",
				userCode, userTime, dayStart, dayEnd, finalPrice, carCode);
	}
	
	
}
