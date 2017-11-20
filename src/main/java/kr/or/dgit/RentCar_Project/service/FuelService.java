package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.FuelDao;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class FuelService implements FuelDao {
	private static final FuelService INSTANCE = new FuelService();
	private FuelDao fuelDao;
	
	public static FuelService getInstance() {
		return INSTANCE;
	}
	
	private FuelService() {}


	@Override
	public void insertFuel(Fuel fuel){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.insertFuel(fuel);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가를 실패하였습니다");
		}

	}

	@Override
	public void updateFuel(Fuel fuel){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.updateFuel(fuel);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"수정을 실패하였습니다");
		}

	}

	@Override
	public void deleteFule(Fuel fuelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			fuelDao.deleteFule(fuelCode);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}

	}

	@Override
	public Fuel selectFuelByFuelCode(Fuel fuelCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			fuelDao = sqlsession.getMapper(FuelDao.class);
			return fuelDao.selectFuelByFuelCode(fuelCode);
		}
	}

	@Override
	public List<Fuel> selectFuelByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			return fuelDao.selectFuelByAll();
		}	
	}

	@Override
	public List<Fuel> findFuelByFuelCode(Fuel fuelCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			fuelDao = sqlSession.getMapper(FuelDao.class);
			return fuelDao.findFuelByFuelCode(fuelCode);
		}	
	
	}


}
