package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.Immeuble;
import modele.dao.requetes.delete.RequeteDeleteTravaux;
import modele.dao.requetes.select.RequeteSelectFacture;
import modele.dao.requetes.select.RequeteSelectFactureArchive;
import modele.dao.requetes.select.RequeteSelectFactureByBien;
import modele.dao.requetes.select.RequeteSelectFactureByBien2;
import modele.dao.requetes.select.RequeteSelectFactureById;
import modele.dao.requetes.select.RequeteSelectFactureByImmeuble;
import modele.dao.requetes.select.RequeteSelectFactureByLogement;
import modele.dao.requetes.select.RequeteSelectFactureCharge;
import modele.dao.requetes.select.RequeteSelectFactureChargeById;
import modele.dao.requetes.select.RequeteSelectFactureTravaux;
import modele.dao.requetes.select.RequeteSelectFactureTravauxById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertFacture;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertFactureArchiver;
import modele.dao.requetes.update.RequeteUpdateFacture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	/**
	 * Méthode qui crée une nouvelle facture dans la base de données depuis les
	 * sous-programmes.
	 */
	@Override
	public void create(Facture donnees) throws SQLException {
		SousProgramme<Facture> sp = new SousProgrammeInsertFacture();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui permet de mettre à jour les informations d'une facture dans la
	 * base de données depuis une requête des sous-programmes.
	 */
	@Override
	public void update(Facture donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateFacture(), donnees);
	}

	/**
	 * Méthode qui permet de supprimer une facture dans la base de données depuis
	 * une requête des sous-programmes.
	 */
	@Override
	public void delete(Facture donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteTravaux(), donnees);
	}

	/**
	 * Méthode qui renvoie une facture en fonction de son ID depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public Facture findById(String... id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	/**
	 * Méthode qui renvoie la liste de toutes les factures depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public List<Facture> findAll() throws SQLException {
		return this.find(new RequeteSelectFacture());
	}

	/**
	 * Méthode qui crée une instance de Facture à partir du curseur d'une requête
	 * dans la base de données.
	 */
	@Override
	protected Facture creerInstance(ResultSet curseur) throws SQLException {
		Facture facture = null;
		try {
			// Récupérer l'identifiant de l'immeuble
			String idImmeuble = curseur.getString("Id_Immeuble");
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			Immeuble immeuble = daoImmeuble.findById(idImmeuble);

			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			// Récupérer l'identifiant de l'Entreprise
			String siret = curseur.getString("SIRET");
			DaoEntreprise daoEntreprise = new DaoEntreprise();
			Entreprise entreprise = daoEntreprise.findById(siret);

			// Convertir les dates en chaînes de caractères avec un format spécifique
			java.sql.Date dateEmission = curseur.getDate("date_emission");
			java.sql.Date datePaiement = curseur.getDate("date_paiement");

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dateEmissionStr = "N/A";
			if (dateEmission != null) {
				dateEmissionStr = dateFormat.format(dateEmission);
			}

			String datePaiementStr = "N/A";
			if (datePaiement != null) {
				datePaiementStr = dateFormat.format(datePaiement);
			}

			facture = new Facture(curseur.getString("numero"), dateEmissionStr, datePaiementStr,
					curseur.getString("mode_paiement"), curseur.getString("numero_devis"),
					curseur.getString("designation"), curseur.getDouble("montant_reel_paye"),
					curseur.getDouble("montant"), curseur.getInt("imputable_locataire"), immeuble, bien, entreprise);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return facture;
	}

	// ---------------- AUTRES METHODES ----------------//

	/**
	 * Méthode qui renvoie la dernière facture de loyer d'un bien depuis les
	 * requêtes des sous-programmes.
	 */
	public Facture findDerniereFactureLoyer(Bien bien) throws SQLException {
		List<Facture> factures = null;
		String b = bien.getIdBien();
		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectFactureByBien().requete())) {
			new RequeteSelectFactureByBien().parametres(st, b);
			ResultSet res = st.executeQuery();
			factures = this.convertirResultSetEnListe(res);
			res.close();
		}
		if (!factures.isEmpty()) {
			return factures.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Méthode privée pour convertir un ResultSet en liste de factures.
	 */
	private List<Facture> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Facture> factures = new ArrayList<>();

		while (res.next()) {
			Facture f = this.creerInstance(res);
			factures.add(f);
		}
		return factures;
	}

	/**
	 * Méthode qui renvoie la liste de factures associées à un logement depuis les
	 * requêtes des sous-programmes.
	 */
	public List<Facture> findFactureChargeByLogement(String idLogement) throws SQLException {
		return this.find(new RequeteSelectFactureByLogement(), idLogement);
	}

	/**
	 * Méthode qui renvoie la liste de toutes les factures de charges depuis les
	 * requêtes des sous-programmes.
	 */
	public List<Facture> findFactureCharge() throws SQLException {
		return this.find(new RequeteSelectFactureCharge());
	}

	/**
	 * Méthode qui renvoie la liste de factures associées à un immeuble depuis les
	 * requêtes des sous-programmes.
	 */
	public List<Facture> findFactureImmeuble(String id) throws SQLException {
		return this.find(new RequeteSelectFactureByImmeuble(), id);
	}

	/**
	 * Méthode qui renvoie la liste de factures associées à un bien depuis les
	 * requêtes des sous-programmes.
	 */
	public List<Facture> findFactureByBien(String id) throws SQLException {
		return this.find(new RequeteSelectFactureByBien2(), id);
	}

	/**
	 * Méthode qui renvoie une facture de charge en fonction de son ID depuis les
	 * requêtes des sous-programmes.
	 */
	public Facture findFactureChargeById(String id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureChargeById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	/**
	 * Méthode qui renvoie la liste de toutes les factures de travaux depuis les
	 * requêtes des sous-programmes.
	 */
	public List<Facture> findFactureTravaux() throws SQLException {
		return this.find(new RequeteSelectFactureTravaux());
	}

	/**
	 * Méthode qui renvoie une facture de travaux en fonction de son ID depuis les
	 * requêtes des sous-programmes.
	 */
	public Facture findFactureTravauxById(String id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureTravauxById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	/**
	 * Méthode qui crée une archive de facture dans la base de données depuis les
	 * sous-programmes.
	 */
	public void createArchive(Facture donnees) throws SQLException {
		SousProgramme<Facture> sp = new SousProgrammeInsertFactureArchiver();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui récupère toutes les factures archivées depuis la base de données.
	 * 
	 * @return Une liste contenant toutes les factures archivées.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Facture> findAllArchive() throws SQLException {
	    return this.find(new RequeteSelectFactureArchive());
	}

}