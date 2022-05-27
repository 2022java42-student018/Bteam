package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
	public boolean IDCheck(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT renCID FROM item WHERE dID= ?";
		boolean Check = false;

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, dID);
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					Check = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
			return Check;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}
	}

	// 5冊以下か DAO
	public boolean fivebooks(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT renCID FROM item WHERE renCID =?";
		boolean Check = true;
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				rs.last();
				int renDocument = rs.getRow();
				
				if(renDocument >= 5) {
					Check = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}
	return Check;
	}
	
	public boolean overrent(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT retDate FROM item WHERE renCID =?";
		boolean Check = true;
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				rs.last();
				Date retDate = rs.getDate("retDate");
				Calendar retCalendar =  Calendar.getInstance();
				Calendar today =  Calendar.getInstance();
				
				retCalendar.setTime(retDate);
				
				int year = retCalendar.get(Calendar.YEAR);
				int month = retCalendar.get(Calendar.MONTH);
				int date = retCalendar.get(Calendar.DATE);
				
				retCalendar.set(year,month,date,0,0,0);
				
				Check = retCalendar.after(today);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}
	return Check;
	}
	
	public String getcName(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT cName FROM customer WHERE cID =?";
		String cName = null;
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				cName = rs.getString(cName);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return cName;
	}
	
	public String getdName(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT dName FROM item WHERE dID =?";
		String dName = null;
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, dID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				dName = rs.getString(dName);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return dName;
	}
}