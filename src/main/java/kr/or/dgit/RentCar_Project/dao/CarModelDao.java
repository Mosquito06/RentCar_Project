package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.CarModel;

public interface CarModelDao {
	void insertCarModel(CarModel carModel);
	void updateCarModel(CarModel carModel);
	void deleteCarModel(CarModel carModelCode);
	CarModel selectCarModelByCarModelCode(CarModel carModelCode);
	List<CarModel> selectCarModelByAll();
}
