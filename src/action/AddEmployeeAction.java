package action;

import javax.servlet.http.HttpServletRequest;

import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;
import logic.AddEmployeeLogic;

public class AddEmployeeAction {

	/**
	 * @param req
	 * @return
	 */
	public String execute(HttpServletRequest req) {
		String page = "/addEmployee.jsp";
		EmployeeBean emp = null;

		//クライアントの入力値を取得
		String id = req.getParameter("ID");
		String name = req.getParameter("NAME");
		String section = req.getParameter("SECTION");
		String phone = req.getParameter("PHONE");
		String password = req.getParameter("PASSWORD");

		try {
			//追加する従業員情報を生成
			emp = new EmployeeBean(id, name, section, phone, password);
			//従業員追加用の業務Logicを生成、メソッドの呼出し
			AddEmployeeLogic logic = new AddEmployeeLogic();
			logic.addEmployee(emp);

			//従業員情報追加後に従業員情報前検索機能を実行
			SearchAllEmployeeAction searchAll = new SearchAllEmployeeAction();
			//追加結果画面を戻り値に設定する
			page = searchAll.execute(req);

		} catch (SalesBusinessException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		} catch (SalesSystemException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			//システムエラー画面を戻り値に設定する
			page = "/systemError.jsp";
		}

		return page;
	}

}
