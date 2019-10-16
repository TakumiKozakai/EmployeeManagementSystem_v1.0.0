package action;

import javax.servlet.http.HttpServletRequest;

import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;
import logic.LoginLogic;

public class LoginAction {

	/**
	 * @param req
	 * @return
	 */
	public EmployeeBean execute(HttpServletRequest req) {
		EmployeeBean emp = null;
		//        String page = "/login.jsp";

		//クライアントの入力値を取得
		String id = req.getParameter("ID");
		String password = req.getParameter("PASSWORD");

		try {
			//ログイン用の業務Logicを生成、メソッドの呼出し
			LoginLogic logic = new LoginLogic();
			emp = logic.login(id);
			if (!password.equals(emp.getPassword())) {
				emp = null;
			}

		} catch (SalesBusinessException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		} catch (SalesSystemException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			//            //システムエラー画面を戻り値に設定する
			//            page = "./SystemErrorView.jsp";
		}

		return emp;
	}

}
