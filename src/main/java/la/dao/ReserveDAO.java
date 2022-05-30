
package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ReserveBean;

public class ReserveDAO {

	String url = "jdbc:postgresql:bteam";
	String user = "student";
	String pass = "himitu";

	public ReserveDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public boolean reservestart(int dID) throws DAOException {

		// SQL文の作成
		String sql = "SELECT resCID FROM item WHERE dID= ? ";
		boolean Confirmation;

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PaeparedStatementオブジェクトの所得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, dID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					Confirmation = false;
				} else {
					Confirmation = true;
				}
				return Confirmation;

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDが間違っています。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDが間違っています。");
		}
	}

	public List<ReserveBean> name_serch(int user_id) throws DAOException {
		String sql = "SELECT * FROM customer WEHRE cID = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, user_id);

			try (ResultSet rs = st.executeQuery();) {
				List<ReserveBean> list = new ArrayList<ReserveBean>();
				while (rs.next()) {
					String cName = rs.getString("cName");
					int cID = rs.getInt("cID");
					ReserveBean bean = new ReserveBean(cName,cID);
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("会員IDが間違っています。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("会員IDが間違っています。");
		}
	}
	public List<ReserveBean> Document_serch (String item_id) throws DAOException{
		String sql ="SELECT * FROM Items WEHRE item_id = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, item_id);

			try (ResultSet rs = st.executeQuery();) {
				List<ReserveBean> list = new ArrayList<ReserveBean>();
				while (rs.next()) {
					int dID =rs.getInt("dID");
					int isbn =rs.getInt("isbn");
					String dName= rs.getString("dName");
					int cCode= rs.getInt("cCode");
					String aName= rs.getString("aName");
					String pName= rs.getString("pName");
					String pDate= rs.getString("pDate");
					int renCID= rs.getInt("renCID");
					int resCID= rs.getInt("resCID");
					
					ReserveBean bean = new ReserveBean(pDate,isbn,dName,cCode,aName,pName,dID,renCID,resCID);
					list.add(bean);
				}
				return list;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DAOException("会員IDが間違っています。");
	}
} catch (SQLException e) {
	e.printStackTrace();
	throw new DAOException("会員IDが間違っています。");
}
}
}
