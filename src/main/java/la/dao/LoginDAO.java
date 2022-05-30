package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private String url = "jdbc:postgresql:bteam";
	private String user = "student";
	private String pass = "himitu";

	public LoginDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました。");
		}
	}

	public boolean Check(int oID, String oPassword) throws DAOException {
		String sql = "SELECT password FROM OWNER WHERE oID = ?";
		boolean Check = false;

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, oID);

			try (ResultSet rs = st.executeQuery();) {
				String password = rs.getString("password");

				if (password.equals(oPassword)) {
					Check = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("ログインIDかパスワードが間違っています");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Check;
	}
}
