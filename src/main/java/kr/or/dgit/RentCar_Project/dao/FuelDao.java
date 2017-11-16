package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Fuel;

public interface FuelDao{
	
	void insertFuel(Fuel fuel);
	void updateFuel(Fuel fuel);
	void deleteFule(Fuel fuelCode);
	Fuel selectFuelByFuelCode(Fuel fuelCode);
	List<Fuel> selectFuelByAll();
	List<Fuel> FindFuelByFuelCode(Fuel fuelCode);
}
 