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
import modele.dao.requetes.update.RequeteUpdateFacture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	@Override
	public void create(Facture donnees) throws SQLException {
		SousProgramme<Facture> sp = new SousProgrammeInsertFacture();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Facture donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateFacture(), donnees);

	}

	@Override
	public void delete(Facture donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteTravaux(), donnees);

	}

	@Override
	public Facture findById(String... id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	@Override
	public List<Facture> findAll() throws SQLException {
		return this.find(new RequeteSelectFacture());
	}

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
					curseur.getString("designation"), curseur.getDouble("montant_reel_paye"), curseur.getDouble("montant"),
					curseur.getInt("imputable_locataire"), immeuble, bien, entreprise);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return facture;
	}

	// ---------------- AUTRES METHODES ----------------//
	public Facture findDerniereFactureLoyer(Bien bien) throws SQLException {
		List<Facture> factures = null;
		String b = bien.getIdBien();
		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectFactureByBien().requete())) {
			new RequeteSelectFactureByBien().parametres(st, b);
			ResultSet res = st.executeQuery();
			factures = this.convertirResultSetEnListe(res);
			st.close();
		}
		if (!factures.isEmpty()) {
			return factures.get(0);
		} else {
			return null;
		}
	}

	private List<Facture> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Facture> factures = new ArrayList<>();

		while (res.next()) {
			Facture f = this.creerInstance(res);
			factures.add(f);
		}
		return factures;
	}

	public List<Facture> findFactureChargeByLogement(String idLogement) throws SQLException {
		return this.find(new RequeteSelectFactureByLogement(), idLogement);
	}

	public List<Facture> findFactureCharge() throws SQLException {
		return this.find(new RequeteSelectFactureCharge());
	}

	public List<Facture> findFactureImmeuble(String id) throws SQLException {
		return find(new RequeteSelectFactureByImmeuble(), id);
	}

	public List<Facture> findFactureByBien(String id) throws SQLException {
		return find(new RequeteSelectFactureByBien2(), id);
	}

	public Facture findFactureChargeById(String id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureChargeById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	public List<Facture> findFactureTravaux() throws SQLException {
		return this.find(new RequeteSelectFactureTravaux());
	}

	public Facture findFactureTravauxById(String id) throws SQLException {
		List<Facture> factures = this.find(new RequeteSelectFactureTravauxById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}
}