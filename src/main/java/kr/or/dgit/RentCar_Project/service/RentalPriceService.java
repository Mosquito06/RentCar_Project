package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.RentalPriceDao;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class RentalPriceService implements RentalPriceDao {
	
	private static final RentalPriceService instance = new RentalPriceService();
	private RentalPriceDao rentalPriceDao;
	
	
	public static RentalPriceService getInstance() {
		return instance;
	}
	
	private RentalPriceService() {}

	@Override
	public void insertRentalPrice(RentalPrice rentalPrice) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			rentalPriceDao.insertRentalPrice(rentalPrice);
			sqlSession.commit();
		}

	}

	@Override
	public void updateRentalPrice(RentalPrice rentalPrice) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			rentalPriceDao.updateRentalPrice(rentalPrice);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "수정되었습니다");
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "수정을 실패하였습니다");
		}

	}

	@Override
	public void deleteRentalPrice(RentalPrice rentalPrice) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			rentalPriceDao.deleteRentalPrice(rentalPrice);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}


	}

	@Override
	public RentalPrice selectRentalPriceByCarCode(RentalPrice rentalPrice) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			return rentalPriceDao.selectRentalPriceByCarCode(rentalPrice);
		}
	}

	@Override
	public List<RentalPrice> selectRentalPriceByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			return rentalPriceDao.selectRentalPriceByAll();
		}
	}

	@Override
	public RentalPrice selectRentalPriceByCarCodeString(String code) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			return rentalPriceDao.selectRentalPriceByCarCodeString(code);
		}
	}

	@Override
	public List<RentalPrice> findRentalPriceCarCode(RentalPrice rentalPrice) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			rentalPriceDao = sqlSession.getMapper(RentalPriceDao.class);
			return rentalPriceDao.findRentalPriceCarCode(rentalPrice);
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다");
			return null;
		}
	}

}
