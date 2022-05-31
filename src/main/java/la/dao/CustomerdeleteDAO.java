package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import la.bean.CustomerBean;

public class CustomerdeleteDAO {
	private String url = "jdbc:postgresql:bteam";
	private String user = "student";
	private String pass = "himitu";

	public CustomerdeleteDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました。");
		}
	}

	public Date cWdateCheck(int cID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT cWdate FROM customer WHERE cID= ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, cID);
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
				java.sql.Date num = null;
				if (rs.next()) {
					 num = rs.getDate("cWdate");
					
				}
				return num;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく入力してください");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDまたは資料IDを" + "/r" + "正しく入力してください");
		}
	}

	public CustomerBean getcustomer(int cID) throws DAOException {
		String sql = "SELECT * FROM customer WHERE cID = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, cID);
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
				CustomerBean bean = null;
				while (rs.next()) {
					String cName = rs.getString("cName");
					String cAddress = rs.getString("cAddress");
					String cTell = rs.getString("cTell");
					String cMail = rs.getString("cMail");
					Date cBday = rs.getDate("cBday");
					Date cJdate = rs.getDate("cJdate");
					int cID1 = rs.getInt("cID");
					bean = new CustomerBean(cID1, cName, cAddress, cTell, cMail, cBday, cJdate, null);
					
				}
				return bean;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく操作してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}

	public int Delete(int cID) throws DAOException {
		String sql = "UPDATE customer SET cWdate=? WHERE cID =?";
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		System.out.println(today);
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setDate(1, today);
			st.setInt(2, cID);
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
	
	public int Kakunin(int lecID)throws DAOException{
		String sql = "SELECT * FROM customer WHERE cID = ?";
		try(
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1, lecID);
			try(ResultSet rs = st.executeQuery();){
				int cID =0;
				while(rs.next()) {
					cID = rs.getInt("cID");
				}
				return cID;
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	}
}
