package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.Fuel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFuelService {
	
	private static FuelService fuelService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fuelService = FuelService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		fuelService = null;
	}

/*	@Test
	public void test1insertFuel() {
		Fuel fuel = new Fuel();
		fuel.setFuelCode("test1");
		fuel.setFuelName("test1");
		
		fuelService.insertFuel(fuel);
	}
	
	@Test
	public void test2updateFuel() {
		Fuel fuel = new Fuel();
		fuel.setFuelCode("test");
		fuel.setFuelName("test1");
		
		fuelService.updateFuel(fuel);
	}*/
/*	
	@Test
	public void test3deleteFuel() {
		Fuel fuel = new Fuel();
		fuel.setFuelCode("test1");
		fuelService.deleteFule(fuel);
	}*/
	
	@Test
	public void test4FindSelectUserByAll() {
		List<Fuel> list = fuelService.selectFuelByAll();
		Assert.assertNotNull(list);
	} 
	
	@Test
	public void test5FindSelectUserByFuelCode() {
		Fuel fuel = new Fuel("D" , "경유");
		
		
		Fuel fuelCode = fuelService.selectFuelByFuelCode(fuel);
		Assert.assertNotNull(fuelCode);
	} 
	
}
