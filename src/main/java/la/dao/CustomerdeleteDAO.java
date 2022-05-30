package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.CustomerBean;

public class CustomerdeleteDAO {
	private String url = "jdbc:postgresql:bteam";
	private String user = "postgres";
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
	
	public List<CustomerBean> getcustomer(int cID)throws DAOException{
		String sql = "SELECT * FROM customer WHERE cID = ?";
		try(
		   Connection con = DriverManager.getConnection(url, user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1, cID);
			try (
					/// SQLの実行
					ResultSet rs = st.executeQuery();) {
				List<CustomerBean> list = new ArrayList<CustomerBean>();
				String cName = rs.getString("cName");
				String cAddress = rs.getString("cAddress");
				String cTell = rs.getString("cTell");
				String cMail = rs.getString("cMail");
				Date cBday = rs.getDate("cBday");
				Date cJdate = rs.getDate("cJdate");
				CustomerBean bean = new CustomerBean(cID,cName,cAddress,cTell,cMail,cBday,cJdate,null);
				list.add(bean);
				return list;
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく操作してください");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
	
	public int Delete(int cID)throws DAOException{
		String sql = "UPDATE customer SET cWdate=? WHERE cID =?";
		Date Date = new Date();
		long timeInMilliSeconds = Date.getTime();
		java.sql.Date today = new java.sql.Date(timeInMilliSeconds);
		
		try(
		   Connection con = DriverManager.getConnection(url, user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setDate(1, today);
			st.setInt(2, cID);
			int rows =st.executeUpdate();
			return rows;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
}
