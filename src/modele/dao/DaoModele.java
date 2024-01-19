package modele.dao;

import modele.dao.requetes.Requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoModele<T> implements Dao<T> {

	protected Connection connection;

	// Méthode abstraite pour créer une instance à partir du curseur
	protected abstract T creerInstance(ResultSet curseur) throws SQLException;

	// Méthode protégée pour exécuter une requête de sélection
	protected List<T> select(PreparedStatement prSt) throws SQLException {
		ResultSet res = prSt.executeQuery();
		boolean existe = res.next();
		List<T> liste = new ArrayList<>();
		while (existe) {
			liste.add(creerInstance(res));
			existe = res.next();
		}
		res.close();
		return liste;
	}
	

	// Méthode protégée pour exécuter une requête de mise à jour
	protected int miseAJour(Requete<T> requete, T donnee) throws SQLException {
		PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(requete.requete());
		requete.parametres(st, donnee);
		int nbLignes = st.executeUpdate(); 
		st.close();
		return nbLignes; // Nombre de lignes mise à jour

	}
	

	// Méthode protégée pour exécuter une requête de recherche
	protected List<T> find(Requete<T> requete, String... id) throws SQLException {
		PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(requete.requete());
		requete.parametres(st, id);
		List<T> liste = select(st);
		st.close();
		return liste;
	}

	// Méthode protégée pour exécuter une requête de recherche par ID
	public T findById(Requete<T> req, String... id) throws SQLException {
		PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
		req.parametres(st, id);
		st.close();
		List<T> liste = find(req, id);
		if (liste.isEmpty()) {
			return null;
		}
		return liste.get(0);
	}

}
