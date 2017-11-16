package kr.or.dgit.RentCar_Project.dto;

public class UserGrade {
	private String grade;
	private int discount;
	private int comboType=0;
	
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
	
	public void setComboType(int comboType) {
		this.comboType = comboType;
	}
	
	@Override
	public String toString() {
		if(comboType==0) {
			return String.format("%s, %s", grade, discount);
		}else if(comboType==1) {
			return String.format("%s", grade);
		}else {
			return String.format("%s", discount);
		}
	}

	public Object[] toArray() {
		return new Object[] {grade,discount};
	}

	

}
