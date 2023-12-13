package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Bien;
import modele.ICC;
import modele.Locataire;
import modele.Louer;
import modele.dao.requetes.select.RequeteSelectLocationParBien;
import modele.dao.requetes.select.RequeteSelectLouer;
import modele.dao.requetes.select.RequeteSelectLouerById;
import modele.dao.requetes.sousProgramme.SousProgrammeDeleteLocation;
import modele.dao.requetes.update.RequeteUpdateLouer;

public class DaoLouer extends DaoModele<Louer> implements Dao<Louer> {

	@Override
	public void create(Louer donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Louer donnees) throws SQLException {
		RequeteUpdateLouer requeteUpdate = new RequeteUpdateLouer();
		miseAJour(requeteUpdate, donnees);
	}

	@Override
	public void delete(Louer donnees) throws SQLException {
		SousProgrammeDeleteLocation sousProgramme = new SousProgrammeDeleteLocation(donnees.getIdLocataire(),
				donnees.getIdBien(), donnees.getDateDebut());

		try (CallableStatement st = connection.prepareCall(sousProgramme.appelSousProgramme())) {
			sousProgramme.parametres(st);
			st.execute();
		}
	}

	@Override
	public Louer findById(String... id) throws SQLException {
		List<Louer> louer = find(new RequeteSelectLouerById(), id);
		if (louer.isEmpty()) {
			return null;
		}
		return louer.get(0);
	}

	@Override
	public List<Louer> findAll() throws SQLException {
		return find(new RequeteSelectLouer());
	}

	public List<Louer> findLocationByBien(String id) throws SQLException {
		List<Louer> locations = null;
		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectLocationParBien().requete())) {
			new RequeteSelectLocationParBien().parametres(st, id);
			ResultSet res = st.executeQuery();
			locations = convertirResultSetEnListe(res);
			st.close();
		}
		
		return locations;

	}

	private List<Louer> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Louer> locations = new ArrayList<>();

		while (res.next()) {
			Louer l = creerInstance(res);
			locations.add(l);
		}

		return locations;
	}

	@Override
	protected Louer creerInstance(ResultSet curseur) throws SQLException {
		Louer louer = null;
		try {
			// Récupérer l'identifiant du Locataire
			String idLocataire = curseur.getString("Id_Locataire");
			DaoLocataire daoLocataire = new DaoLocataire();
			Locataire locataire = daoLocataire.findById(idLocataire);

			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			// Récupérer l'identifiant de l'Annee
			String annee = curseur.getString("annee");
			String trimestre = curseur.getString("trimestre");
			DaoICC daoICC = new DaoICC();
			ICC icc = daoICC.findById(annee, trimestre);

			// Convertir les dates en chaînes de caractères
			String dateDepartStr = null;
			java.sql.Date dateDebut = curseur.getDate("date_debut");
			String dateDebutStr = dateDebut.toString();
			if (curseur.getDate("date_depart") != null) {
				java.sql.Date dateDepart = curseur.getDate("date_depart");
				dateDepartStr = dateDepart.toString();
			}
			louer = new Louer(locataire, bien, dateDebutStr, curseur.getInt("nb_mois"), curseur.getDouble("loyer_TTC"),
					curseur.getDouble("provision_chargeMens_TTC"), curseur.getDouble("caution_TTC"),
					curseur.getString("bail"), curseur.getString("etat_lieux"), dateDepartStr,
					curseur.getInt("loyer_paye"), curseur.getInt("colocation"), curseur.getDouble("montant_reel_paye"),
					icc.getAnnee(), icc.getTrimestre());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return louer;
	}

}
