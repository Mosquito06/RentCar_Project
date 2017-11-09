package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCarDataService {
	private static CarDataService carDataService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		carDataService = carDataService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		carDataService = null;
	}

	@Test
	public void test1InsertCarData() {
		CarData carData = new CarData();
		carData.setCarCode("aaaaa");
		carData.setCarModelCode(new CarModel("RUV", "스포티지"));
		carData.setManufacturerCode(new Manufacturer("K", "KIA"));
		carData.setFuelCode(new Fuel("G", "가솔린"));
		carDataService.insertCarData(carData);
	}
	
	@Test
	public void test2FindSelectCarDataByCarDataCode() {
		CarData carData = new CarData("CC-K-G-001");
		CarData findCarData = carDataService.selectCarDataByCarDataCode(carData);
		
	}
	
	@Test
	public void test3FindSelectCarDataByAll() {
		List<CarData> list = carDataService.selectCarDataByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test4UpdeteCarDataByCarDataCode() {
		CarData carData = new CarData("CC-H-G-006","aa");
		carDataService.updateCarData(carData);
	}
	
	@Test
	public void test5DeletCarDataByCarDataCode() {
		CarData carData = new CarData();
		carData.setCarCode("aaaaa");
		carDataService.deleteCarData(carData);
	}

}
