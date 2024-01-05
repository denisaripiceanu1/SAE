package modele.dao;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Locataire;
import modele.dao.requetes.select.RequeteSelectLocataire;
import modele.dao.requetes.select.RequeteSelectLocataireById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocataire;
import modele.dao.requetes.update.RequeteUpdateLocataire;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	@Override
	public void create(Locataire donnees) throws SQLException {
		SousProgramme<Locataire> sp = new SousProgrammeInsertLocataire();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();

	}

	@Override
	public void update(Locataire donnees) throws SQLException {

		this.miseAJour(new RequeteUpdateLocataire(), donnees);

	}

	@Override
	public void delete(Locataire donnees) {

	}

	@Override
	public Locataire findById(String... id) throws SQLException {
		List<Locataire> locataires = find(new RequeteSelectLocataireById(), id);
		if (locataires.isEmpty()) {
			return null;
		}
		return locataires.get(0);
	}

	@Override
	public List<Locataire> findAll() throws SQLException {
		return find(new RequeteSelectLocataire());
	}

	@Override
	protected Locataire creerInstance(ResultSet curseur) throws SQLException {
		Locataire locataire = null;
		try {
			// Convertir les dates en chaînes de caractères
			java.sql.Date dateNaissance = curseur.getDate("date_naissance");
			String dateNaissanceStr = dateNaissance.toString();

			locataire = new Locataire(curseur.getString("Id_Locataire"), curseur.getString("nom"),
					curseur.getString("prenom"), curseur.getString("telephone"), curseur.getString("mail"),
					dateNaissanceStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locataire;
	}

	public List<String> getAllIdLocataire() throws SQLException {
		List<String> identifiants = new ArrayList<>();

		String sql = "SELECT ID_Locataire FROM LOCATAIRE";

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
				ResultSet resultSet = st.executeQuery()) {

			while (resultSet.next()) {
				identifiants.add(resultSet.getString("ID_Locataire"));
			}
		}

		return identifiants;
	}

}