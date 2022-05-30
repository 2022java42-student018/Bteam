package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.CustomerBean;

public class CustomerAddDAO {
	String url = "jdbc:postgresql:bteam";
	String user = "student";
	String pass = "himitu";
	
	public CustomerAddDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public CustomerBean Add(String lecName, String lecAddress,String lecTell, String lecMail, Date lecBday) 
	throws DAOException{
		String sql = "INSERT INTO customer (cName, cAddress, cTell,cMail, cBday)VALUES(?,?,?,?,?)";
		String sql1 = "SELECT cName, cAddress, cTell,cMail, cBday FROM customer WHERE cName = ? AND cTell = ?";
		try(Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setString(1, lecName);
			st.setString(2, lecAddress);
			st.setString(3, lecTell);
			st.setString(4, lecMail);
			st.setDate(5, lecBday);
			int rows = st.executeUpdate();
			
			try(PreparedStatement st1 = con.prepareStatement(sql1);){
				st1.setString(1, lecName);
				st1.setString(2, lecTell);
				
				try(ResultSet rs = st1.executeQuery();){
					
					CustomerBean bean = null;
					while(rs.next()) {
						String cName = rs.getString("cName");
						String cAddress = rs.getString("cAddress");
						String cTell = rs.getString("cTell");
						String cMail = rs.getString("cMail");
						java.sql.Date cBday = rs.getDate("cBday");
						bean = new CustomerBean(cName, cAddress, cTell, cMail, cBday);
						
					}
					return bean;
				}catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("正しく操作してください");
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく操作してください");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
}
