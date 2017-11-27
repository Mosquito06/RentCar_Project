package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

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

	private CarDataService() {
	}

	@Override
	public void insertCarData(CarData carData) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.insertCarData(carData);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가를 실패하였습니다");
		}

	}

	@Override
	public void updateCarData(CarData carData) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.updateCarData(carData);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"수정을 실패하였습니다");
		}
	}

	@Override
	public void deleteCarData(CarData carDataCode) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			carDataDao = sqlSession.getMapper(CarDataDao.class);
			carDataDao.deleteCarData(carDataCode);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}

	}

	@Override
	public CarData selectCarDataByCarDataCode(CarData carDataCode) {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByCarDataCode(carDataCode);
		}
	}

	@Override
	public List<CarData> selectCarDataByAll() {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByAll();
		}
	}

	@Override
	public List<CarData> selectCarDataByCarModelCode(String carModelCode) {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByCarModelCode(carModelCode);
		}
	}

	@Override
	public List<CarData> selectCarDataByCarDataCodeList(CarData carDataCode) {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByCarDataCodeList(carDataCode);
		}
	}

	@Override
	public List<CarData> selectCarDataByFuel(String fuel) {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByFuel(fuel);
		}
	}

	@Override
	public List<CarData> selectCarDataByOld() {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByOld();
		}
	}

	@Override
	public List<CarData> selectCarDataBySeater() {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataBySeater();
		}

	}

	@Override
	public List<CarData> selectCarDataByCarValue(CarData carData) {
		try (SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			carDataDao = sqlsession.getMapper(CarDataDao.class);
			return carDataDao.selectCarDataByCarValue(carData);
		}
	}

}
