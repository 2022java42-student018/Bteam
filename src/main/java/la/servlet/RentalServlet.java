package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputFilter.Config;

import javax.security.auth.callback.ConfirmationCallback;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
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
		//貸出
		if(action.equals("ren")) {//valueの値
			int cID= Integer.parseInt(request.getParameter("cID"));//会員ID //数値変換
			int dID= Integer.parseInt(request.getParameter("dID"));//資料ID
			
			dao.newrenDate(dID);//DAOへ
			dao.newold(dID);//DAOへ
//			dao.rendate(rendate);//貸出日DAOへ
}
//資料テーブルに会員IDがあるか確認
    resultCID = dao.Confirmation();
if(Confirmation=false){
	gotoPage(request,response,"/errerInput");
}else if(Confirmation=true){

}

//新刊か旧か


	// 5冊以下か DAO
// public fivebooks()throws DAOException {
// // SQL文の作成
// String sql = ;
// 		try{
// // JDBCドライバの登録 
// Class.forName("org.postgresql.Driver");
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
// 	 try(// データベースへの接続
// Connection con = DriverManager.getConnection(url, user, pass); // PreparedStatementオブジェクトの取得
// PreparedStatement st = con.prepareStatement(sql);) {
// // SQLの実行
// ResultSet rs = st.executeQuaey();
// //結果の取得
// while (rs.next()) {

// }
result =dao.fivebooks();
if(result > 5) {
	gotoPage(request,response,"/errerInput");

}else if{// 返却期限
 
//サーブレットへ返す

//確認ページへ遷移
gotoPage(request,response,"/showrental/jsp");
}









		//返却
		if(action.equals("ret")) {
			String dID= request.getParameter("dID");
			dao.appItem(renCID);
			gotoPage(request,response,"/");
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
			rd.forword(request, response);
			return;
		}
		
		
		
		
		
		
		
		
		
		

		
		
		
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
