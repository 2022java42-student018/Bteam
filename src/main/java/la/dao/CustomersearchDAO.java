package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CustomerBean;
import la.bean.historyBean;
import la.bean.lend_docBean;

public class CustomersearchDAO {
	String url = "jdbc:postgresql:Bteam";
	String user = "student";
	String pass = "himitu";

	public CustomersearchDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	public CustomerBean emailSearch(String eMail) throws DAOException {
		String sql = "SELECT cID,cname,caddress,cTell,cmail,cbday,cJdate FROM customer WHERE cmail =?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, eMail);

			try (ResultSet rs = st.executeQuery();) {
				CustomerBean bean = null;
				while (rs.next()) {
					int cID = rs.getInt("cID");
					String cName = rs.getString("cName");
					String cAddress = rs.getString("cAddress");
					String cTell = rs.getString("cTell");
					String cMail = rs.getString("cMail");
					java.sql.Date cBday = rs.getDate("cBday");
					java.sql.Date cJdate = rs.getDate("cJdate");
					bean = new CustomerBean(cID, cName, cAddress, cTell, cMail, cBday,cJdate, null);
				}
				return bean;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("データセットエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	}

	public List<lend_docBean> rend_doc(int cID) throws DAOException {
		String sql = "SELECT dID,dName,pName,aName,renCID,resCID FROM item WHERE renCID =?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, cID);

			try (ResultSet rs = st.executeQuery();) {
				List<lend_docBean> list = new ArrayList<lend_docBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");// タイトル
					String pName = rs.getString("pName");// 出版社
					String aName = rs.getString("aName");// 著者
					java.sql.Date renDate = rs.getDate("renDate ");
					java.sql.Date retDate = rs.getDate("retDate ");
					lend_docBean bean = new lend_docBean(dID,dName,pName,aName,renDate,retDate);
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("リストエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースエラー");
		}

	}

	public List<historyBean> history_doc(int cID) throws DAOException {
		String sql = "SELECT * FROM history WHERE cID =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, cID);

			try (ResultSet rs = st.executeQuery();) {
				List<historyBean> list = new ArrayList<historyBean>();
				while (rs.next()) {
					String dName = rs.getString("dName");// タイトル
					java.sql.Date renDate = rs.getDate("renDate ");
					java.sql.Date retDate = rs.getDate("retDate ");
					historyBean bean = new historyBean(cID, dName, renDate, retDate);
					list.add(bean);
				}
				return list;
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("データセットエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースエラー");
		}
	}
	
	public CustomerBean cIDSearch(int cID) throws DAOException {
		String sql = "SELECT cID,cname,caddress,cTell,cmail,cbday,cJdate FROM customer WHERE cmail =?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, cID);

			try (ResultSet rs = st.executeQuery();) {
				CustomerBean bean = null;
				while (rs.next()) {
					String cName = rs.getString("cName");
					String cAddress = rs.getString("cAddress");
					String cTell = rs.getString("cTell");
					String cMail = rs.getString("cMail");
					java.sql.Date cBday = rs.getDate("cBday");
					java.sql.Date cJdate = rs.getDate("cJdate");
					bean = new CustomerBean(cID, cName, cAddress, cTell, cMail, cBday,cJdate, null);
				}
				return bean;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("データセットエラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースエラー");
		}
	}

}