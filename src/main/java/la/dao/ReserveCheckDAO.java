package la.dao;

public class ReserveCheckDAO {
	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";

	public ReserveCheckDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
}
