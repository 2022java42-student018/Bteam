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
	public boolean renIDCheck(int dID) throws DAOException {
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
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
	
	public boolean resIDCheck(int dID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT resCID FROM item WHERE dID= ?";

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
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
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
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
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
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
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
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}

	public Date getretlineDay(int dID) throws DAOException {
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
				
				Date retlineDate = new Date();
				retlineDate = retlineDay.getTime();
				return retlineDate;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}

	}
	
	public void rental(int cID,int dID) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE item SET renCID=?, renDate=?, retDate=? WHERE dID =?";
		
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		
		Date getretlineDate = getretlineDay(dID);
		timeInMilliSeconds = getretlineDate.getTime();
		java.sql.Date getretlineDay = new java.sql.Date(timeInMilliSeconds);
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			st.setDate(2, today);
			st.setDate(3, getretlineDay);
			st.setInt(4, dID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
	
	public void rentalhistory(int cID,int dID) throws DAOException {
		// SQL文の作成
		String sql = "INSERT INTO history VALUES CID=?, dID=? ,renDate=?";
		
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);
			st.setInt(2, dID);
			st.setDate(3, today);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
	
	public boolean retIDCheck(int dID) throws DAOException {
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
				boolean Check = true;
				if (rs.next()) {
					Check = false;
				}
				return Check;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
	
	public void ret(int dID) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE item SET renCID=null, renDate=null, retDate=null WHERE dID =?";
		
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		
		Date getretlineDate = getretlineDay(dID);
		timeInMilliSeconds = getretlineDate.getTime();
		java.sql.Date getretlineDay = new java.sql.Date(timeInMilliSeconds);
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, dID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
	
	public void rethistory(int dID) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE item SET retDate=? WHERE dID =?";
		
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setDate(1, today);
			st.setInt(2, dID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを"+"/r"+ "正しく入力してください");
		}
	}
}
