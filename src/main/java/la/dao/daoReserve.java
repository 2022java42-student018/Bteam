package la.dao;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DaoReserve")
public class DaoReserve extends HttpServlet{

	public boolean Confirmation(int dID) throws DAOException{
			
			//SQL文の作成
			String sql ="SELECT resCID FROM item WHERE dID= ? ";
			
		    try(//データベースへの接続
		       Connection con = DriverManager.getConnection();
			    //PaeparedStatementオブジェクトの所得
		       PreparedStatement st= con.preparedStatemen(sql);){
		    	//カテゴリの設定
		    	st.setInt(dID, dID);
		    	
		    	try(SQLの実行
		    			ResultSet rs = st.execyteQuery();){
		    		//結果の取得および表示
		    		DaoReserve dao = new DaoReserve();
		    		if(rs.next()) {
		    			int dID =rs.getInt("dID");
		    			String resCID = rs.getString("resCID");
		    		}
		    	
		    	}catch (){
		    
		    }
		}
}
