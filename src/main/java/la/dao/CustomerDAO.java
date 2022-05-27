package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CustomerBean;
import la.bean.DocumentInfoBean;
import la.bean.historyBean;

public class CustomerDAO {
	String url = "jdbc:postgresql:bteam2";
	String user = "student";
	String pass = "himitu";

	public CustomerDAO()throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	
	public List <CustomerBean> emailSearch(String eMail )throws DAOException{
		String sql = "SELECT cID,cname,caddress,cTell,cmail,cbday,cJdate FROM customer WHERE cmail =?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1, eMail);
			
			try(
				ResultSet rs = st.executeQuery();){
				List<CustomerBean> list = new ArrayList<CustomerBean>();
				while (rs.next()) {
					int cID =rs.getInt("cID");
					String cName =rs.getString("cName");
					String cAddress =rs.getString("cAddress");
					int cTell =rs.getInt("cTell");
					String cMail = rs.getString("cMail");
					java.sql.Date cBday =rs.getDate("cBday");
					java.sql.Date cJdate =rs.getDate("cJdate");
					CustomerBean bean = new CustomerBean(cID,cName,cAddress,cTell,cMail,cBday,cJdate);
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");
				}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	}

	public List<DocumentInfoBean> renddoc(int cID) throws DAOException {
		String sql = "SELECT dID,dName,pName,aName,renCID,resCID FROM item WHERE renCID =?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setInt(1, cID);

			try (
					ResultSet rs = st.executeQuery();) {
				List<DocumentInfoBean> list = new ArrayList<DocumentInfoBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dname = rs.getString("dName");// タイトル
					String pName = rs.getString("pName");// 出版社
					String aName = rs.getString("aName");// 著者
					int renCID = rs.getInt("renCID ");
					int resCID = rs.getInt("resCID ");
					DocumentInfoBean bean = new DocumentInfoBean();
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	
	}
	public List<historyBean> history(int cID) throws DAOException {
		String sql = "SELECT cID,dName,renDate,retDate,FROM history WHERE cID =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
	
			st.setInt(1, cID);
			
			try (
					ResultSet rs = st.executeQuery();) {
				List<historyBean> list = new ArrayList<historyBean>();
				while (rs.next()) {
					int cID1 = rs.getInt("cID");
					String dName = rs.getString("dName");// タイトル
					int renCID = rs.getInt("renCID ");
					int retCID = rs.getInt("retCID ");
					historyBean bean = new historyBean(cID1,dName ,renCID,retCID);
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	
	
	
	}
	

	
	

}


//		


	

//		}catch(DAOException e) {
//			e.printStackTrace();
//			request.setAttribute("message", "入力した内容に不備があります");
//			gotoPage(request,response,"/custmer_error.jsp");
//		}
//	}
//}
