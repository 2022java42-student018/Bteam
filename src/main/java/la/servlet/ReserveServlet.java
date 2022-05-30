package la.servlet;

import java.io.IOException;

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
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			ReserveDAO dao = new ReserveDAO();
			HttpSession session = request.getSession(false);
			if (action.equals("reserve")) {
				int dID = (int) session.getAttribute("ManagementdID");
				if (dao.reservestart(dID)) {
					request.setAttribute("message", "すでに予約されている資料です");
					gotoPage(request, response, "/errorTOP.jsp");
				} else {
					gotoPage(request, response, "/reserve.html");
				}
			} else if (action.equals("Confirmation")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				int dID = (int) session.getAttribute("ManagementdID");
				request.setAttribute("cName", dao.getcName(cID));
				request.setAttribute("cID", cID);
				ReserveBean document = dao.Document_serch(dID);
				if (document.getRescID() > 0) {
					request.setAttribute("message", "すでに予約されている資料です");
					gotoPage(request, response, "/errorTOP.jsp");
					return;
				}
				session.setAttribute("document", document);
				gotoPage(request, response, "/ReserveCheck.jsp");
				
			} else if (action.equals("decision")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				ReserveBean reserveBean = (ReserveBean) session.getAttribute("document");
				int dID =reserveBean.getdID();
				dao.Document_serch1(cID, dID);
			    request.setAttribute("message","予約が完了しました。");
				gotoPage(request, response, "/errorTOP.jsp");

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