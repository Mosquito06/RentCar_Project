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
import kr.or.dgit.RentCar_Project.dto.Situation;
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

	/*@Test
	public void test1InsertRent() {
		Rent rent = new Rent();
		
		User user = new User();
		user.setUserCode(3);
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(2017, 11, 8);
		
		CarData carDate = new CarData();
		carDate.setCarCode("CC-H-G-002");
		
		rent.setSituation(Situation.RESERVATION);
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
		user.setUserCode(3);
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(2017, 11, 8);
		
		CarData carDate = new CarData();
		carDate.setCarCode("CC-H-G-002");
		
		rent.setSituation(Situation.CANCELLATION);
		rent.setUserCode(user);
		rent.setUserTime("30");
		rent.setIsInsurance(IsInsurance.TRUE);
		rent.setDayStart(dayStart.getTime());
		rent.setFinalPrice(20000);
		rentService.updateRent(rent);
	
	}
	
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
	}*/
	
	/*@Test
	public void test5DeleteRent() {
		Rent rent = new Rent();
		User user= new User();
		user.setUserCode(3);
		rent.setUserCode(user);
		rentService.deleteRent(rent);
	}
	
	@Test
	public void test6SelectRentJoinCarData(){
		User user = new User();
		user.setUserCode(2);
		Rent rent = new Rent();
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(2017, 10, 1);
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayEnd.set(2017, 10, 30);
		
		
		rent.setUserCode(user);
		rent.setDayStart(dayStart.getTime());
		rent.setDayEnd(dayEnd.getTime());
		
		List<Rent> list = rentService.selectRentJoinCarData(rent);
		Assert.assertNotNull(list);
		
		System.out.println(list.size());
		
		for(Rent r : list) {
			System.out.println(r.getCarCode().getFuelCode().getFuelCode()); 
		}
	}*/
	
	/*@Test
	public void test7UserHistoryDelete() {
		Rent rent = new Rent();
		CarData carDate = new CarData();
		carDate.setCarCode("IC-BM-G-001");
		
		rent.setCarCode(carDate);
		rent.setFinalPrice(360000);
		rent.setUserTime("30");
		
		rentService.UserHistoryDelete(rent);
	}*/
	
	/*@Test
	public void test8SelectPerformenceTotal() {
		List<Rent> list = rentService.selectPerformenceTotal();
		Assert.assertNotNull(list);
	}*/
	
	@Test
	public void selectPerformenceGender() {
		List<Rent> list = rentService.selectPerformenceGender("MALE");
		Assert.assertNotNull(list);
	}
}
