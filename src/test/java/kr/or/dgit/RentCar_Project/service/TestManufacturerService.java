package kr.or.dgit.RentCar_Project.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.Manufacturer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestManufacturerService {
	private static ManufacturerService manufacturerService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manufacturerService = manufacturerService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		manufacturerService = null;
	}

	@Test
	public void test1InsertManufacturer() {
		Manufacturer manufacturer = new Manufacturer("BZ", "벤츠");
		
		manufacturerService.insertManufacturer(manufacturer);
	}
	
	@Test
	public void test2FindSelectManufacturerByManufacturerCode() {
		Manufacturer manufacturer = new Manufacturer("BZ", "벤츠");
		
		Manufacturer findmanufacturer = manufacturerService.selectManufacturerByManufacturerCode(manufacturer);
		Assert.assertNotNull(findmanufacturer);
	}

	@Test
	public void test3FindSelectManufacturerByAll() {
		List<Manufacturer> list = manufacturerService.selectManufacturerByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test4UpdeteManufacturerByManufacturerCode() {
		Manufacturer manufacturer = new Manufacturer("BZ", "벤또");
		manufacturerService.updateManufacturer(manufacturer);
	}

	@Test
	public void test5test5DeleteManufacturerByManufacturerCode() {
		Manufacturer manufacturer = new Manufacturer("BZ", "벤또");
		manufacturerService.deleteManufacturer(manufacturer);
	}


}
