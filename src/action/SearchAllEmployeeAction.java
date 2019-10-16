package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import entity.EmployeeBean;
import exception.SalesBusinessException;
import exception.SalesSystemException;
import logic.SearchAllEmployeeLogic;

public class SearchAllEmployeeAction {

	/**
	 * @param req
	 * @return
	 */
	public String execute(HttpServletRequest req) {
		String page = null;

		try {
			//従業員検索用の業務Logicを生成、メソッドの呼出し
			SearchAllEmployeeLogic logic = new SearchAllEmployeeLogic();
			ArrayList<EmployeeBean> emp = logic.getAllEmployee();

			//検索結果をリクエストスコープに設定する
			req.setAttribute("emp", emp);

			//検索結果画面を戻り値に設定する
			page = "/searchAllEmployeeResult.jsp";

		} catch (SalesBusinessException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			//システムエラー画面を戻り値に設定する
			page = "/systemErrorView.jsp";
		} catch (SalesSystemException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			//システムエラー画面を戻り値に設定する
			page = "/systemErrorView.jsp";
		}

		return page;
	}

}
