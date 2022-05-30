package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CustomerBean;
import la.dao.CustomerdeleteDAO;
import la.dao.DAOException;

/**
 * Servlet implementation class CustomerdeleteServlet
 */
@WebServlet("/CustomerdeleteServlet")
public class CustomerdeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルのDAOを生成
			CustomerdeleteDAO dao = new CustomerdeleteDAO();
			// 貸出
			if (action.equals("Confirm")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				if (dao.cWdateCheck(cID)) {
					request.setAttribute("message", "退会済みの会員です");
					gotoPage(request, response, "/errorTOP.jsp");
				} else {
					List<CustomerBean> list = dao.getcustomer(cID);
					request.setAttribute("customer", list);
					gotoPage(request, response, "/CustomerdeleteConfirm.jsp");
				}
			} else if (action.equals("delete")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				dao.Delete(cID);
				request.setAttribute("message", "退会が完了しました");
				gotoPage(request, response, "/errorTOP.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/errorRental.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
