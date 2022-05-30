package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentChangeDelateDAO {
	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";
    
	public DocumentChangeDelateDAO()throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new DAOException("ドライバの登録に失敗しました");
			}
		}
		
	public int Delate(int leID)throws DAOException{
		String sql = "DELETE FROM item WHERE dID = ?";
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
		String sql = "SELECT * FROM item WHERE dID =?";
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
	
	public int Change( int ledID,int leisbn, int lecCode, String ledName, String leaName, String lepName, Date lepDate)throws DAOException {
		String spl ="UPDATE item SET isbn = ?, cCode = ? , dName = ? , aName = ? , pName = ? , pDate = ? WHERE dID = ? ";
		try(Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(spl);){
			st.setInt(1, leisbn);
			st.setInt(2, lecCode);
			st.setString(3, ledName);
			st.setString(4, leaName);
			st.setString(5, lepName);
			st.setDate(6, lepDate);
			st.setInt(7,ledID);
			int rows =st.executeUpdate();
			return rows;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}
		
	}
	


