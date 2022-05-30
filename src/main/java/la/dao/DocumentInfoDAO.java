package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.DocumentInfoBean;



public class DocumentInfoDAO {
	String url = "jdbc:postgresql:bteam";
	String user = "student";
	String pass = "himitu";
    
	public DocumentInfoDAO() throws DAOException {
	
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public DocumentInfoBean ShowAllInfo(int leID)throws DAOException{
		String sql ="SELECT dID, isbn, cCode, dName,  aName, pName, pDate, aDate, renCID, resCID FROM item WHERE dID = ?";
		try(Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1,leID);
			try(ResultSet rs = st.executeQuery();){
				DocumentInfoBean bean = null;
				while(rs.next()) {
					int dID = rs.getInt("dID");
					int isbn = rs.getInt("isbn");
					int cCode = rs.getInt("cCode");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName= rs.getString("pName");
					java.sql.Date pDate= rs.getDate("pDate");
					java.sql.Date aDate = rs.getDate("aDate");
					String renCID = rs.getString("renCID");
					String resCID = rs.getString("resCID");
					if(renCID == null) {
						renCID = "貸出可"; 
					}else {
						renCID="貸出中";
					}
					if(resCID == null) {
						resCID = "予約可";
					}else {
						resCID="予約中";
					}
					 bean = new DocumentInfoBean(dID, isbn, cCode, dName, aName, pName, pDate, aDate, renCID, resCID);
					 
					
				}
				return bean;
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります2");
		}
	}
			
			
		
	


}
