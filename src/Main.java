import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseUtil;


public class Main {

	public static void main(String[] args) throws SQLException {
		Connection conn = DatabaseUtil.getConnection();
	}

}
