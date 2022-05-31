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
				
				if(dao.renIDCheck(dID) != 0 ) {
					request.setAttribute("message", "すでに資料が貸出または予約されています");
					gotoPage(request,response,"/errorRental.jsp");
				}else if(dao.resIDCheck(dID) !=0) {
					request.setAttribute("message", "すでに資料が貸出または予約されています");
					gotoPage(request,response,"/errorRental.jsp");
				}else if(dao.fivebooks(cID)) {
					request.setAttribute("message", "既に5冊の資料を貸出しています\r\n"+ "先に返却してください");
					gotoPage(request,response,"/errorRental.jsp");
				}else if(dao.overrent(cID)) {
					request.setAttribute("message", "資料の返却期限が過ぎています\r\n"+ "資料返却を行ってください");
					gotoPage(request,response,"/errorRental.jsp");
				}else {
					String dName = dao.getdName(dID);
					dao.rental(cID,dID);
					dao.rentalhistory(cID, dName);
					request.setAttribute("dName",dao.getdName(dID));
					request.setAttribute("message","以上の資料を貸出しました");
					request.setAttribute("retlineDay", dao.getretlineDay(dID));
					gotoPage(request,response,"/Rental.jsp");
				}
				
				
			}else if(action.equals("ret")) {
				int dID = Integer.parseInt(request.getParameter("dID"));
				
				if(dao.retIDCheck(dID)) {
					request.setAttribute("message", "この資料は貸出されていません");
					gotoPage(request,response,"/errorRental.jsp");
				}else {
					dao.ret(dID);
					dao.rethistory(dID);
					request.setAttribute("dName",dao.getdName(dID));
					request.setAttribute("message","以上の資料を返却しました");
					
					if(dao.resIDCheck(dID) !=0) {
						request.setAttribute("resmessage","予約有り");
					}
					gotoPage(request,response,"/Return.jsp");
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
