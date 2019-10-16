package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	/** サーバー名 */
	private static final String URL = "jdbc:mysql://localhost:3306/20160601_EmployeeManagementSystem?useSSL=false";
	/** ユーザー名 */
	private static final String USER = "mysql";
	/** パスワード */
	private static final String PASSWORD = "Mysql@0001";

	/**
	 * DB接続を取得
	 * @return
	 */
	public static synchronized Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return con;
	}

}
