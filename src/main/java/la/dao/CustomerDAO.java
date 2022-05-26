package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CustomerBean;

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
		String sql = "SELECT cID,cName,cAddress,cTell,cMail,cBday,cJdate,cWdate FROM customer WHERE eMail =?";
		
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
}


//		


	

//		}catch(DAOException e) {
//			e.printStackTrace();
//			request.setAttribute("message", "入力した内容に不備があります");
//			gotoPage(request,response,"/custmer_error.jsp");
//		}
//	}
//}
