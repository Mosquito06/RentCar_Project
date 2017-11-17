package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Manufacturer;

public interface ManufacturerDao {
	void insertManufacturer(Manufacturer manufacturer);
	void updateManufacturer(Manufacturer manufacturer);
	void deleteManufacturer(Manufacturer manufacturerCode);
	Manufacturer selectManufacturerByManufacturerCode(Manufacturer manufacturerCode);
	List<Manufacturer> selectManufacturerByAll();
	List<Manufacturer> findManufacturerByFacturerCode(Manufacturer manufacturerCode);
}
