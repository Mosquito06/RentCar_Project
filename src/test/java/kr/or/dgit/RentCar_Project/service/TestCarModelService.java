package kr.or.dgit.RentCar_Project.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.CarModel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCarModelService {
	private static CarModelService carModelService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		carModelService = carModelService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		carModelService = null;
	}

/*	@Test
	public void test1InsertCarModel() {
		CarModel carmodel = new CarModel("VV", "추가중");
		carModelService.insertCarModel(carmodel);
	}
	
	@Test
	public void test2FindSelectCarModelByCarModelCode() {
		CarModel carmodel = new CarModel("VV", "추가중");
		CarModel findCarModel = carModelService.selectCarModelByCarModelCode(carmodel);
		Assert.assertNotNull(findCarModel);
	}
	
	@Test
	public void test3FindSelectCarModelByAll() {
		List<CarModel> list = carModelService.selectCarModelByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test4UpdeteCarModelByCarModelCode() {
		CarModel carmodel = new CarModel("VV", "수정 중");
		carModelService.updateCarModel(carmodel);
	}
	
	@Test
	public void test5DeleteCarModelByCarModelCode() {
		CarModel carmodel = new CarModel("VV", "수정 중");
		carModelService.deleteCarModel(carmodel);
	}*/

}
