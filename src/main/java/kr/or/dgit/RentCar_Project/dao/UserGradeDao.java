package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.UserGrade;

public interface UserGradeDao {
	
	int insertUserGrade(UserGrade userGrade);
	int updateUserGrade(UserGrade userGrade);
	int deleteUserGrade(UserGrade userGrade);
	List<UserGrade> selectUserGradeByAll();
}
