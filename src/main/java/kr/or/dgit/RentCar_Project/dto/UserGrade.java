package kr.or.dgit.RentCar_Project.dto;

public class UserGrade {
	private String grade;
	private int discount;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", grade, discount);
	}
	
	
}
