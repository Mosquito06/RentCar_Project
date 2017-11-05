package kr.or.dgit.RentCar_Setting.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.RentCar_Setting.Config;
import kr.or.dgit.RentCar_Setting.dao.DatabaseDao;
import kr.or.dgit.RentCar_Setting.jdbc.jdbcUtil;

public class ExportService implements DbService {
	private static final ExportService instance = new ExportService();

	public static ExportService getInstance() {
		return instance;
	}

	private ExportService() {

	}

	@Override
	public void service() {
		DatabaseDao.getInstance().executeUpdateSQL("USE " + Config.DB_NAME);
		checkBackupDir();
		for (String tblName : Config.TABLE_NAME) {
			exportData(String.format("select * from %s", tblName), Config.getFilePath(tblName, true), tblName);
		}

	}

	private void checkBackupDir() {
		File backupDir = new File(Config.EXPORT_DIR);

		if (backupDir.exists()) {
			for (File file : backupDir.listFiles()) {
				file.delete();
				System.out.printf("%s Delete Success! %n", file.getName());
			}
		} else {
			backupDir.mkdir();
			System.out.printf("%s make dir Success! %n", Config.EXPORT_DIR);
		}
	}

	private void exportData(String sql, String exportPath, String tblName) {
		StringBuilder sb = new StringBuilder();
		OutputStreamWriter dos = null;
		
		try(ResultSet rs = DatabaseDao.getInstance().executeQuerySQL(sql);) {
			int colCnt = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= colCnt; i++) {
					sb.append(rs.getObject(i) + ",");
				}
				sb.replace(sb.length() - 1, sb.length(), ""); 
																
				sb.append("\r\n");
			}

			backupFileWrite(sb.toString(), exportPath);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(dos);
		}
	}

	private void backupFileWrite(String str, String exportPath)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (OutputStreamWriter dos = new OutputStreamWriter(new FileOutputStream(exportPath), "UTF-8")) {
			dos.write(str);
		}
	}

}
