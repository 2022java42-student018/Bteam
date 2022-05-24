package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import la.dao.RentalDAO;

@WebServlet("/RentalServlet")
public class RentalServlet extends HttpServlet {
	// データベース接続
	private static final String USER = "postgres";
	private static final String PASS = "himitu";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	try {
		request.setCharacterEncoding("UTF-8");
		//パラメータの解析
		String action = request.getParameter("action");
		//モデルのDAOを生成
		RentalDAO dao = new RentalDAO();
	//現在時刻取得
		//dateクラス取得
		Date date =  new Date();
		long data1 = date.getTime();
		java.sql.Date nowDate = new java.sql.Date(data1);
		dao.nowDate(nowDate);
	
		//貸出
		if(action.equals("ren")) {
			int cID= Integer.parseInt(request.getParameter("cID"));//会員ID
			int dID= Integer.parseInt(request.getParameter("dID"));//資料ID
			
			
			dao.apditem(dID);
			dao.rendate(rendate);
			gotoPage(request,response,"/showrental/jsp");
		}
		//返却
		else if(action.equals("ret")) {
			String dID= request.getParameter("dID");
			dao.appItem(renCID);
			gotoPage(request,response,"/");
		}
	}	
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//リクエストパラメータ読み込み
		request.setCharacterEncoding("UTF-8");
		String cID = request.getParameter("cID");
		String dID = request.getParameter("dID");
		
		//パラメータチェック
		if( cID == null|| cID.length() == 0||dID == null|| dID.length() == 0) {
			request.setAttribute("message","各IDを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forword(request, response);
			return;
		}
		int cID, dID;
		try {//文字ならエラー
			cID =Integer.parseInt(num1);
			dID =Integer.parseInt(num2);
		}catch (NumberFormatException e) {
			request.setAttribute("message","数字を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forword(request, response);+
			return;
		}
		
		
		
		
		
		
		
		
		
		

		
		
		
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
