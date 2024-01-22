package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.dao.requetes.select.RequeteSelectEntreprise;
import modele.dao.requetes.select.RequeteSelectEntrepriseById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertEntreprise;
import modele.dao.requetes.update.RequeteUpdateEntreprise;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

	/**
	 * Méthode qui crée une nouvelle entreprise dans la base de données depuis les
	 * sous-programmes.
	 */
	@Override
	public void create(Entreprise donnees) throws SQLException {
		SousProgramme<Entreprise> sp = new SousProgrammeInsertEntreprise();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui permet de mettre à jour les informations d'une entreprise dans la
	 * base de données depuis une requête des sous-programmes.
	 */
	@Override
	public void update(Entreprise donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateEntreprise(), donnees);
	}

	/**
	 * Méthode non implémentée pour la suppression d'une entreprise.
	 */
	@Override
	public void delete(Entreprise donnees) {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui renvoie une entreprise en fonction de son ID depuis les requêtes
	 * des sous-programmes.
	 */
	@Override
	public Entreprise findById(String... id) throws SQLException {
		List<Entreprise> entreprises = this.find(new RequeteSelectEntrepriseById(), id);
		if (entreprises.isEmpty()) {
			return null;
		}
		return entreprises.get(0);
	}

	/**
	 * Méthode qui renvoie la liste de toutes les entreprises depuis les requêtes
	 * des sous-programmes.
	 */
	@Override
	public List<Entreprise> findAll() throws SQLException {
		return this.find(new RequeteSelectEntreprise());
	}

	/**
	 * Méthode qui crée une instance d'Entreprise à partir du curseur d'une requête
	 * dans la base de données.
	 */
	@Override
	protected Entreprise creerInstance(ResultSet curseur) throws SQLException {
		Entreprise entreprise = null;
		try {
			entreprise = new Entreprise(curseur.getString("SIRET"), curseur.getString("nom"),
					curseur.getString("adresse"), curseur.getString("cp"), curseur.getString("ville"),
					curseur.getString("mail"), curseur.getString("telephone"), curseur.getString("IBAN"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entreprise;
	}

}
