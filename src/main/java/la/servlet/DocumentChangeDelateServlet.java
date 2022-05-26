package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.ChangeDelateDAO;
import la.dao.DAOException;

@WebServlet("/ChangeDelateServlet")
public class DocumentChangeDelateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			ChangeDelateDAO dao = new ChangeDelateDAO();

			if (action.equals("delate")) {
				int dID = Integer.parseInt(request.getParameter("key"));
                int list=dao.PreDelate(dID);
                
				if (list == 0) {
					gotoPage(request, response, "/documentError.jsp");
				} else {
					int list1 = dao.Delate(dID);
					request.setAttribute("items", list1);
					gotoPage(request, response, "/.jsp");
				}
			} else if (action.equals("preDelate")) {
				int dID = Integer.parseInt(request.getParameter("key"));

				if (dID == 0) {
					gotoPage(request, response, "/documentError.jsp");
				} else {
					gotoPage(request, response, "");
				}
			} else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/documentError.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります3");
			gotoPage(request, response, "/documentError.jsp");
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
