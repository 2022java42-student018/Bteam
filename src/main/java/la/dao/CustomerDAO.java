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

public class CustomerDAO {
	String url = "jdbc:postgresql:sample";
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
		String sql = "SELECT cID,cName,cAddress,cTell,cMail,cBday,cJdate,cWdate FROM customer WHERE cMail =?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1, eMail);
			
			try(
				ResultSet rs = st.executeQuery();){
				List<CustomerBean> list = new ArrayList<CustomerBean>();
				while (rs.next()) {
					int cID =rs.getInt("cID");
					String cName =rs.getString("cName");
					int cAddress =rs.getInt("cAddress");
					int cTell =rs.getInt("cTell");
					String cMail =rs.getString("cMail");
					int cBday =rs.getInt("cBday");
					int cJdate =rs.getInt("cJdate");
					int cWdate =rs.getInt("cWdate");
					CustomerBean bean = new CustomerBean(cID, cName, cAddress, cJdate, cMail, cBday, cJdate, cWdate);
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
	public List<DocumentInfoBean> history() throws DAOException {
		String sql = "SELECT dID,renDate,retDate,FROM history INNER JOIN item カラム名 = テーブル1.カラム名WHERE renCID =?";
		
		String sql = "SELECT dID,dName,pName,aName,renCID,resCID FROM item INNER JOIN history ON history."
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
	
			st.setInt(1, cID);
	
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
