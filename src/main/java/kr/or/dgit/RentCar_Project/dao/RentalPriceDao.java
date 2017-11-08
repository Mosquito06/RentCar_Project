package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.RentalPrice;

public interface RentalPriceDao {
	void insertRentalPrice(RentalPrice rentalPrice);
	void updateRentalPrice(RentalPrice rentalPrice);
	void deleteRentalPrice(RentalPrice rentalPrice);
	RentalPrice selectRentalPriceByCarCode(RentalPrice rentalPrice);
	List<RentalPrice> selectRentalPriceByAll();
}
