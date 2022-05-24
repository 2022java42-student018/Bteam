package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RentalDAO {
    // URL、ユーザ名、パスワードの準備
    private String url = "jdbc:postgresql:bteam";
    private String user = "postgres";
    private String pass = "himitu";

public RentalDAO() throws DAOException { 
    try{
        // JDBCドライバの登録 
        Class.forName("org.postgresql.Driver");
        
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new DAOException("ドライバの登録に失敗しました。");
    } 
}


//現在時刻日付
public Date nowDate( Date nowDate) throws DAOException {


}
//入荷日(3か月以内か以降か）
//public Date aDate()throws DAOException{
//	if(aDate.compareTO(nowDate)< 90);
//	//旧
//	
//	}else if {
//		//新刊の場合
//	String sql="UPDATE items SET neworold"
//		
//}


	//貸出日
public void  renDate(int customer_id) throws DAOException {
		String sql ="SELECT rental_date FROM item WHERE document_id=?";//（貸出日）
	 try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatement オブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
		//プレースホルダの設定
		st.setInt(1,customer_id);
		// SQL の実行
		st.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 throw new DAOException("レコードの操作に失敗しました。");
		}
}

//	}else {
		//旧
	String sql_3 ="SELECT DATE_ADD(?,INTERVAL 15 DAY)";
	try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatement オブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
		//プレースホルダの設定
		st.setString(1,sql);
		// SQL の実行
		st.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 throw new DAOException("レコードの操作に失敗しました。");
		}
	
	}
}

//返却日(入荷日3か月以内か以降か)
public Date retDate(Date retDate,Date nowDate,Date aDate) throws DAOException {
	
	String sql ="INSERT INTO history (customer_id,document_id,rental_date,return_date)VALUES(?,?,?,?)";
	
	try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatement オブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
		//プレースホルダの設定
		st.setString(1,cID);
		st.setString(2,dID);
		st.setString(3,rendate);
		st.setString(4,retdate);
		// SQL の実行
		st.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 throw new DAOException("レコードの操作に失敗しました。");
		}
}


    // 資料テーブル（更新）
public  int apditem(int dID, Date renDate) throws DAOException {
//    Date date = new Date();
    //SQL文の作成
    String sql = "UPDATE Items SET document_id ,rental_date = ?";

    try (// データベースへの接続
Connection con = DriverManager.getConnection(url, user, pass);
// PreparedStatementオブジェクトの取得 
PreparedStatement st = con.prepareStatement(sql);){
//主キーの指定
st.setInt(1,dID);
st.setDate(2,renDate);

// SQLの実行
int rows = st.executeUpdate();
return rows;
} catch (SQLException e) {
    e.printStackTrace();
throw new DAOException("レコードの操作に失敗しました。"); 
}
}


    // 履歴テーブル（挿入）
public int history(int cID,int dID, int renDate) throws DAOException {
    //SQL文の作成
    String sql = "INSERT INTO history(costomer_id,document_id,rental_date)VALUE(?,?,?)";

    try (// データベースへの接続
Connection con = DriverManager.getConnection(url, user, pass);
// PreparedStatementオブジェクトの取得 
PreparedStatement st = con.prepareStatement(sql);){
//主キーの指定
st.setInt(1,cID);
st.setInt(2,dID);
st.setInt(3,renDate);
// SQLの実行
int rows = st.executeUpdate();
return rows;
} catch (SQLException e) {
    e.printStackTrace();
throw new DAOException("レコードの操作に失敗しました。"); }
}

    // 履歴テーブル（更新）
public int history(int retDate) throws DAOException {
    //SQL文の作成
    String sql = "UPDATE history SET return_date = ?";

    try (// データベースへの接続
Connection con = DriverManager.getConnection(url, user, pass);
// PreparedStatementオブジェクトの取得 
PreparedStatement st = con.prepareStatement(sql);){
//主キーの指定
st.setInt(1,retDate);
// SQLの実行
int rows = st.executeUpdate();
return rows;
} catch (SQLException e) {
    e.printStackTrace();
throw new DAOException("レコードの操作に失敗しました。"); 
}
}
}