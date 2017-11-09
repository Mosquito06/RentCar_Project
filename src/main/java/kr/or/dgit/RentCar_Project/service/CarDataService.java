package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.CarDataDao;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class CarDataService implements CarDataDao {
	private static final CarDataService INSTANCE = new CarDataService();
	private CarDataDao carDataDao;
	
	public static CarDataService getInstance() {
		return INSTANCE;
	}
	
	private CarDataService() {}

	@Override
	public void insertCarData(CarData carData) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.insertCarData(carData);
			sqlSession.commit();
		}
	}

	@Override
	public void updateCarData(CarData carData) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.updateCarData(carData);
			sqlSession.commit();
		}
	}

	@Override
	public void deleteCarData(CarData carDataCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.deleteCarData(carDataCode);
			sqlSession.commit();
		}
		
	}

	@Override
	public CarData selectCarDataByCarDataCode(CarData carDataCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByCarDataCode(carDataCode);
		}
	}

	@Override
	public List<CarData> selectCarDataByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByAll();
		}
	}
	
	

}
