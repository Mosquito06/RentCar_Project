package kr.or.dgit.RentCar_Project.dto;

import java.util.Arrays;

public class User {
	private int userCode;
	private String id;
	private String pw;
	private String userName;
	private byte[] userImg;
	private String phone;
	private String email;
	private Gender gender;
	private UserGrade grade;
	private int comboType = 0;
	
	public User(int userCode, String id, String pw, String userName, byte[] userImg, String phone, String email,
			Gender gender, UserGrade grade) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.userImg = userImg;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.grade = grade;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getUserImg() {
		return userImg;
	}

	public void setUserImg(byte[] userImg) {
		this.userImg = userImg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserGrade getGrade() {
		return grade;
	}

	public void setGrade(UserGrade grade) {
		this.grade = grade;
	}
	
	public void setComboType(int comboType) {
		this.comboType = comboType;
	}

	@Override
	public String toString() {
		if(comboType==0) {
			return String.format("%s", userCode);
		}else {
			return String.format("User %s, %s, %s, %s, %s, %s, %s, %s, %s", userCode, id, pw, userName,
					Arrays.toString(userImg), phone, email, gender, grade);
		}
	
	}

	public Object[] toArray() {
		return new Object[] {userCode,id,userName,phone,email,gender,grade.getGrade()};
	}

	
}
