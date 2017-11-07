package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.User;

public interface UserDao {
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(String userCode);
	List<User> selectFuelByAll();
}
