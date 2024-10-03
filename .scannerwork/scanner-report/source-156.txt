package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Echeance;
import modele.dao.requetes.delete.RequeteDeleteEcheance;
import modele.dao.requetes.select.RequeteSelectEcheance;
import modele.dao.requetes.select.RequeteSelectEcheanceByAssuranceNumPolice;
import modele.dao.requetes.select.RequeteSelectEcheanceById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertEcheance;

public class DaoEcheance extends DaoModele<Echeance> implements Dao<Echeance> {

	/**
	 * Méthode qui crée une nouvelle échéance dans la base de données depuis les
	 * sous-programmes.
	 */
	@Override
	public void create(Echeance donnees) throws SQLException {
		SousProgramme<Echeance> sp = new SousProgrammeInsertEcheance();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode non implémentée pour la mise à jour d'une échéance.
	 */
	@Override
	public void update(Echeance donnees) {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui permet de supprimer une échéance dans la base de données depuis
	 * une requête des sous-programmes.
	 */
	@Override
	public void delete(Echeance donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteEcheance(), donnees);
	}

	/**
	 * Méthode qui crée une instance d'Echeance à partir du curseur d'une requête
	 * dans la base de données.
	 */
	@Override
	protected Echeance creerInstance(ResultSet curseur) throws SQLException {
		Echeance echeance = null;
		try {
			// Récupérer l'identifiant de l'Assurance
			String numeroPolice = curseur.getString("numero_police");
			DaoAssurance daoAssurance = new DaoAssurance();
			Assurance a = daoAssurance.findById(numeroPolice);

			echeance = new Echeance(a, curseur.getString("date_echeance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return echeance;
	}

	/**
	 * Méthode qui renvoie une échéance en fonction de son ID depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public Echeance findById(String... id) throws SQLException {
		List<Echeance> echeances = this.find(new RequeteSelectEcheanceById(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}

	/**
	 * Méthode qui renvoie une échéance en fonction du numéro de police de
	 * l'assurance associée depuis les requêtes des sous-programmes.
	 */
	public Echeance findByAssuranceNumPolice(String... id) throws SQLException {
		List<Echeance> echeances = this.find(new RequeteSelectEcheanceByAssuranceNumPolice(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}

	/**
	 * Méthode qui renvoie la liste des échéances en fonction du numéro de police de
	 * l'assurance associée depuis les requêtes des sous-programmes.
	 */
	public List<Echeance> findByAssuranceNumPoliceList(String idImmeuble) throws SQLException {
		return this.find(new RequeteSelectEcheanceByAssuranceNumPolice(), idImmeuble);
	}

	/**
	 * Méthode qui renvoie la liste de toutes les échéances depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public List<Echeance> findAll() throws SQLException {
		return this.find(new RequeteSelectEcheance());
	}

}
