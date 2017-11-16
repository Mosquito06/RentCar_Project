package kr.or.dgit.RentCar_Project.dto;

public class RentalPrice {
	private CarData carCode;
	private int basicPrice;
	private int basicTime;
	private int basicTimePrice;
	private int overPrice;
	private int insurance;

	public RentalPrice(CarData carCode, int basicPrice, int basicTime, int basicTimePrice, int overPrice,
			int insurance) {
		super();
		this.carCode = carCode;
		this.basicPrice = basicPrice;
		this.basicTime = basicTime;
		this.basicTimePrice = basicTimePrice;
		this.overPrice = overPrice;
		this.insurance = insurance;
	}

	public RentalPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarData getCarCode() {
		return carCode;
	}

	public void setCarCode(CarData carCode) {
		this.carCode = carCode;
	}

	public int getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}

	public int getBasicTime() {
		return basicTime;
	}

	public void setBasicTime(int basicTime) {
		this.basicTime = basicTime;
	}

	public int getBasicTimePrice() {
		return basicTimePrice;
	}

	public void setBasicTimePrice(int basicTimePrice) {
		this.basicTimePrice = basicTimePrice;
	}

	public int getOverPrice() {
		return overPrice;
	}

	public void setOverPrice(int overPrice) {
		this.overPrice = overPrice;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return String.format(
				"RentalPrice %s, %s, %s, %s, %s, %s",
				carCode, basicPrice, basicTime, basicTimePrice, overPrice, insurance);
	}

	public Object[] toArray() {
		return new Object[] {carCode.getCarCode(),
							String.format("%,d", basicPrice),
							basicTime,
							String.format("%,d", basicTimePrice),
							String.format("%,d",overPrice),
							String.format("%,d",insurance)};
	}

}
