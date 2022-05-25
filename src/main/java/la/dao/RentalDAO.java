package la.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.time.Period;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RentalDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:bteam";
	private String user = "postgres";
	private String pass = "himitu";

	public RentalDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました。");
		}
	}

	// 資料テーブルに会員IDがあるか確認
	public boolean Confirmation(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT rental_ID FROM item WHERE document_id= ?";
		boolean Confirmation;

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, dID);
//
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
//結果の取得
				if (rs.next()) {
					Confirmation = false;
				} else {
					Confirmation = true;
				}
				return Confirmation;

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}
	}

	// 5冊以下か DAO
	public void fivebooks(int dID)throws DAOException {
		// SQL文の作成
		String sql = "SELECT rental_id FROM item WHERE document_id =?";
				try{
		// JDBCドライバの登録 
		Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			try(// データベースへの接続
		Connection con = DriverManager.getConnection(url, user, pass); 
					// PreparedStatementオブジェクトの取得
		PreparedStatement st = con.prepareStatement(sql); ){
		//プレースホルダ
		st.setInt(1, dID);
		try(// SQLの実行
		ResultSet rs = st.executeQuery();){
		//結果の取得
		while (rs.next()) {
		
		}
	} catch (SQLException e) {
			e.printStackTrace();
		} 
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
	
	}

		

//	try(// データベースへの接続
//
//	Connection con = DriverManager.getConnection(url, user, pass);
//	// PreparedStatement オブジェクトの取得
//	PreparedStatement st = con.prepareStatement(sql);)
//	{
//		// プレースホルダの設定
//		st.setInt(1, dID);
//		// SQL の実行
//		st.executeUpdate();
//	}catch(
//	SQLException e)
//	{
//		e.printStackTrace();
//		throw new DAOException("レコードの操作に失敗しました。");
//	}
//}
//時間取得
//	public class Main  {
		 
	    public static void main(String[] args) {
	        Calendar today3 = Calendar.getInstance();
	 
	        // SimpleDateFormatクラスを使用して、パターンを設定する
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
	        System.out.println(sdf.format(today3.getTime())); 
	    }
	// 新刊か旧刊
	public void newold(int dID) throws DAOException {
//		LocalDate today = LocalDate.now();
		//Date today2 = new Date(); //Dateクラス　Date型　今日日付
		Calendar today3 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        sdf.format(today3.getTime());
		String sql = "SELECT arrival_date FROM item WHERE document_id=?";
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatement オブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダの設定
			st.setInt(1, dID);
			// SQL の実行
			ResultSet rs = st.executeQuery();
			// 結果の取得
			while (rs.next()) {
				
				Date aDate = rs.getDate("arrival_date");
				
				//①　aDateをカレンダ型にする
				Calendar adate = Calender.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		        System.out.println(sdf.format(adate.getTime())); 
				//②　①を3か月加算
				
				
				//③　②をDate型に戻す
				
				
				//④　今日日付と③を比較
				
				
				
				
				aDate

				
				today2.after(aDate);
//				貸出日ー3カゲツ

//				Date threemonths =aDate.plusMonths(3);
				
//				Period a = Period.between(today, aDate.toLocalDate());
//				Calendar adate =  Calender.getInstance();
//				adate.setTime(date);
//				adate.add(Calender.MONTH, 3);
//			 adate1 = adate.getTime();
//				Date threemonths =adate1
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
					
		}
}
//			ローカルデータでとる
//			データベース入荷日
//			IFで比較


	// 現在日から返却日に更新
	public void newrenDate(int rendate, int dID) throws DAOException {
		String sql = "UPDATE item SET rental_date = current_date,return_date = current_date + ? WHERE document_id = ?";
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatement オブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダの設定
			st.setInt(1, 10, 15);
			st.setInt(2, dID);
			// SQL の実行
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
//旧
//	String sql_3 ="SELECT DATE_ADD(?,INTERVAL 15 DAY)"
//
//	try(// データベースへの接続
//	Connection con = DriverManager.getConnection(url, user, pass);
//	// PreparedStatement オブジェクトの取得
//	PreparedStatement st = con.prepareStatement(sql);)
//	{
//		// プレースホルダの設定
//		st.setString(1, sql);
//		// SQL の実行
//		st.executeUpdate();
//	}catch(
//	SQLException e)
//	{
//		e.printStackTrace();
//		throw new DAOException("レコードの操作に失敗しました。");
//	}
//	}
//			}			
//	}

	// 返却日(入荷日3か月以内か以降か)
	public Date retDate(Date retDate, Date nowDate, Date aDate) throws DAOException {

		String sql = "INSERT INTO history (customer_id,document_id,rental_date,return_date)VALUES(?,?,?,?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatement オブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダの設定
			st.setString(1, cID);
			st.setString(2, dID);
			st.setString(3, rendate);
			st.setString(4, retdate);
			// SQL の実行
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	// 資料テーブル（更新）
	public int apditem(int dID, Date renDate) throws DAOException {
		// Date date = new Date();
		// SQL文の作成
		String sql = "UPDATE Items SET document_id ,rental_date = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 主キーの指定
			st.setInt(1, dID);
			st.setDate(2, renDate);

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	// 履歴テーブル（挿入）
	public int history(int cID, int dID, int renDate) throws DAOException {
		// SQL文の作成
		String sql = "INSERT INTO history(costomer_id,document_id,rental_date)VALUE(?,?,?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 主キーの指定
			st.setInt(1, cID);
			st.setInt(2, dID);
			st.setInt(3, renDate);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	// 履歴テーブル（更新）
	public int history(int retDate) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE history SET return_date = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 主キーの指定
			st.setInt(1, retDate);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
}