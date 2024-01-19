package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Imposer;
import modele.Impôt;
import modele.dao.requetes.delete.RequeteDeleteImposerByImmeuble;
import modele.dao.requetes.select.RequeteSelectImposer;
import modele.dao.requetes.select.RequeteSelectImposerByBien;
import modele.dao.requetes.select.RequeteSelectImposerById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertImposer;

public class DaoImposer extends DaoModele<Imposer> implements Dao<Imposer> {

	/**
	 * Méthode qui insère un imposer dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Imposer à insérer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void create(Imposer donnees) throws SQLException {
		SousProgramme<Imposer> sp = new SousProgrammeInsertImposer();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui met à jour un imposer dans la base de données (non implémentée dans cette classe).
	 * 
	 * @param donnees Imposer à mettre à jour.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void update(Imposer donnees) throws SQLException {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui supprime un imposer de la base de données en utilisant la méthode de la classe mère.
	 * 
	 * @param donnees Imposer à supprimer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void delete(Imposer donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteImposerByImmeuble(), donnees);
	}

	/**
	 * Méthode qui crée une instance d'Imposer à partir d'un curseur de résultat SQL.
	 * 
	 * @param curseur Résultat SQL contenant les données de l'Imposer.
	 * @return Une instance d'Imposer.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	@Override
	protected Imposer creerInstance(ResultSet curseur) throws SQLException {
		Imposer imposer = null;
		try {
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			String idImpot = curseur.getString("Id_Impot");
			DaoImpôt daoImpot = new DaoImpôt();
			Impôt impot = daoImpot.findById(idImpot);

			imposer = new Imposer(bien, impot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imposer;
	}

	/**
	 * Méthode qui trouve un imposer par son identifiant dans la base de données.
	 * 
	 * @param id Identifiant de l'imposer.
	 * @return L'imposer trouvé ou null s'il n'existe pas.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public Imposer findById(String... id) throws SQLException {
		List<Imposer> imposer = this.find(new RequeteSelectImposerById(), id);
		if (imposer.isEmpty()) {
			return null;
		}
		return imposer.get(0);
	}

	/**
	 * Méthode qui récupère tous les imposers de la base de données.
	 * 
	 * @return Une liste contenant tous les imposers.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public List<Imposer> findAll() throws SQLException {
		return this.find(new RequeteSelectImposer());
	}

	/**
	 * Méthode qui récupère les imposers associés à un bien spécifié.
	 * 
	 * @param id Identifiant du bien.
	 * @return Une liste d'imposers associés au bien.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public List<Imposer> findImposerByBien(String id) throws SQLException {
		return this.find(new RequeteSelectImposerByBien(), id);
	}

}
