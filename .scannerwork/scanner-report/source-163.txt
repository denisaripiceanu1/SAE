package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Locataire;
import modele.dao.requetes.delete.RequeteDeleteLocataire;
import modele.dao.requetes.select.RequeteSelectLocataire;
import modele.dao.requetes.select.RequeteSelectLocataireArchive;
import modele.dao.requetes.select.RequeteSelectLocataireById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocataire;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocataireArchive;
import modele.dao.requetes.update.RequeteUpdateLocataire;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	/**
	 * Méthode qui insère un locataire dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Locataire à insérer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void create(Locataire donnees) throws SQLException {
		SousProgramme<Locataire> sp = new SousProgrammeInsertLocataire();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui met à jour un locataire dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Locataire à mettre à jour.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void update(Locataire donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateLocataire(), donnees);
	}

	/**
	 * Méthode qui supprime un locataire de la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Locataire à supprimer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void delete(Locataire donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteLocataire(), donnees);
	}

	/**
	 * Méthode qui trouve un locataire par son identifiant dans la base de données.
	 * 
	 * @param id Identifiant du locataire.
	 * @return Le locataire trouvé ou null s'il n'existe pas.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public Locataire findById(String... id) throws SQLException {
		List<Locataire> locataires = this.find(new RequeteSelectLocataireById(), id);
		if (locataires.isEmpty()) {
			return null;
		}
		return locataires.get(0);
	}

	/**
	 * Méthode qui récupère tous les locataires de la base de données.
	 * 
	 * @return Une liste contenant tous les locataires.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public List<Locataire> findAll() throws SQLException {
		return this.find(new RequeteSelectLocataire());
	}

	/**
	 * Méthode qui crée une instance de Locataire à partir d'un curseur de résultat SQL.
	 * 
	 * @param curseur Résultat SQL contenant les données du Locataire.
	 * @return Une instance de Locataire.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	@Override
	protected Locataire creerInstance(ResultSet curseur) throws SQLException {
		Locataire locataire = null;
		try {
			// Convertir les dates en chaînes de caractères
			java.sql.Date dateNaissance = curseur.getDate("date_naissance");
			String dateNaissanceStr = dateNaissance.toString();

			locataire = new Locataire(curseur.getString("Id_Locataire"), curseur.getString("nom"),
					curseur.getString("prenom"), curseur.getString("telephone"), curseur.getString("mail"),
					dateNaissanceStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locataire;
	}

	/**
	 * Méthode qui récupère tous les identifiants de locataires depuis la base de données.
	 * 
	 * @return Une liste contenant tous les identifiants de locataires.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<String> getAllIdLocataire() throws SQLException {
		List<String> identifiants = new ArrayList<>();

		String sql = "SELECT ID_Locataire FROM LOCATAIRE";

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
				ResultSet resultSet = st.executeQuery()) {

			while (resultSet.next()) {
				identifiants.add(resultSet.getString("ID_Locataire"));
			}
		}
		return identifiants;
	}

	/**
	 * Méthode qui insère un locataire dans la table d'archives en utilisant un sous-programme dédié.
	 * 
	 * @param donnees Locataire à archiver.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public void createArchive(Locataire donnees) throws SQLException {
		SousProgramme<Locataire> sp = new SousProgrammeInsertLocataireArchive();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui récupère tous les locataires archivés depuis la base de données.
	 * 
	 * @return Une liste contenant tous les locataires archivés.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Locataire> findAllArchive() throws SQLException {
		return this.find(new RequeteSelectLocataireArchive());
	}

}
