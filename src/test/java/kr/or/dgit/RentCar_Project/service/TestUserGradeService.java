package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.UserGrade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserGradeService {
	private static UserGradeService userGradeService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userGradeService = userGradeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userGradeService = null;
	}

	@Test
	public void test1InsertUserGrade() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("E");
		userGrade.setDiscount(1);
		
		userGradeService.insertUserGrade(userGrade);
		
	}
	
	
	@Test
	public void test2FindSelectUserGradeByGrade() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("C");
		
		UserGrade findUserGrade = userGradeService.selectUserGradeByGrade(userGrade);
		Assert.assertNotNull(findUserGrade);
	}
	
	@Test
	public void test3FindSelectUserGradeByAll() {
		List<UserGrade> list = userGradeService.selectUserGradeByAll();
		Assert.assertNotNull(list);
		
	}
	
	@Test
	public void test4UpdeteUserGradeByGrade() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("E");
		userGrade.setDiscount(0);
		
		userGradeService.updateUserGrade(userGrade);
	}
	
	@Test
	public void test5DeleteUserGradeByGrade() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("D");
	
		userGradeService.deleteUserGrade(userGrade);
	}
	

}
