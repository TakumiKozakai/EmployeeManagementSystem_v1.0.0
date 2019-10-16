package logic;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionManager;
import dao.EmployeeDAO;
import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;

public class UpdateEmployeeLogic {

	/**
	 * @param emp
	 * @throws SalesBusinessException
	 * @throws SalesSystemException
	 */
	public void updateEmployee(EmployeeBean emp) throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		try {
			//DB接続を取得
			con = ConnectionManager.getConnection();

			//従業員テーブルアクセス用のDAOを生成、メソッドの呼出し
			EmployeeDAO updateDAO = new EmployeeDAO(con);
			updateDAO.updateEmployee(emp);

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
