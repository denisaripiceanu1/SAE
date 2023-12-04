package modele.dao;

import java.sql.Connection;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class CictOracleDataSource extends OracleDataSource {

	private static Connection connection;

	private CictOracleDataSource(String nom, String mdp) throws SQLException {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
		this.setUser(nom);
		this.setPassword(mdp);
	}

	// Méthode pour créer ou récupérer la connexion unique (Singleton)
	public static Connection creerAcces(String nom, String mdp) throws SQLException {
		if (connection == null || connection.isClosed()) {
			// Si la connexion n'existe pas ou est fermée, on la crée
			CictOracleDataSource dataSource = new CictOracleDataSource(nom, mdp);
			connection = dataSource.getConnection();
		}
		return connection;
	}

	// Méthode pour récupérer la connexion
	public static Connection getConnectionBD() {
		return connection;
	}

	// Méthode pour déconnecter
	public static void deconnecter() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
		connection = null;
	}
}