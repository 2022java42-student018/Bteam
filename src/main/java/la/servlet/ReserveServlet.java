package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DaoReserve;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータ
		String action = request.getParameter("action");
		String dID;
		
		//モデルのDAOの解決
		DaoReserve dao = new DaoReserve();
		
		// 予約可能
		if (action.equals("reserve")) {
			dID = request.getParameter("dID");
		if(dao)
		gotoPage(request, response, "reserve.html");}
		}
	

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}