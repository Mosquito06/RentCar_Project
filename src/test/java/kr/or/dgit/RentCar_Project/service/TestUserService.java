package kr.or.dgit.RentCar_Project.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

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

	/*@Test
	public void test1InsertUser() {
		User user = new User();
		user.setId("RENTHAJO004");
		user.setPw("rootrootroot");
		user.setUserName("김민수");
		user.setUserImg(getImg());
		user.setPhone("010-1111-3333");
		user.setEmail("김민수@naver.com");
		user.setGender(Gender.MALE);
		UserGrade ug = new UserGrade();
		ug.setGrade("A");
		user.setGrade(ug);
		
		userService.insertUser(user);
		
	}
	
	@Test
	public void test2FindSelectUserByUserCode() {
		User user = new User();
		user.setUserCode(1);
		
		User findUser = userService.selectUserByUserCode(user);
		Assert.assertNotNull(findUser);
	}*/
	
	/*@Test
	public void test3FindSelectUserByAll() {
		List<User> list = userService.selectUserByAll();
		Assert.assertNotNull(list);
	}*/
	
	/*@Test
	public void test4UpdeteUserByUserCode() {
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade("A");
		
		User user = new User();
		user.setGrade(userGrade);
		user.setUserCode(3);
		userService.updateUser(user);
		
	}
	*/
	/*@Test
	public void test5DeleteUserByUserCode() {
		User user = new User();
		user.setUserCode(13);
		
		userService.deleteUser(user);
		
	}
	
	public byte[] getImg() {
		byte[] img = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\userBig\\user1.png");
		try {
			InputStream is = new FileInputStream(file);
			img = new byte[is.available()];
			is.read(img);
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}*/

}
