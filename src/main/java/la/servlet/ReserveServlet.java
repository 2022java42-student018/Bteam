package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			if (action.equals("Confirmation")) {
				int userID = Integer.parseInt(request.getParameter("ID"));
				List<ReserveBean> list = dao.name_serch(userID);
				request.setAttribute("r_data", list);
				gotoPage(request, response, "/ReserveCheck.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "既に予約されています");
			gotoPage(request, response, "/errorTOP.jsp");
		}
	}
	
	

	/*
	 * int dID = (Integer) session.getAttribute("ManagementdID"); if
	 * (dao.Confirmation(dID)) { gotoPage(request, response, "/resevehtml"); } else
	 * { request.setAttribute("message", "既に予約されています"); gotoPage(request, response,
	 * "/errorTOP.jsp"); } } else if (action.equals("ManagementdID")) {
	 * 
	 * } }catch(
	 * 
	 * DAOException e) { e.printStackTrace(); request.setAttribute("message",
	 * "既に予約されています"); gotoPage(request, response, "/errorTOP.jsp"); } }
	 */
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