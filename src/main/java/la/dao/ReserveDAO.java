
package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import la.bean.ReserveBean;

public class ReserveDAO {

	String url = "jdbc:postgresql:bteam";
	String user = "student";
	String pass = "himitu";

	public ReserveDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	public boolean reservestart(int dID) throws DAOException {

		// SQL文の作成
		String sql = "SELECT resCID FROM item WHERE dID= ? ";
		boolean Confirmation;

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, dID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					Confirmation = false;
				} else {
					Confirmation = true;
				}
				return Confirmation;

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDが間違っています。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDが間違っています。");
		}
	}

	public String getcName(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT cName FROM customer WHERE cID =?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダ
			st.setInt(1, cID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				String cName = null;
				if (rs.next()) {
					cName = rs.getString("cName");
				}
				return cName;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDまたは資料IDを" + "/r" + "正しく入力してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを" + "/r" + "正しく入力してください");
		}
	}
	
	public int Document_serch1(int resCID,int dID)throws DAOException {
		String sql = "UPDATE Item SET resCID= ? WHERE dID=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
		st.setInt(1,resCID);
		st.setInt(2,dID);
		
		int rows = st.executeUpdate();
		return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDが間違っています。");
		}
	}

	public ReserveBean Document_serch(int dID) throws DAOException {
		String sql = "SELECT * FROM Item WHERE dID = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, dID);

			try (ResultSet rs = st.executeQuery();) {
				ReserveBean bean =null;
				while (rs.next()) {
					String dName = rs.getString("dName");
					int cCode = rs.getInt("cCode");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					Date pDate = rs.getDate("pDate");
					 bean = new ReserveBean(dID, dName, cCode, aName, pName, pDate);
				}
				return bean;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDが間違っています。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDが間違っています。");
		}
	}
}
