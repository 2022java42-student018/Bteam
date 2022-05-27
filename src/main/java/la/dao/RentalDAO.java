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

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, dID);
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
				boolean Check = false;
				if (rs.next()) {
					Check = true;
				}
				return Check;
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
	public boolean fivebooks(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT renCID FROM item WHERE renCID =?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				boolean Check = true;
				rs.last();
				int renDocument = rs.getRow();

				if (renDocument >= 5) {
					Check = false;
				}
				return Check;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}

	}

	public boolean overrent(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT retDate FROM item WHERE renCID =?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				boolean Check = true;
				Date retDate = rs.getDate("retDate");
				Calendar retCalendar = Calendar.getInstance();
				Calendar today = Calendar.getInstance();

				retCalendar.setTime(retDate);

				int year = retCalendar.get(Calendar.YEAR);
				int month = retCalendar.get(Calendar.MONTH);
				int date = retCalendar.get(Calendar.DATE);

				retCalendar.set(year, month, date, 0, 0, 0);

				Check = retCalendar.before(today);
				return Check;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDエラー");
		}
	}

	public String getdName(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT dName FROM item WHERE dID =?";
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, dID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				String dName = null;
				if (rs.next()) {
					dName = rs.getString("dName");
				}
				return dName;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("資料IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("資料IDエラー");
		}
	}

	public Calendar getretlineDay(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT aDate FROM item WHERE dID =?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, dID);
			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				
				Calendar today = Calendar.getInstance();
				Calendar retlineDay = Calendar.getInstance();
				Calendar aCalendar = Calendar.getInstance();

				Date aDate = rs.getDate("aDate");
				aCalendar.setTime(aDate);
				aCalendar.add(aCalendar.MONTH, 3);

				int year = today.YEAR;
				int month = today.MONTH;
				int date = today.DATE;

				int a_year = aCalendar.YEAR;
				int a_month = aCalendar.MONTH;
				int a_date = aCalendar.DATE;

				today.set(year, month, date, 0, 0, 0);
				retlineDay.set(year, month, date, 0, 0, 0);
				aCalendar.set(a_year, a_month, a_date, 0, 0, 0);

				if (aCalendar.after(today)) {
					retlineDay.add(retlineDay.DATE, 10);
				} else {
					retlineDay.add(retlineDay.DATE, 15);
				}
				return retlineDay;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("資料IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("資料IDエラー");
		}

	}
	
	public String rental(int cID,int dID) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE item SET renCID=? item WHERE dID =?";
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			st.setInt(2, dID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("資料IDエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("資料IDエラー");
		}
	}
}
