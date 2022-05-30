package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.DocumentInfoBean;

public class DocumentAddDAO {
	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";

	public DocumentAddDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	public DocumentInfoBean Add(int leisbn, int lecCode, String ledName, String leaName, String lepName, Date lepDate)
			throws DAOException {
		String sql = "INSERT INTO item (isbn, cCode, dName, aName, pName, pDate,aDate) VALUES (?,?,?,?,?,?,current_date)";
		String sql2 = "SELECT dID, isbn, cCode, dName, aName, pName, pDate, aDate FROM item WHERE isbn = ? AND dName = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, leisbn);
			st.setInt(2, lecCode);
			st.setString(3, ledName);
			st.setString(4, leaName);
			st.setString(5, lepName);
			st.setDate(6, lepDate);
			int rows = st.executeUpdate();
			//

			try (PreparedStatement st1 = con.prepareStatement(sql2);) {
				st1.setInt(1, leisbn);
				st1.setString(2, ledName);
				//
				try (ResultSet rs = st1.executeQuery();) {
					//
					DocumentInfoBean bean = null;
					while (rs.next()) {
						int dID = rs.getInt("dID");
						int isbn = rs.getInt("isbn");
						int cCode = rs.getInt("cCode");
						String dName = rs.getString("dName");
						String aName = rs.getString("aName");
						String pName = rs.getString("pName");
						java.sql.Date pDate = rs.getDate("pDate");
						java.sql.Date aDate = rs.getDate("aDate");
						bean = new DocumentInfoBean(dID, isbn, cCode, dName, aName, pName, pDate, aDate);

					}
					return bean;

				} catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("正しく操作してください");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく操作してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}

	public int CountDocument(String ledName) throws DAOException {
		String sql3 = "SELECT COUNT (*) AS cnt FROM item where dName =?" ;
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql3);) {
			st.setString(1, ledName);
			try (ResultSet rs = st.executeQuery();) {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt("cnt");
					
				}
				return count;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("正しく操作してください");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("正しく操作してください");
		}
	}

}
