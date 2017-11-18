package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.ManufacturerDao;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class ManufacturerService implements ManufacturerDao {
	private static final ManufacturerService INSTANCE = new ManufacturerService();
	private ManufacturerDao manufacturerDao;

	public static ManufacturerService getInstance() {
		return INSTANCE;
	}

	private ManufacturerService() {
		super();
	}

	@Override
	public void insertManufacturer(Manufacturer manufacturer) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			manufacturerDao.insertManufacturer(manufacturer);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "추가되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가를 실패하였습니다(중복 존재)");
		}

	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			manufacturerDao.updateManufacturer(manufacturer);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"수정을 실패하였습니다");
		}

	}

	@Override
	public void deleteManufacturer(Manufacturer manufacturerCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			manufacturerDao.deleteManufacturer(manufacturerCode);
			sqlsession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}

	}

	@Override
	public Manufacturer selectManufacturerByManufacturerCode(Manufacturer manufacturerCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			return manufacturerDao.selectManufacturerByManufacturerCode(manufacturerCode);
		}
	}

	@Override
	public List<Manufacturer> selectManufacturerByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			return manufacturerDao.selectManufacturerByAll();
		}
	}

	@Override
	public List<Manufacturer> findManufacturerByFacturerCode(Manufacturer manufacturerCode) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			manufacturerDao = sqlsession.getMapper(ManufacturerDao.class);
			return manufacturerDao.findManufacturerByFacturerCode(manufacturerCode);
		}
	}


}
