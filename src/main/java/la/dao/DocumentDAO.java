package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.DocumentBean;

public class DocumentDAO {

	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";
    
	public DocumentDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	public List<DocumentBean> dIDSearchDESC(int ledID) throws DAOException {

		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE dID LIKE '%?%' ORDER BY dID DESC";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, ledID);
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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

	public List<DocumentBean> dIDSearch(int ledID) throws DAOException {
		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE dID = ? ORDER BY dID";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, ledID);
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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

	public List<DocumentBean> dNameSearch(String ledName) throws DAOException {
		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE dName LIKE ? ORDER BY dID";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, ledName+"%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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
	
	public List<DocumentBean> dNameSearchASC(String ledName) throws DAOException {
		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE dName LIKE ? ORDER BY dName";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, ledName+"%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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
	public List<DocumentBean> dNameSearchDESC(String ses) throws DAOException {
		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE dName LIKE ? ORDER BY dName DESC";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, ses+"%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
				    String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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

	public List<DocumentBean> aNameSearch(String leaName) throws DAOException {
		String sql = "SELECT dID,dName,aName,pName,renCID FROM item WHERE aName LIKE ? ORDER BY dID";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, leaName + "%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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
	
	public List<DocumentBean> aNameSearchASC(String leaName) throws DAOException {
		String sql = "SELECT   dID,dName,aName,pName,renCID FROM item WHERE aName LIKE ? ORDER BY aName ";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, leaName + "%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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
	
	public List<DocumentBean> aNameSearchDESC(String leaName) throws DAOException {
		String sql = "SELECT   dID,dName,aName,pName,renCID FROM item WHERE aName LIKE ? ORDER BY aName DESC";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, leaName + "%");
			try (ResultSet rs = st.executeQuery();) {
				List<DocumentBean> list = new ArrayList<DocumentBean>();
				while (rs.next()) {
					int dID = rs.getInt("dID");
					String dName = rs.getString("dName");
					String aName = rs.getString("aName");
					String pName = rs.getString("pName");
					String renCID = rs.getString("renCID");
					if(renCID == null) {
						renCID = "貸出可";
					}else {
						renCID="貸出中";
					}
					DocumentBean bean = new DocumentBean(dID, dName, aName, pName, renCID);
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
