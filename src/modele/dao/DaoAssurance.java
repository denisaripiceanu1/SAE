package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Bien;
import modele.Entreprise;
import modele.dao.requetes.delete.RequeteDeleteAssurance;
import modele.dao.requetes.select.RequeteSelectAssurance;
import modele.dao.requetes.select.RequeteSelectAssuranceById;
import modele.dao.requetes.select.RequeteSelectAssuranceByLogement;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertAssurance;
import modele.dao.requetes.update.RequeteUpdateAssurance;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	/**
	 * Méthode qui crée un étatAppelable pour insérer une nouvelle 
	 * assurance dans la base de donnée depuis les sous-programmes
	 */
	@Override
	public void create(Assurance donnees) throws SQLException {
		SousProgramme<Assurance> sp = new SousProgrammeInsertAssurance();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui permet de modifier les valeurs d'une assurance dans la base de donnée depuis une requête des sous programmes
	 */
	@Override
	public void update(Assurance donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateAssurance(), donnees);
	}

	/**
	 * Méthode qui permet de supprimer une assurance dans la base de donnée depuis une requête des sous programmes
	 */
	@Override
	public void delete(Assurance donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteAssurance(), donnees);
	}

	/**
	 * Méthode qui permet de créer une instance d'une assurance dans le modèle java, à partir d'un curseur d'une requête dans la base de donnée
	 */
	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
		Assurance assurance = null;
		try {
			// Récupérer l'identifiant de l'immeuble
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			// Récupère le bien depuis son ID
			Bien bien = daoBien.findById(idBien);

			// Récupérer l'identifiant de l'entreprise
			String siretEntreprise = curseur.getString("SIRET");
			DaoEntreprise daoEntreprise = new DaoEntreprise();
			// Récupère l'entreprise à partir du siret
			Entreprise entreprise = daoEntreprise.findById(siretEntreprise);
			
			//Créer une instance de assurance à partir du modèle 
			assurance = new Assurance(curseur.getString("numero_police"), curseur.getFloat("montant"), bien,
					entreprise);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assurance;
	}

	/**
	 * Méthode qui renvoit la liste de toute les assurances à partir des requêtes de sous-programmes
	 */
	@Override
	public List<Assurance> findAll() throws SQLException {
		return this.find(new RequeteSelectAssurance());
	}

	/**
	 * Méthode qui renvoit une assurance en fonction de son id à partir des requêtes de sous-programmes
	 */
	@Override
	public Assurance findById(String... id) throws SQLException {
		List<Assurance> assurances = this.find(new RequeteSelectAssuranceById(), id);
		if (assurances.isEmpty()) {
			return null;
		}
		return assurances.get(0);
	}

	// ---------------- AUTRES METHODES ----------------//

	/**
	 * Méthode qui renvoit une liste d'assurance en fonction de l'id d'un appartement qui leur est associé à partir des requêtes de sous-programmes
	 */
	public List<Assurance> findByLogement(String idImmeuble) throws SQLException {
		return this.find(new RequeteSelectAssuranceByLogement(), idImmeuble);
	}

	/**
	 * Méthode qui renvoit une assurance en fonction de l'id d'un appartement qui lui est associé à partir des requêtes de sous-programmes
	 */
	public Assurance findByLogementObject(String idImmeuble) throws SQLException {
		List<Assurance> assurances = this.find(new RequeteSelectAssuranceByLogement(), idImmeuble);
		if (assurances.isEmpty()) {
			return null;
		}
		return assurances.get(0);
	}

}
