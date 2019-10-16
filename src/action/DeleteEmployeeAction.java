package action;

import javax.servlet.http.HttpServletRequest;

import exception.SalesBusinessException;
import exception.SalesSystemException;
import logic.DeleteEmployeeLogic;

public class DeleteEmployeeAction {

	public String execute(HttpServletRequest req) {
		String page = "/deleteEmployee.jsp";
		//クライアントの入力値を取得
		String id = req.getParameter("ID");

		try {
			//従業員削除用の業務Logicを生成、メソッドの呼出し
			DeleteEmployeeLogic logic = new DeleteEmployeeLogic();
			logic.deleteEmployee(id);

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
