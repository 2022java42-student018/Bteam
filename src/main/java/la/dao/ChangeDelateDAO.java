package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeDelateDAO {
	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";
    
	public ChangeDelateDAO()throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new DAOException("ドライバの登録に失敗しました");
			}
		}
		
	public int Delate(int leID)throws DAOException{
		String sql = "DELETE FROM bitem WHERE dID = ?";
		try(
		   Connection con = DriverManager.getConnection(url, user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1, leID);
			int rows =st.executeUpdate();
			return rows;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
	
	public int PreDelate( int leID)throws DAOException{
		String sql = "SELECT * FROM bitem WHERE dID =?";
		try(Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);){
			st.setInt(1, leID);
			try(ResultSet rs = st.executeQuery();){
				int dID=0;
				while(rs.next()) {
					dID= rs.getInt("dID");
				}
				return dID;
				
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


