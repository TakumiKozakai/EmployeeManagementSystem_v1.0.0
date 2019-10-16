package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionManager;
import dao.EmployeeDAO;
import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;

public class SearchAllEmployeeLogic {

	public ArrayList<EmployeeBean> getAllEmployee() throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		ArrayList<EmployeeBean> empList = null;
		try {
			//DB接続
			con = ConnectionManager.getConnection();

			//従業員テーブルアクセス用のDAOを生成、メソッドの呼出し
			EmployeeDAO searchAllDAO = new EmployeeDAO(con);
			empList = searchAllDAO.getAllEmployee();

			//検索結果が無い場合、エラーを発生させる
			if (empList == null) {
				throw new SalesBusinessException("①システムエラー発生。システム管理者に連絡して下さい。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesSystemException("②システムエラー発生。システム管理者に連絡して下さい。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("③システムエラー発生。システム管理者に連絡して下さい。");
			}
		}

		return empList;
	}

}
