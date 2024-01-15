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
import modele.MoyenneLoyer;
import modele.MoyenneMediane;
import modele.ProvisionAnnee;
import modele.dao.requetes.delete.RequeteDeleteLocation;
import modele.dao.requetes.delete.RequeteDeleteLocationByBien;
import modele.dao.requetes.select.RequeteSelectLocationParBien;
import modele.dao.requetes.select.RequeteSelectLocationParLocataire;
import modele.dao.requetes.select.RequeteSelectLouer;
import modele.dao.requetes.select.RequeteSelectLouerById;
import modele.dao.requetes.select.RequeteSelectLouerMediane;
import modele.dao.requetes.select.RequeteSelectLouerMoyenne;
import modele.dao.requetes.select.RequeteSelectLouerProvision;
import modele.dao.requetes.select.RequeteSelectMoyenneLoyer;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocation;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeTotalProvisions;
import modele.dao.requetes.update.RequeteUpdateLouer;

public class DaoLouer extends DaoModele<Louer> implements Dao<Louer> {

	@Override
	public void create(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeInsertLocation();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	@Override
	public void update(Louer donnees) throws SQLException {
		RequeteUpdateLouer requeteUpdate = new RequeteUpdateLouer();
		miseAJour(requeteUpdate, donnees);
	}

	@Override
	public void delete(Louer donnees) throws SQLException {
		miseAJour(new RequeteDeleteLocationByBien(), donnees);
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

			// Récupérer l'identifiant du ICC
			String annee = curseur.getString("annee");
			String trimestre = curseur.getString("trimestre");
			DaoICC daoICC = new DaoICC();
			ICC icc = daoICC.findById(annee, trimestre);

			// Convertir les dates en chaînes de caractères
			String dateDebutStr = curseur.getDate("Date_Debut").toString();
			String dateDernRegStr = null;
			if (curseur.getDate("date_derniere_reg") != null) {
				java.sql.Date dateDepart = curseur.getDate("date_derniere_reg");
				dateDernRegStr = dateDepart.toString();
			}

			louer = new Louer(locataire, bien, dateDebutStr, curseur.getInt("nb_mois"), curseur.getDouble("loyer_TTC"),
					curseur.getDouble("provision_chargeMens_TTC"), curseur.getDouble("caution_TTC"),
					curseur.getString("bail"), curseur.getString("etat_lieux"), dateDernRegStr,
					curseur.getInt("loyer_paye"), icc, curseur.getDouble("montant_reel_paye"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return louer;
	}

	// ---------------- AUTRES METHODES ----------------//

	public List<Louer> findLocationByBien(String id) throws SQLException {
		return find(new RequeteSelectLocationParBien(), id);

	}

	public void deleteVrai(Louer id) throws SQLException {
		miseAJour(new RequeteDeleteLocation(), id);
	}

	public List<Louer> findByLocataire(String idLocataire) throws SQLException {
		return find(new RequeteSelectLocationParLocataire(), idLocataire);
	}

	public double totalProvisions(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeTotalProvisions();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}

	protected ProvisionAnnee creerInstanceProvisionAnnee(ResultSet curseur) throws SQLException {
		String annee = curseur.getString("annee");
		double sommeProvision = curseur.getDouble("SUM(provision_chargeMens_TTC)"); // Assurez-vous que c'est le bon
																					// alias SQL

		return new ProvisionAnnee(annee, sommeProvision);
	}

	public List<ProvisionAnnee> findProvisions() throws SQLException {
		List<ProvisionAnnee> resultats = new ArrayList<>();
		PreparedStatement prSt = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectLouerProvision().requete());
		ResultSet curseur = prSt.executeQuery();
		while (curseur.next()) {
			resultats.add(creerInstanceProvisionAnnee(curseur));
		}
		return resultats;
	}

	protected MoyenneLoyer creerInstanceMoyenneLoyer(ResultSet curseur) throws SQLException {
		String annee = curseur.getString("Id_Locataire");
		int sommeProvision = curseur.getInt("Moyenne_loyer"); // Assurez-vous que c'est le bon alias SQL

		return new MoyenneLoyer(annee, sommeProvision);
	}

	public List<MoyenneLoyer> findMoyenneLoyer() throws SQLException {
		List<MoyenneLoyer> resultats = new ArrayList<>();
		PreparedStatement prSt = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectMoyenneLoyer().requete());
		ResultSet curseur = prSt.executeQuery();
		while (curseur.next()) {
			resultats.add(creerInstanceMoyenneLoyer(curseur));
		}
		return resultats;
	}

	public MoyenneMediane findMoyenneMediane() throws SQLException {
		PreparedStatement prSt = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectLouerMoyenne().requete());
		ResultSet curseur = prSt.executeQuery();
		double moyenne = curseur.getDouble("MoyenneLoyer");
		PreparedStatement prSt1 = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectLouerMediane().requete());
		ResultSet curseur1 = prSt.executeQuery();
		double mediane = curseur.getDouble("MedianeLoyer");

		return new MoyenneMediane(moyenne, mediane);
	}
}
