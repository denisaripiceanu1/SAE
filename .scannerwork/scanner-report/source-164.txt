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
import modele.dao.requetes.select.RequeteSelectLouerArchive;
import modele.dao.requetes.select.RequeteSelectLouerArchiverById;
import modele.dao.requetes.select.RequeteSelectLouerById;
import modele.dao.requetes.select.RequeteSelectLouerMediane;
import modele.dao.requetes.select.RequeteSelectLouerMoyenne;
import modele.dao.requetes.select.RequeteSelectLouerProvision;
import modele.dao.requetes.select.RequeteSelectMoyenneLoyer;
import modele.dao.requetes.select.RequeteSelectNbLocation;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocation;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocationArchiver;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeRegularisationCharges;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeRestantDuLoyers;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeSoldeToutCompte;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeTotalChargesReelles;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeTotalOrduresMenageres;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeTotalProvisions;
import modele.dao.requetes.sousProgramme.calculs.SousProgrammeTotalTravauxImputables;
import modele.dao.requetes.update.RequeteUpdateLouer;

public class DaoLouer extends DaoModele<Louer> implements Dao<Louer> {

	/**
	 * Méthode qui crée une location dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Louer à insérer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void create(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeInsertLocation();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui met à jour une location dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Louer à mettre à jour.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void update(Louer donnees) throws SQLException {
		RequeteUpdateLouer requeteUpdate = new RequeteUpdateLouer();
		miseAJour(requeteUpdate, donnees);
	}

	/**
	 * Méthode qui supprime une location de la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Louer à supprimer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void delete(Louer donnees) throws SQLException {
		miseAJour(new RequeteDeleteLocationByBien(), donnees);
	}

	/**
	 * Méthode qui trouve une location par son identifiant dans la base de données.
	 * 
	 * @param id Identifiant de la location.
	 * @return La location trouvée ou null si elle n'existe pas.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public Louer findById(String... id) throws SQLException {
		List<Louer> louer = find(new RequeteSelectLouerById(), id);
		if (louer.isEmpty()) {
			return null;
		}
		return louer.get(0);
	}

	/**
	 * Méthode qui récupère toutes les locations de la base de données.
	 * 
	 * @return Une liste contenant toutes les locations.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public List<Louer> findAll() throws SQLException {
		return find(new RequeteSelectLouer());
	}

	/**
	 * Méthode qui crée une instance de Louer à partir d'un curseur de résultat SQL.
	 * 
	 * @param curseur Résultat SQL contenant les données de la location.
	 * @return Une instance de Louer.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
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

	/**
	 * Méthode qui recherche et renvoie la liste des locations associées à un bien spécifique.
	 * 
	 * @param id Identifiant du bien.
	 * @return Une liste de locations associées au bien.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Louer> findLocationByBien(String id) throws SQLException {
		return find(new RequeteSelectLocationParBien(), id);
	}

	/**
	 * Méthode qui supprime une location spécifique en utilisant son identifiant.
	 * 
	 * @param id Identifiant de la location à supprimer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public void deleteVrai(Louer id) throws SQLException {
		miseAJour(new RequeteDeleteLocation(), id);
	}

	/**
	 * Méthode qui recherche et renvoie la liste des locations associées à un locataire spécifique.
	 * 
	 * @param idLocataire Identifiant du locataire.
	 * @return Une liste de locations associées au locataire.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Louer> findByLocataire(String idLocataire) throws SQLException {
		return find(new RequeteSelectLocationParLocataire(), idLocataire);
	}

	/**
	 * Méthode qui calcule le total des provisions pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le total des provisions.
	 * @return Le total des provisions.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double totalProvisions(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeTotalProvisions();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}

	/**
	 * Méthode qui calcule le total des charges réelles pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le total des charges réelles.
	 * @return Le total des charges réelles.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double totalChargesRéelles(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeTotalChargesReelles();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}

	/**
	 * Méthode qui calcule le total des ordures ménagères pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le total des ordures ménagères.
	 * @return Le total des ordures ménagères.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double totalOrduresMenageres (Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeTotalOrduresMenageres();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}
	
	/**
	 * Méthode qui calcule le restant dû du loyer pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le restant dû du loyer.
	 * @return Le restant dû du loyer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double restantDuLoyers (Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeRestantDuLoyers();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}
	
	/**
	 * Méthode qui calcule la régularisation des charges pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer la régularisation des charges.
	 * @return La régularisation des charges.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double regularisationCharges(Louer donnees) throws SQLException {
		SousProgramme<Louer> sp = new SousProgrammeRegularisationCharges();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametresCalcul(st, donnees);
		st.execute();
		double resultat = st.getDouble(1);
		st.close();
		return resultat;
	}

	/**
	 * Calcule le total des travaux imputables pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le total des travaux imputables.
	 * @return Le total des travaux imputables.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double travauxImputables(Louer donnees) throws SQLException {
	    SousProgramme<Louer> sp = new SousProgrammeTotalTravauxImputables();
	    CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
	    sp.parametresCalcul(st, donnees);
	    st.execute();
	    double resultat = st.getDouble(1);
	    st.close();
	    return resultat;
	}

	/**
	 * Calcule le solde tout compte pour une location donnée.
	 * 
	 * @param donnees Location pour laquelle calculer le solde tout compte.
	 * @return Le solde tout compte.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public double soldeToutCompte(Louer donnees) throws SQLException {
	    SousProgramme<Louer> sp = new SousProgrammeSoldeToutCompte();
	    CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
	    sp.parametresCalcul(st, donnees);
	    st.execute();
	    double resultat = st.getDouble(1);
	    st.close();
	    return resultat;
	}

	/**
	 * Méthode utilitaire pour créer une instance de ProvisionAnnee à partir d'un curseur SQL.
	 * 
	 * @param curseur Résultat de la requête SQL.
	 * @return Une instance de ProvisionAnnee.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	protected ProvisionAnnee creerInstanceProvisionAnnee(ResultSet curseur) throws SQLException {
	    String annee = curseur.getString("annee");
	    double sommeProvision = curseur.getDouble("SUM(provision_chargeMens_TTC)");

	    return new ProvisionAnnee(annee, sommeProvision);
	}

	/**
	 * Recherche et renvoie la liste des provisions annuelles pour les locations.
	 * 
	 * @return Liste des provisions annuelles.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
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

	/**
	 * Méthode utilitaire pour créer une instance de MoyenneLoyer à partir d'un curseur SQL.
	 * 
	 * @param curseur Résultat de la requête SQL.
	 * @return Une instance de MoyenneLoyer.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	protected MoyenneLoyer creerInstanceMoyenneLoyer(ResultSet curseur) throws SQLException {
	    String annee = curseur.getString("Id_Locataire");
	    int sommeProvision = curseur.getInt("Moyenne_loyer");

	    return new MoyenneLoyer(annee, sommeProvision);
	}

	/**
	 * Recherche et renvoie la liste des moyennes de loyer par locataire.
	 * 
	 * @return Liste des moyennes de loyer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
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

	/**
	 * Recherche et renvoie la moyenne et la médiane des loyers.
	 * 
	 * @return Une instance de MoyenneMediane contenant la moyenne et la médiane des loyers.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public MoyenneMediane findMoyenneMediane() throws SQLException {
	    PreparedStatement prSt = CictOracleDataSource.getConnectionBD()
	            .prepareStatement(new RequeteSelectLouerMoyenne().requete());
	    ResultSet curseur = prSt.executeQuery();

	    double moyenne = 0.0;
	    double mediane = 0.0;

	    if (curseur.next()) {
	        moyenne = curseur.getDouble("MoyenneLoyer");
	    }

	    prSt = CictOracleDataSource.getConnectionBD().prepareStatement(new RequeteSelectLouerMediane().requete());
	    ResultSet curseur1 = prSt.executeQuery();

	    if (curseur1.next()) {
	        mediane = curseur1.getDouble("MedianLoyer");
	    }

	    return new MoyenneMediane(moyenne, mediane);
	}

	/**
	 * Crée une archive pour une location donnée.
	 * 
	 * @param donnees Location à archiver.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public void createArchiver(Louer donnees) throws SQLException {
	    SousProgramme<Louer> sp = new SousProgrammeInsertLocationArchiver();
	    CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
	    sp.parametres(st, donnees);
	    st.execute();
	    st.close();
	}

	/**
	 * Recherche et renvoie une location archivée par son identifiant.
	 * 
	 * @param id Identifiant de la location archivée.
	 * @return Une instance de Louer archivée ou null si non trouvée.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public Louer findByIdArchive(String... id) throws SQLException {
	    List<Louer> louer = find(new RequeteSelectLouerArchiverById(), id);
	    if (louer.isEmpty()) {
	        return null;
	    }
	    return louer.get(0);
	}

	/**
	 * Recherche et renvoie toutes les locations archivées.
	 * 
	 * @return Liste de toutes les locations archivées.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Louer> findAllArchive() throws SQLException {
	    return find(new RequeteSelectLouerArchive());
	}

	/**
	 * Obtient le nombre de locations associées à un locataire spécifique.
	 * 
	 * @param idLocataire Identifiant du locataire.
	 * @return Le nombre de locations associées au locataire.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public int getNombreLocationsParLocataire(String idLocataire) throws SQLException {
	    RequeteSelectNbLocation requeteSelectNbLocation = new RequeteSelectNbLocation();
	    PreparedStatement prSt = CictOracleDataSource.getConnectionBD()
	            .prepareStatement(requeteSelectNbLocation.requete());
	    requeteSelectNbLocation.parametres(prSt, idLocataire);
	    ResultSet resultSet = prSt.executeQuery();

	    int nombreLocations = 0;

	    if (resultSet.next()) {
	        nombreLocations = resultSet.getInt(1);
	    }

	    prSt.close();
	    resultSet.close();

	    return nombreLocations;
	}
}