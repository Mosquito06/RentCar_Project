package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dao.UserGradeDao;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class UserGradeService implements UserGradeDao {
	private static final UserGradeService INSTANCE = new UserGradeService();
	private UserGradeDao userGradeDao;
	
	public static UserGradeService getInstance() {
		return INSTANCE;
	}

	private UserGradeService() {
		super();
		
		
	}
	
	
	@Override
	public void insertUserGrade(UserGrade userGrade) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			userGradeDao.insertUserGrade(userGrade);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "추가를 실패하였습니다");
		}

	}

	@Override
	public void updateUserGrade(UserGrade userGrade) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			userGradeDao.updateUserGrade(userGrade);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "수정을 실패하였습니다");
		}

	}

	@Override
	public void deleteUserGrade(UserGrade userGrade) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			userGradeDao.deleteUserGrade(userGrade);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}

	}

	@Override
	public UserGrade selectUserGradeByGrade(UserGrade userGrade) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			return userGradeDao.selectUserGradeByGrade(userGrade);
		}
	}

	@Override
	public List<UserGrade> selectUserGradeByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			return userGradeDao.selectUserGradeByAll();
		}
	}

	@Override
	public List<UserGrade> findUserGradeByGrade(UserGrade userGradeCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			userGradeDao = sqlsession.getMapper(UserGradeDao.class);
			return userGradeDao.findUserGradeByGrade(userGradeCode);
		}
	}

}
