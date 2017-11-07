package kr.or.dgit.RentCar_Project.dto;

import java.util.Arrays;

public class User {
	private String userCode;
	private String id;
	private String pw;
	private String userName;
	private byte[] userImg;
	private String phone;
	private String email;
	private String gender;
	private UserGrade grade;
	public User(String userCode, String id, String pw, String userName, byte[] userImg, String phone, String email,
			String gender, UserGrade grade) {
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public UserGrade getGrade() {
		return grade;
	}
	public void setGrade(UserGrade grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return String.format(
				"User %s, %s, %s, %s, %s, %s, %s, %s, %s",
				userCode, id, pw, userName, Arrays.toString(userImg), phone, email, gender, grade);
	} 
	
	
}