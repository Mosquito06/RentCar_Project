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
	private String addr;
	private int comboType = 0;

	public User(int userCode, String id, String pw, String userName, byte[] userImg, String phone, String email,
			Gender gender, UserGrade grade, String addr) {
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
		this.addr = addr;
	}

	public User() {
		super();
	}

	public User(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public User(String id, String pw, String userName, byte[] userImg, String phone, String email, Gender gender, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.userImg = userImg;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.addr = addr;
	}

	public User(int userCode) {
		super();
		this.userCode = userCode;
	}
	
	

	public User(String id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public User(int userCode, String id, String userName, String phone, String email, Gender gender, UserGrade grade) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.grade = grade;
	}

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

	public UserGrade getGrade() {
		return grade;
	}

	public void setGrade(UserGrade grade) {
		this.grade = grade;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setComboType(int comboType) {
		this.comboType = comboType;
	}

	@Override
	public String toString() {
		if (comboType == 0) {
			return String.format("%s", userCode);
		} else if (comboType == 1) {
			return String.format("%s", gender);
		} else {
			return String.format("User %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", userCode, id, pw, userName,
					Arrays.toString(userImg), phone, email, gender, grade, addr);
		}

	}

	public Object[] toArray() {
		return new Object[] { userCode, id, userName, addr, phone, email, gender, grade.getGrade(), addr };
	}

	public String toStringId() {
		return String.format("%s", id);
	}
	
	public String toStringPw() {
		return String.format("%s", pw);
	}

}
