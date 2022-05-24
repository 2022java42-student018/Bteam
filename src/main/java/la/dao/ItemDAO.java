package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;



public class ItemDAO {
	
	String url="jdbc:postgresql:sample";
	String user="student";
	String pass="himitu";
	
	public ItemDAO()throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public List<ItemBean>dIDSearchDESC(int ledID) throws DAOException{
		
			String sql="SELECT document_id,title,writer,publisher_date,rental_id FROM bitem WHERER document_id LIKE '%?%' ORDER BY document_id DESC";
		try(
		    Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);
			){
			st.setInt(1, ledID);
		try(
			ResultSet rs = st.executeQuery();
			){
			List<ItemBean>list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int dID=rs.getInt("document_id");
				String dName = rs.getString("title");
				String aName = rs.getString("writer");
				String pName = rs.getString("publisher");
				int renCID = rs.getInt("rental_id");
				ItemBean bean = new ItemBean(dID,dName,aName,pName,renCID);
				list.add(bean);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");
		}
	}
	
	
	public List<ItemBean>dIDSearch(int ledID) throws DAOException{
		String sql = "SELECT document_id,title,writer,publisher,rental_id FROM bitem WHERER document_id LIKE '%?%' ORDER BY document_id";
		
		try(
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);
			){
			st.setInt(1, ledID);
		try(
			ResultSet rs = st.executeQuery();
			){
			List<ItemBean>list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int dID=rs.getInt("document_id");
				String dName = rs.getString("title");
				String aName = rs.getString("writer");
				String pName = rs.getString("publisher");
				int renCID = rs.getInt("rental_id");
				ItemBean bean = new ItemBean(dID,dName,aName,pName,renCID);
				list.add(bean);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");	
		}
		}catch	(SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");	
		}
	}
		
		
	public List<ItemBean>dNameSearch(String ledName)throws DAOException{
			String sql="SELECT document_id,title,writer,publisher,rental_id FROM bitem WHERER writer LIKE '%?%' ORDER BY document_id";
		try(
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement st = con.prepareStatement(sql);
				){
				st.setString(1, ledName);
			try(
				ResultSet rs = st.executeQuery();
				){
				List<ItemBean>list = new ArrayList<ItemBean>();
				while(rs.next()) {
					int dID=rs.getInt("document_id");
					String dName = rs.getString("title");
					String aName = rs.getString("writer");
					String pName = rs.getString("publisher");
					int renCID = rs.getInt("rental_id");
					ItemBean bean = new ItemBean(dID,dName,aName,pName,renCID);
					list.add(bean);
				}
				return list;
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");	
			}
			}catch	(SQLException e) {
				e.printStackTrace();
				throw new DAOException("入力した内容に不備があります");	
			}
		}
	
	
public List<ItemBean>aNameSearch(String leaName)throws DAOException{
		String sql="SELECT document_id,title,writer,publisher,rental_id FROM bitem WHERER writer LIKE '%?%' ORDER BY document_id";
	try(
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement(sql);
			){
			st.setString(1, leaName);
		try(
			ResultSet rs = st.executeQuery();
			){
			List<ItemBean>list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int dID=rs.getInt("document_id");
				String dName = rs.getString("title");
				String aName = rs.getString("writer");
				String pName = rs.getString("publisher");
				int renCID = rs.getInt("rental_id");
				ItemBean bean = new ItemBean(dID,dName,aName,pName,renCID);
				list.add(bean);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");	
		}
		}catch	(SQLException e) {
			e.printStackTrace();
			throw new DAOException("入力した内容に不備があります");	
		}
	}
			
	}




