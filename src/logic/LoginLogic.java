package logic;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionManager;
import dao.EmployeeDAO;
import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;

public class LoginLogic {

	public EmployeeBean login(String id) throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		EmployeeBean emp = null;

		try {
			//DB接続を取得
			con = ConnectionManager.getConnection();

			//アカウントテーブルアクセス用のDAOを生成、メソッドの呼出し
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			emp = employeeDAO.login(id);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡して下さい。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡して下さい。");
			}
		}

		return emp;
	}
}
