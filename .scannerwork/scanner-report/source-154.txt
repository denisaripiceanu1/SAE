package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.requetes.delete.RequeteDeleteCompteur;
import modele.dao.requetes.select.RequeteSelectCompteur;
import modele.dao.requetes.select.RequeteSelectCompteurByBien;
import modele.dao.requetes.select.RequeteSelectCompteurById;
import modele.dao.requetes.select.RequeteSelectCompteurParImmeuble;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertCompteur;

public class DaoCompteur extends DaoModele<Compteur> implements Dao<Compteur> {

	/**
	 * Méthode qui crée un étatAppelable pour insérer un nouveau compteur dans la
	 * base de données depuis les sous-programmes.
	 */
	@Override
	public void create(Compteur donnees) throws SQLException {
		SousProgramme<Compteur> sp = new SousProgrammeInsertCompteur();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode non implémentée pour la mise à jour d'un compteur.
	 */
	@Override
	public void update(Compteur donnees) {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui permet de supprimer un compteur dans la base de données depuis
	 * une requête des sous-programmes.
	 */
	@Override
	public void delete(Compteur donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteCompteur(), donnees);
	}

	/**
	 * Méthode qui crée une instance de Compteur à partir du curseur d'une requête
	 * dans la base de données.
	 */
	@Override
	protected Compteur creerInstance(ResultSet curseur) throws SQLException {
		Compteur compteur = null;
		try {
			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			// Récupérer l'identifiant de l'immeuble
			String idImmeuble = curseur.getString("Id_Immeuble");
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			Immeuble immeuble = daoImmeuble.findById(idImmeuble);

			compteur = new Compteur(curseur.getString("id_compteur"), curseur.getString("typeComp"),
					curseur.getDouble("prix_abonnement"), bien, immeuble);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compteur;
	}

	/**
	 * Méthode qui renvoie un Compteur en fonction de son ID depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public Compteur findById(String... id) throws SQLException {
		List<Compteur> compteurs = this.find(new RequeteSelectCompteurById(), id);
		if (compteurs.isEmpty()) {
			return null;
		}
		return compteurs.get(0);
	}

	/**
	 * Méthode qui renvoie un Compteur en fonction de l'ID de l'immeuble associé
	 * depuis les requêtes des sous-programmes.
	 */
	public Compteur findByIdImmeuble(String... id) throws SQLException {
		List<Compteur> compteurs = this.find(new RequeteSelectCompteurParImmeuble(), id);
		if (compteurs.isEmpty()) {
			return null;
		}
		return compteurs.get(0);
	}

	/**
	 * Méthode qui renvoie un Compteur en fonction de l'ID du bien associé depuis
	 * les requêtes des sous-programmes.
	 */
	public Compteur findByIdBien(String... id) throws SQLException {
		List<Compteur> compteurs = this.find(new RequeteSelectCompteurByBien(), id);
		if (compteurs.isEmpty()) {
			return null;
		}
		return compteurs.get(0);
	}

	/**
	 * Méthode qui renvoie une liste de Compteurs en fonction de l'ID de l'immeuble
	 * associé depuis les requêtes des sous-programmes.
	 */
	public List<Compteur> findByIdImmeubleListe(String id) throws SQLException {
		return this.find(new RequeteSelectCompteurParImmeuble(), id);
	}

	/**
	 * Méthode qui renvoie la liste de tous les compteurs depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public List<Compteur> findAll() throws SQLException {
		return this.find(new RequeteSelectCompteur());
	}

	/**
	 * Méthode qui renvoie la liste de Compteurs en fonction de l'ID du bien
	 * associé depuis les requêtes des sous-programmes.
	 */
	public List<Compteur> findByIdBienListe(String idBien) throws SQLException {
		return this.find(new RequeteSelectCompteurByBien(), idBien);
	}

}
