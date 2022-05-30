package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import la.dao.CustomerDAO;
import la.dao.DAOException;

@WebServlet("/CustomersearchServlet")

public class CustomersearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			CustomerDAO dao = new CustomerDAO();

			HttpSession session = request.getSession();

			if (action.equals("eMailSearch")) {
				String eMail = request.getParameter("email");
				session.setAttribute("email", eMail);
				
				if (eMail == "") {
					request.setAttribute("message", "Emailが未入力です");
					gotoPage(request, response, "/customerError.jsp");
				}
				
				List<CustomerBean> list = dao.Emailcheck(eMail);
				request.setAttribute("customer", list);
				// System.out.println(list);

				if (list.size() == 0) {
					request.setAttribute("message", "Emailが間違っています");
					gotoPage(request, response, "/customerError.jsp");
				} else {
					gotoPage(request, response, "/showcustomer.jsp");// showcustomerﾍ
				}

			} else if (action.equals("rend_doc")) {
				ArrayList<String> inemail = (ArrayList<String>)session.getAttribute("customer",cID);
				
				//request.getAttribute("customer");
				session.setAttribute ("document",inmail);
//				String cID = ${inemai.cID};
//				String eMail1 = (String) session.getAttribute("email");
//				
//				
//				List<lend_docBean> list= dao.rend_doc(eMail1);
//				request.setAttribute("document" list);
				
				//int cID = Integer.parseInt(request.getParameter("cID"));
				//List<lend_docBean> list = dao.rend_doc(cID);

				//request.setAttribute("document", list);

				System.out.println(session.getAttribute("email"));
				gotoPage(request, response, "/lend_doc.jsp");// lend_doc.jspﾍ

			}

			else if (action.equals("history_doc")) {

				int cID = Integer.parseInt(request.getParameter("cID"));

				List<historyBean> list = dao.history_doc(cID);

				request.setAttribute("history", list);
				gotoPage(request, response, "/history_doc.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります");
			gotoPage(request, response, "/customerError.jsp");
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
