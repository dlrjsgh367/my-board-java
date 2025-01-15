package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String ID = "system";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Oracle JDBC Driver not found.", e);
		}
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
}