package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DAOException;
import la.dao.RentalDAO;

@WebServlet("/RentalServlet")
public class RentalServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			//パラメータの解析
			String action = request.getParameter("action");
			//モデルのDAOを生成
			RentalDAO dao = new RentalDAO();
			//貸出
			if(action.equals("ren")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				int dID = Integer.parseInt(request.getParameter("dID"));
				
				if(dao.IDCheck(dID)) {
					request.setAttribute("message", "すでに資料が貸出または予約されています");
					gotoPage(request,response,"/errorRental.jsp");
				}else if(dao.fivebooks(cID)) {
					request.setAttribute("message", "既に5冊の資料を貸出しています\r\n"+ "先に返却してください");
					gotoPage(request,response,"/errorRental.jsp");
				}else if(dao.overrent(cID)) {
					request.setAttribute("message", "資料の返却期限が過ぎています\r\n"+ "資料返却を行ってください");
					gotoPage(request,response,"/errorRental.jsp");
				}else {
					request.setAttribute("dName",dao.getdName(dID));
					gotoPage(request,response,"/RentalConfirmation.jsp");
				}
			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request,response,"/errorRental.jsp");
		}
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request,response);
	}
}
