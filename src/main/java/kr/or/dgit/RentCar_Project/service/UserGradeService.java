package kr.or.dgit.RentCar_Project.service;

import java.util.List;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserGrade(UserGrade userGrade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserGrade(String grade) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

}
