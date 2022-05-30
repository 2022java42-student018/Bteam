package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.CustomerBean;

public class CustomerChangeDAO {

	String url = "jdbc:postgresql:bteam";
	String user = "student";
	String pass = "himitu";

	public CustomerChangeDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public int Change(int lecID, String lecName, String lecAddress, String lecTell, String lecMail, Date lecBday)throws DAOException {
		String sql ="UPDATE customer SET cName =?, cAddress =?, cTell =?, cMail =?, cBday =? WHERE cID=?";
		try(Connection con =DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setString(1,lecName);
			st.setString(2, lecAddress);
			st.setString(3, lecTell);
			st.setString(4, lecMail);
			st.setDate(5, lecBday);
			st.setInt(6, lecID);
			
			int rows = st.executeUpdate();
		
			return rows;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
	
	public CustomerBean ShowCustomerInfo(int lecID)throws DAOException{
		String sql = "SELECT cID, cName, cAddress, cTell, cMail, cBday FROM customer WHERE cID = ?";
		try(
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1, lecID);
			try(ResultSet rs = st.executeQuery();){
				CustomerBean bean = null;
				while(rs.next()) {
					int cID = rs.getInt("cID");
					String cName = rs.getString("cName");
					String cAddress = rs.getString("cAddress");
					String cTell =rs.getString("cTell");
					String cMail = rs.getString("cMail");
					java.sql.Date cBday = rs.getDate("cBday");
					bean = new CustomerBean(cID, cName, cAddress, cTell, cMail, cBday);
				}
				return bean;
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	}
	
	
}
