package kr.or.dgit.RentCar_Project.service;

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
	public void test1FindSelectUserGradeByGrade() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("C");
		
		UserGrade findUserGrade = userGradeService.selectUserGradeByGrade(userGrade);
		Assert.assertNotNull(findUserGrade);
	}

}
