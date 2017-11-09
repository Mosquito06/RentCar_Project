package kr.or.dgit.RentCar_Project.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.IsInsurance;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRentService {
	
	private static RentService rentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rentService = RentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rentService=null;
	}

/*	@Test
	public void test1InsertRent() {
		Rent rent = new Rent();
		
		User user = new User();
		user.setUserCode(4);
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(2017, 11, 8);
		
		CarData carDate = new CarData();
		carDate.setCarCode("CC-H-G-002");
		
		rent.setUserCode(user);
		rent.setUserTime("30");
		rent.setIsInsurance(IsInsurance.FALSE);
		rent.setDayStart(dayStart.getTime());
		rent.setFinalPrice(10000);
		rent.setCarCode(carDate);
		
		rentService.insertRent(rent);
	}
	
	@Test
	public void test2UpdateRent() {
		Rent rent = new Rent();
		
		User user = new User();
		user.setUserCode(4);
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(2017, 11, 8);
		
		CarData carDate = new CarData();
		carDate.setCarCode("CC-H-G-002");
		
		rent.setUserCode(user);
		rent.setUserTime("30");
		rent.setIsInsurance(IsInsurance.TRUE);
		rent.setDayStart(dayStart.getTime());
		rent.setFinalPrice(20000);
		rentService.updateRent(rent);
	
	}
	
	@Test
	public void test2DeleteRent() {
		Rent rent = new Rent();
		User user= new User();
		user.setUserCode(4);
		rent.setUserCode(user);
		rentService.deleteRent(rent);
	}*/
	
	@Test
	public void test3SelectRentByAll(){
		List<Rent> list = rentService.selectRentByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test4SelectRentByUserCode() {
		User user = new User();
		user.setUserCode(1);
		
		Rent rent = new Rent();
		rent.setUserCode(user);
		
		rentService.selectRentByUserCode(rent);
	}
}
