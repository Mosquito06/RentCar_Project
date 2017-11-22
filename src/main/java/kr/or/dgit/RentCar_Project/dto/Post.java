package kr.or.dgit.RentCar_Project.dto;

public class Post {
	private String zipCode;
	private String sido;
	private String sigungu;
	private String doro;
	private int building1;
	private String building2;
	private int comboType = 0;


	public Post(String sido, String doro) {
		super();
		this.sido = sido;
		this.doro = doro;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public void setComboType(int comboType) {
		this.comboType = comboType;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public int getBuilding1() {
		return building1;
	}

	public void setBuilding1(int building1) {
		this.building1 = building1;
	}

	public String getBuilding2() {
		return building2;
	}

	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	@Override
	public String toString() {
		if (comboType == 1) {
			return String.format("%s", sido);
		} else {
			return String.format("(%s) %s %s %s %s %s", zipCode, sido, sigungu, doro, building1, building2);
		}

	}

}
