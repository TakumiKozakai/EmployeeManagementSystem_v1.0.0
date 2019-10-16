package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.EmployeeBean;

public class EmployeeDAO {
	/** DB接続 */
	private Connection con;

	/**
	 * コンストラクター
	 * @param con
	 */
	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	/**
	 * ログイン
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public EmployeeBean login(String id) throws SQLException {
		ResultSet res = null;
		PreparedStatement stmt = null;
		EmployeeBean emp = null;
		String sql = "SELECT * FROM T_EMPLOYEE WHERE ID=?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			res = stmt.executeQuery();

			if (res.next()) {
				emp = new EmployeeBean();
				emp.setId(res.getString(1));
				emp.setName(res.getString(2));
				emp.setSection(res.getString(3));
				emp.setPhone(res.getString(4));
				emp.setPassword(res.getString(5));
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return emp;

	}

	/**
	 * 全件検索
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<EmployeeBean> getAllEmployee() throws SQLException {

		ResultSet res = null;
		PreparedStatement stmt = null;
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		EmployeeBean emp = null;
		String sql = "SELECT * FROM T_EMPLOYEE";

		try {
			stmt = con.prepareStatement(sql);
			res = stmt.executeQuery();

			while (res.next()) {
				emp = new EmployeeBean();
				emp.setId(res.getString(1));
				emp.setName(res.getString(2));
				emp.setSection(res.getString(3));
				emp.setPhone(res.getString(4));
				list.add(emp);

			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}

	/**
	 * レコードの挿入
	 * @param emp
	 * @throws SQLException
	 */
	public void insertEmployee(EmployeeBean emp) throws SQLException {

		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_EMPLOYEE VALUES(?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getSection());
			stmt.setString(4, emp.getPhone());
			stmt.setString(5, emp.getPassword());
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * レコードの削除
	 * @param id
	 * @throws SQLException
	 */
	public void deleteEmployee(String id) throws SQLException {

		PreparedStatement stmt = null;
		String sql = "DELETE FROM T_EMPLOYEE WHERE ID=?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * レコードの更新
	 * @param emp
	 * @throws SQLException
	 */
	public void updateEmployee(EmployeeBean emp) throws SQLException {

		PreparedStatement stmt = null;
		String sql = "UPDATE T_EMPLOYEE SET NAME=?, SECTION=?, PHONE=?, PASSEORD=? WHERE ID=?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getSection());
			stmt.setString(3, emp.getPhone());
			stmt.setString(4, emp.getPassword());
			stmt.setString(5, emp.getId());
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

}
