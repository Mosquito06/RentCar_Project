package kr.or.dgit.RentCar_Setting.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;

	public static DBCon getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	private DBCon() {
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false", "root", "rootroot");
			
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
			
	}

}
