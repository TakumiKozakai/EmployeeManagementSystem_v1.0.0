package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.AddEmployeeAction;
import action.DeleteEmployeeAction;
import action.LoginAction;
import action.SearchAllEmployeeAction;
import action.UpdateEmployeeAction;
import entity.EmployeeBean;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = null;
		EmployeeBean emp = null;
		String page = null;

		session = req.getSession();
		emp = new EmployeeBean();

		//画面のボタンIDを取得
		req.setCharacterEncoding("UTF-8");
		String buttonID = req.getParameter("BUTTON_ID");

		/* 各ボタンの処理を振り分ける */
		switch (buttonID) {
		/*メニュー画面への遷移パターン①
		 * ログイン画面の送信ボタンが押された場合
		 */
		case "UC000_01":
			LoginAction login = new LoginAction();
			emp = login.execute(req);

			//検索結果がない場合、エラーを発生させる
			if (emp != null) {
				//検索結果をセッションスコープに設定する
				session.setAttribute("emp", emp);
				//検索結果を戻り値に設定する
				page = "./Menu.html";
			} else {
				req.setAttribute("message", "IDかパスワードが間違っています。");
				page = "./login.jsp";
			}
			break;

		/*メニュー画面への遷移パターン②
		 * メニューに戻るボタンが押された場合
		 */
		case "UC000_02":
			page = "./Menu.html";
			break;

		//        /*①従業員検索画面への遷移
		//         * メニュー画面の従業員検索ボタンが押された場合
		//         * 従業員検索結果画面の前画面に戻るボタンが押された場合
		//         */
		//        case "UC002_01":
		//            page = "./searchEmployeeView.jsp";
		//            break;
		//        /* 従業員検索画面の検索ボタンが押された場合 */
		//        case "UC002_01_01":
		//            SearchEmployeeAction search = new SearchEmployeeAction();
		//            page = search.execute(req);
		//            break;

		/*②従業員全検索画面への遷移
		 * メニュー画面の従業員全検索ボタンが押された場合
		 */
		case "UC002_02":
			SearchAllEmployeeAction searchAll = new SearchAllEmployeeAction();
			page = searchAll.execute(req);
			break;

		/*③従業員追加画面への遷移
		 * メニュー画面の従業員追加ボタンが押された場合
		 */
		case "UC002_03":
			emp = (EmployeeBean) session.getAttribute("emp");
			String id = emp.getId();

			if (!id.equals("Master")) {
				req.setAttribute("error", "管理者権限でログインして下さい。");
				page = "./systemErrorView.jsp";
				break;
			}
			page = "./addEmployeeView.jsp";
			break;

		/* 従業員追加画面の追加ボタンが押された場合 */
		case "UC002_03_01":
			AddEmployeeAction add = new AddEmployeeAction();
			page = add.execute(req);
			break;

		/*④従業員削除画面への遷移
		 * メニュー画面の従業員削除ボタンが押された場合
		 */
		case "UC002_04":
			page = "./deleteEmployeeView.jsp";
			break;
		/* 従業員削除画面の削除ボタンが押された場合 */
		case "UC002_04_01":
			DeleteEmployeeAction delete = new DeleteEmployeeAction();
			page = delete.execute(req);
			break;

		/*⑤従業員更新画面への遷移
		 * メニュー画面の従業員更新ボタンが押された場合
		 * 従業員更新結果画面の前画面に戻るボタンが押された場合
		 */
		case "UC002_05":
			page = "./updateEmployeeView.jsp";
			break;
		/* 従業員更新画面の更新ボタンが押された場合 */
		case "UC002_05_01":
			UpdateEmployeeAction update = new UpdateEmployeeAction();
			page = update.execute(req);
			break;

		/*⑥ログアウト画面への遷移
		 * メニュー画面のログアウトが選択された場合
		 */
		case "UC999_01":
			page = "./logout.jsp";
			break;
		}

		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}

}
