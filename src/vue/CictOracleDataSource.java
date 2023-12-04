package vue;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class CictOracleDataSource extends OracleDataSource {
	private static CictOracleDataSource COD = null;
	private static Connection connexion;

	private CictOracleDataSource(String login, String mdp) throws SQLException {
		super();
		setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre ");
		setUser(login);
		setPassword(mdp);
	}

	public static Connection getConnexionBD() {
		return connexion;
	}

	public static void creerAcces(String login, String mdp) throws SQLException {
		CictOracleDataSource.COD = new CictOracleDataSource(login, mdp);
		connexion = CictOracleDataSource.COD.getConnection();
	}

	public static void deconnecter() throws SQLException {
		connexion = null;
		CictOracleDataSource.COD = null;
	}
}