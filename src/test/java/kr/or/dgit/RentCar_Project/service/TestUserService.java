package kr.or.dgit.RentCar_Project.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.RentCar_Project.dto.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserService {
	private static UserService userService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = userService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userService = null;
	}

	@Test
	public void test1FindSelectUserByUserCode() {
		User user = new User();
		user.setUserCode(1);
		
		User findUser = userService.selectUserByUserCode(user);
		Assert.assertNotNull(findUser);
	}

}
