package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;
import la.dao.ReserveDAO;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			ReserveDAO dao = new ReserveDAO();
			HttpSession session = request.getSession(false);
			if (session == null) {
				request.getAttribute("message");
				gotoPage(request, response, "/ReserveCheck.jsp");
				return;
			}
			if(action.equals("reserve")) {
				int dID = (int)session.getAttribute("ManagementdID");
				if(dao.reservestart(dID)) {
					request.setAttribute("message", "すでに予約されている資料です");
					gotoPage(request,response,"/errorTOP.jsp");
				}else {
					gotoPage(request,response,"/reserve.html");
				}
			}

			if (action.equals("Confirmation")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				int dID = (int)session.getAttribute("ManagementdID");
				request.setAttribute("cName",cID);
				request.setAttribute("document", dao.Document_serch(dID));
				gotoPage(request,response,"/ReserveCheck.html");
				
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