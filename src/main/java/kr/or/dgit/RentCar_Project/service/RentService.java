package kr.or.dgit.RentCar_Project.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.RentDao;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class RentService implements RentDao {
	private static final RentService instance = new RentService();
	private RentDao rentDao;
	
	
	public static RentService getInstance() {
		return instance;
	}
	
	
	private RentService() {}


	@Override
	public void insertRent(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			rentDao.insertRent(rent);
			sqlSession.commit();
		}

	}

	@Override
	public void updateRent(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			rentDao.updateRent(rent);
			sqlSession.commit();
		}
	}

	@Override
	public void deleteRent(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			rentDao.deleteRent(rent);
			sqlSession.commit();
		}
	}

	@Override
	public List<Rent> selectRentByUserCode(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectRentByUserCode(rent);
		}
	}

	@Override
	public List<Rent> selectRentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectRentByAll();
		}
	}


	@Override
	public List<Rent> selectRentJoinCarData(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectRentJoinCarData(rent);
		}
	}


	@Override
	public void UserHistoryDelete(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			rentDao.UserHistoryDelete(rent);
			sqlSession.commit();
		}
		
	}


	@Override
	public void UserHistoryUpdate(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			rentDao.UserHistoryUpdate(rent);
			sqlSession.commit();
		}
		
	}


	@Override
	public List<Rent> selectPerformenceTotalGroupByCarModel(String FirstMonth, String LastMonth, String setCancel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceTotalGroupByCarModel(FirstMonth, LastMonth, setCancel);
		}
	}
	
	@Override
	public List<Rent> selectPerformenceMonthAndCancelGroupByCarName(String FirstMonth, String LastMonth, String setCancel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceMonthAndCancelGroupByCarName(FirstMonth, LastMonth, setCancel);
		}
	}
	

	@Override
	public List<Rent> selectPerformenceGender(String gender, String FirstMonth, String LastMonth) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceGender(gender, FirstMonth, LastMonth);
		}
	}


	@Override
	public List<Rent> selectPerformenceCarModel(String carModel, String FirstMonth, String LastMonth) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceCarModel(carModel, FirstMonth, LastMonth);
		}
	}


	@Override
	public List<Rent> selectPerformenceManufacturer(String manufacturer, String FirstMonth, String LastMonth) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceManufacturer(manufacturer, FirstMonth, LastMonth);
		}
	}


	@Override
	public List<Rent> selectPerformenceFuel(String fuel, String FirstMonth, String LastMonth) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectPerformenceFuel(fuel, FirstMonth, LastMonth);
		}
	}


	@Override
	public List<Rent> selectRentByDate(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentDao = sqlSession.getMapper(RentDao.class);
			return rentDao.selectRentByDate(rent);
		}
	}

}
