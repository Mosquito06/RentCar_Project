package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Fuel;

public interface FuelDao {
	
	int insertFuel(Fuel fuel);
	int updateFuel(Fuel fuel);
	int deleteFule(Fuel fuel);
	List<Fuel> selectFuelByAll();
}
