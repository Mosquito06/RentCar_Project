package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

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
	public void insertCarModel(CarModel carModelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.insertCarModel(carModelCode);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가를 실패하였습니다(중복 존재)");
		}

	}

	@Override
	public void updateCarModel(CarModel carModelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.updateCarModel(carModelCode);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"수정을 실패하였습니다");
		}

	}

	@Override
	public void deleteCarModel(CarModel carModelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			carModelDao = sqlSession.getMapper(CarModelDao.class);
			carModelDao.deleteCarModel(carModelCode);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}

	}

	@Override
	public CarModel selectCarModelByCarModelCode(CarModel carModelCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			carModelDao = sqlsession.getMapper(CarModelDao.class);
			return carModelDao.selectCarModelByCarModelCode(carModelCode);
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
