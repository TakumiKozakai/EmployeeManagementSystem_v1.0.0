package logic;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionManager;
import dao.EmployeeDAO;
import exception.SalesBusinessException;
import exception.SalesSystemException;

public class DeleteEmployeeLogic {

	public void deleteEmployee(String id) throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		try {
			//DB接続を取得
			con = ConnectionManager.getConnection();

			//従業員テーブルアクセス用のDAOを生成、メソッドの呼出し
			EmployeeDAO deleteDAO = new EmployeeDAO(con);
			deleteDAO.deleteEmployee(id);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesSystemException("システムエラー発生。システム管理者に連絡して下さい。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("システムエラー発生。システム管理者に連絡して下さい。");
			}
		}
	}

}
