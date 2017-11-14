package kr.or.dgit.RentCar_Project.dao;

import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Rent;

public interface RentDao {
	void insertRent(Rent rent);
	void updateRent(Rent rent);
	void deleteRent(Rent rent);
	List<Rent> selectRentByUserCode(Rent rent);
	List<Rent> selectRentByAll();
	List<Rent> selectRentJoinCarData(Rent rent);
}
