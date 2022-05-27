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

import la.bean.ReserveBean;
import la.dao.DAOException;
import la.dao.ReserveDAO;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String action = request.getParameter("action");
			ReserveDAO dao = new ReserveDAO();
			HttpSession session = request.getSession(false);
			if (session == null) {
				request.getAttribute("message");
				gotoPage(request, response, "/ReserveCheck.jsp");
				return;
			}

			if (action.equals("Confirmation")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				List<ReserveBean> list = dao.name_serch(cID);
				request.setAttribute("r", list);
				

				session.getAttribute("ManagementdID");
				List<ReserveBean> list2 = dao.Document_serch("ManagementdID");
				request.setAttribute("a", list2);

				RequestDispatcher rd = request.getRequestDispatcher("/ReserveCheck.jsp");
				rd.forward(request, response);

			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "既に予約されています");
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