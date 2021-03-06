package kr.or.dgit.RentCar_Project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.RentCar_Project.dto.Rent;

public interface RentDao {
	void insertRent(Rent rent);
	void updateRent(Rent rent);
	void deleteRent(Rent rent);
	void UserHistoryDelete(Rent rent);
	void UserHistoryUpdate(Rent rent);
	List<Rent> selectRentByUserCode(Rent rent);
	List<Rent> selectRentByAll();
	List<Rent> selectRentByCarCode(Map<String,Object> map);
	List<Rent> selectRentJoinCarData(Rent rent);
	List<Rent> selectPerformenceTotalGroupByCarModel(String FirstMonth, String LastMonth, String setCancel);
	List<Rent> selectPerformenceMonthAndCancelGroupByCarName(String FirstMonth, String LastMonth, String setCancel);
	List<Rent> selectPerformenceGender(String gender, String FirstMonth, String LastMonth);
	List<Rent> selectPerformenceCarModel(String carModel, String FirstMonth, String LastMonth);
	List<Rent> selectPerformenceManufacturer(String manufacturer, String FirstMonth, String LastMonth);
	List<Rent> selectPerformenceFuel(String fuel, String FirstMonth, String LastMonth);
	List<Rent> selectRentByDate(Rent rent);
}
