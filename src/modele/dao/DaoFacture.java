package modele.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectFacture;
import modele.dao.requetes.select.RequeteSelectFactureByBien;
import modele.dao.requetes.select.RequeteSelectFactureById;
import modele.dao.requetes.update.RequeteUpdateFacture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	@Override
	public void create(Facture donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Facture donnees) throws SQLException {
		miseAJour(new RequeteUpdateFacture(), donnees);

	}

	@Override
	public void delete(Facture donnees) {
		delete(donnees);

	}

	@Override
	public Facture findById(String... id) throws SQLException {
		List<Facture> factures = find(new RequeteSelectFactureById(), id);
		if (factures.isEmpty()) {
			return null;
		}
		return factures.get(0);
	}

	@Override
	public List<Facture> findAll() throws SQLException {
		return find(new RequeteSelectFacture());
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

			// Convertir les dates en chaînes de caractères
			java.sql.Date dateEmission = curseur.getDate("date_emission");
			java.sql.Date datePaiement = curseur.getDate("date_paiement");
			String dateEmissionStr = dateEmission.toString();
			String datePaiementStr = datePaiement.toString();

			facture = new Facture(curseur.getInt("Id_Facture"), curseur.getString("numero"), dateEmissionStr,
					datePaiementStr, curseur.getString("mode_paiement "), curseur.getString("numero_devis "),
					curseur.getString("designation"), curseur.getDouble("accompte_verse "),
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

	        factures = convertirResultSetEnListe(res);
	        st.close();
	    }

	    // Vérifier si la liste de factures est vide avant d'accéder à l'élément
	    if (!factures.isEmpty()) {
	        return factures.get(0);
	    } else {
	        // Retourner null ou une autre valeur par défaut, selon votre logique métier
	        return null;
	    }
	}


	private List<Facture> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Facture> factures = new ArrayList<>();

		while (res.next()) {
			Facture f = creerInstance(res);
			factures.add(f);
		}

		return factures;
	}

}
