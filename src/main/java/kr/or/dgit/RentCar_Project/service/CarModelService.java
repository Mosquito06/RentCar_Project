package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.CarModelDao;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class CarModelService implements CarModelDao {
	private static final CarModelService INSTANCE = new CarModelService();
	private CarModelDao carModelDao;
	
	public static CarModelService getInstance() {
		return INSTANCE;
	}
	
	private CarModelService() {}
	
	@Override
	public void insertCarModel(CarModel fuel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.insertCarModel(fuel);
			sqlSession.commit();
		}

	}

	@Override
	public void updateCarModel(CarModel fuel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.updateCarModel(fuel);
			sqlSession.commit();
		}

	}

	@Override
	public void deleteCarModel(CarModel fuelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.deleteCarModel(fuelCode);
			sqlSession.commit();
		}

	}

	@Override
	public CarModel selectCarModelByCarModelCode(CarModel fuelCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carModelDao = sqlsession.getMapper(CarModelDao.class);
			return carModelDao.selectCarModelByCarModelCode(fuelCode);
		}
	}

	@Override
	public List<CarModel> selectCarModelByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carModelDao = sqlsession.getMapper(CarModelDao.class);
			return carModelDao.selectCarModelByAll();
		}
	}

	@Override
	public List<CarModel> findCarModelByCarModelCode(CarModel carModelCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carModelDao = sqlsession.getMapper(CarModelDao.class);
			return carModelDao.findCarModelByCarModelCode(carModelCode);
		}
	}

}
