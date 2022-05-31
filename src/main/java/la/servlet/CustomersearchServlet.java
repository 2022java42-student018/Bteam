package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CustomerBean;
import la.bean.historyBean;
import la.bean.lend_docBean;
import la.dao.CustomersearchDAO;
import la.dao.DAOException;

@WebServlet("/CustomersearchServlet")

public class CustomersearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			CustomersearchDAO dao = new CustomersearchDAO();
			HttpSession session = request.getSession();

			if (action.equals("eMailSearch")) {
				String eMail = request.getParameter("email");

				CustomerBean bean = dao.emailSearch(eMail);
				session.setAttribute("cID", bean.getcID());
				session.setAttribute("customer", bean);
				gotoPage(request, response, "/Customerinfo.jsp");

			} else if (action.equals("rental")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				List<lend_docBean> list = dao.rend_doc(cID);
				request.setAttribute("document", list);
				gotoPage(request, response, "rendocument.jsp");

			} else if (action.equals("history")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				List<historyBean> list = dao.history_doc(cID);
				request.setAttribute("document", list);
				gotoPage(request, response, "history_doc.jsp");

			} else if (action.equals("backinfo")) {
				int cID = (int)session.getAttribute("cID");
				CustomerBean bean = dao.cIDSearch(cID);
				request.setAttribute("customer", bean);
				gotoPage(request, response, "/Customerinfo.jsp");

			} else if (action.equals("gotoTOP")) {
				session.setAttribute("cID", null);
				gotoPage(request, response, "/TOP.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーです");
			gotoPage(request, response, "/errorTOP.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
