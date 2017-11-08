package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.FuelDao;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class FuelService implements FuelDao {
	private static final FuelService instance = new FuelService();
	private FuelDao fuelDao;
	
	public static FuelService getInstance() {
		return instance;
	}
	
	private FuelService() {}


	@Override
	public void insertFuel(Fuel fuel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.insertFuel(fuel);
			sqlSession.commit();
		}

	}

	@Override
	public void updateFuel(Fuel fuel) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.updateFuel(fuel);
			sqlSession.commit();
		}

	}

	@Override
	public void deleteFule(Fuel fuelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.deleteFule(fuelCode);
			sqlSession.commit();
		}

	}

	@Override
	public Fuel selectFuelByFuelCode(Fuel fuelCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fuel> selectFuelByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			return fuelDao.selectFuelByAll();
		}
	
	}

}
