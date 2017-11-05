package kr.or.dgit.RentCar_Setting.service;

import java.sql.SQLException;

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
			DatabaseDao.getInstance().executeUpdateSQL(String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s ",
					Config.getFilePath(tableName, false), tableName));
		}
		DatabaseDao.getInstance().executeUpdateSQL("SET FOREIGN_KEY_CHECKS = 1");
	}

}
