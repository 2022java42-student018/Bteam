
package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReserveDAO {

	String url = "jdbc:postgresql:sample";
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

	public boolean Confirmation(int dID) throws DAOException {

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
}
