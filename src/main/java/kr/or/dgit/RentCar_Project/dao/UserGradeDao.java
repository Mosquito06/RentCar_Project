package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.UserGrade;

public interface UserGradeDao {
	
	void insertUserGrade(UserGrade userGrade);
	void updateUserGrade(UserGrade userGrade);
	void deleteUserGrade(UserGrade userGrade);
	UserGrade selectUserGradeByGrade(UserGrade grade);
	List<UserGrade> selectUserGradeByAll();
}
