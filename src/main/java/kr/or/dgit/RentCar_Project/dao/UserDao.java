package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.User;

public interface UserDao {
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	User selectUserByUserCode(User user);
	List<User> selectUserByAll();
}
