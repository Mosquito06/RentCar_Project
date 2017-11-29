package kr.or.dgit.RentCar_Project.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRentalPriceService {
	
	private static RentalPriceService rentalPriceService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rentalPriceService = RentalPriceService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rentalPriceService = null;
	}

/*	@Test
	public void test1InsertRentalPrice() {
		CarData carDate = new CarData();
		carDate.setCarCode("HC-H-G-003");
		
		RentalPrice rentalPrice = new RentalPrice();
		rentalPrice.setCarCode(carDate);
		rentalPrice.setBasicPrice(10000);
		rentalPrice.setBasicTime(30);
		rentalPrice.setBasicTimePrice(12000);
		rentalPrice.setOverPrice(3000);
		rentalPrice.setInsurance(5000);
		
		rentalPriceService.insertRentalPrice(rentalPrice);
	}
	
	@Test
	public void test1updateRentalPrice() {
		CarData carDate = new CarData();
		carDate.setCarCode("HC-H-G-003");
		
		RentalPrice rentalPrice = new RentalPrice();
		rentalPrice.setCarCode(carDate);
		rentalPrice.setBasicPrice(20000);
		
		rentalPriceService.updateRentalPrice(rentalPrice);
	}
	
	@Test
	public void test2DeleteRentalPrice() {
		CarData carDate = new CarData();
		carDate.setCarCode("HC-H-G-003");
		
		RentalPrice rentalPrice = new RentalPrice();
		rentalPrice.setCarCode(carDate);
		rentalPriceService.deleteRentalPrice(rentalPrice);
	}
	
	@Test
	public void test3SelectRentalPriceByAll() {
		List<RentalPrice> list = rentalPriceService.selectRentalPriceByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test4SelectRentalPriceByCarCode() {
		CarData carData = new CarData();
		carData.setCarCode("CC-H-G-002");
		RentalPrice rentalPrice = new RentalPrice();
		rentalPrice.setCarCode(carData);
		
		rentalPriceService.selectRentalPriceByCarCode(rentalPrice);
	}*/
}
