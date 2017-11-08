package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class UserService implements UserDao {
	private static final UserService INSTANCE = new UserService();
	private UserDao userDao;
	
	public static UserService getInstance() {
		return INSTANCE;
	}

	private UserService() {
		super();
		
		
	}

	@Override
	public void insertUser(User user) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			userDao.insertUser(user);
			sqlsession.commit();
		}

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User selectUserByUserCode(User user) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			return userDao.selectUserByUserCode(user);
		}
	}

	@Override
	public List<User> selectUserByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			return userDao.selectUserByAll();
		}
	}

}
