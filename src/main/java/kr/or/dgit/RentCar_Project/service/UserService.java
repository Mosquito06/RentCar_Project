package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

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
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			userDao.updateUser(user);
			sqlsession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void deleteUser(User user) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			userDao.deleteUser(user);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}


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

	@Override
	public List<User> findUserCodeByUserCode(User userCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			return userDao.findUserCodeByUserCode(userCode);
		}
	}

	@Override
	public User selectUserFindId(User user) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			return userDao.selectUserFindId(user);
		}
	}

	@Override
	public User selectUserFindPw(User user) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userDao = sqlsession.getMapper(UserDao.class);
			return userDao.selectUserFindPw(user);
		}
	}

}
