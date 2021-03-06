package kr.or.dgit.RentCar_Setting.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.Gender;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.UserService;
import kr.or.dgit.RentCar_Setting.Config;
import kr.or.dgit.RentCar_Setting.dao.DatabaseDao;

public class ImportService implements DbService {
	private static final ImportService instance = new ImportService();

	public static ImportService getInstance() {
		return instance;
	}

	private ImportService() {
		super();
	}

	@Override
	public void service() {
		DatabaseDao.getInstance().executeUpdateSQL("SET FOREIGN_KEY_CHECKS = 0");
		DatabaseDao.getInstance().executeUpdateSQL("use " + Config.DB_NAME);
		for (String tableName : Config.TABLE_NAME) {
			if(tableName.equals("user")) {
				UserDao userDao = UserService.getInstance();
				User[] userItem = new User[3];
				UserGrade userGrade = new UserGrade();
				userGrade.setGrade("C");
				
				userItem[0] = new User(1, "RENTHAJO001", "1234567890", "최다희", getImg("User5"), "010-1111-2222", "최다희@naver.com", Gender.FEMALE, userGrade,"대구/j");
				userItem[1] = new User(2, "rkd0519", "123123123", "이강현", getImg("User1"), "010-9287-3004", "rkd7327@naver.com", Gender.MALE, userGrade,"(39901) 경상북도 칠곡군 평장7길 11/강현이네 집");
				userItem[2] = new User(3, "RENTHAJO003", "1234567890", "김동환", getImg("User1"), "010-1111-2222", "skykim10908@naver.com", Gender.MALE, userGrade,"(38652) 경상북도 경산시 정평길 5 / 동환이네 집");
				
				for(int i = 0;i < userItem.length; i++) {
					userDao.insertUser(userItem[i]);
				}return;
			}
			
			DatabaseDao.getInstance().executeUpdateSQL(String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s ",
					Config.getFilePath(tableName, false), tableName));
		}
		DatabaseDao.getInstance().executeUpdateSQL("SET FOREIGN_KEY_CHECKS = 1");
	}

	private byte[] getImg(String imgName) {
		byte[] img = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\userBig\\" + imgName + ".png");
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
	}

}
