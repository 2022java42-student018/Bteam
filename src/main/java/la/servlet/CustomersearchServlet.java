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

			if (action.equals("eMailSearch")) {
				String eMail = request.getParameter("email");
				
				CustomerBean bean = dao.emailSearch(eMail);
				request.setAttribute("customer", bean);
				// System.out.println(list);
				gotoPage(request,response,"/Customerinfo.jsp");
				
			} else if (action.equals("rental")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				List<CustomerBean> list =dao.
				
			}else if(action.equals("history")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります");
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
