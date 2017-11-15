package kr.or.dgit.RentCar_Project.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rent {
	private Situation situation;
	private User userCode;
	private String userTime;
	private IsInsurance isInsurance;
	private Date dayStart;
	private Date dayEnd;
	private int finalPrice;
	private CarData carCode;

	public User getUserCode() {
		return userCode;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
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
		return String.format("Rent %s, %s, %s, %s, %s, %s, %s, %s", situation, userCode, userTime, isInsurance, dayStart, dayEnd,
				finalPrice, carCode);
	}

	public Object[] toArray(Date rent) {
		// 날짜 표기를 위한 SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		return new Object[] {getSituationTostring(rent), carCode.getCarCode(), carCode.getCarName(), carCode.getCarOld(), carCode.getIsAuto(),
				carCode.getCarSeater(), carCode.getFuelCode().getFuelCode(), userTime, isInsurance,
				sdf.format(dayStart), sdf.format(dayEnd), finalPrice };
	}

	private Object getSituationTostring(Date startDate) {
		Date CurrentDate = new Date();
		int CompareDate = startDate.compareTo(CurrentDate);
		
		if(situation.equals(Situation.RESERVATION)) {
			if(CompareDate > 0) {
				return "예약";
			}else {
				return "완료";
			}
		}else if(situation.equals(Situation.COMPLETION)) {
			return "완료";
		}else {
			return "취소";
		}
	}
	

}
