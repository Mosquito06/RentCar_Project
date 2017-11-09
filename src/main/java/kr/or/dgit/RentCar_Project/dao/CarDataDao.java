package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.CarData;

public interface CarDataDao {
	void insertCarData(CarData carData);
	void updateCarData(CarData carData);
	void deleteCarData(CarData carDataCode);
	CarData selectCarDataByCarDataCode(CarData carDataCode);
	List<CarData> selectCarDataByAll();
}
