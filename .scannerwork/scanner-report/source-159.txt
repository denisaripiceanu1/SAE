package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.ICC;
import modele.dao.requetes.select.RequeteSelectICC;
import modele.dao.requetes.select.RequeteSelectICCById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertICC;

public class DaoICC extends DaoModele<ICC> implements Dao<ICC> {

	/**
	 * Méthode qui insère un ICC dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees ICC à insérer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void create(ICC donnees) throws SQLException {
		SousProgramme<ICC> sp = new SousProgrammeInsertICC();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode non implémentée pour la mise à jour d'un ICC.
	 * 
	 * @param donnees ICC à mettre à jour.
	 */
	@Override
	public void update(ICC donnees) {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui supprime un ICC de la base de données en utilisant la méthode de la classe mère.
	 * 
	 * @param donnees ICC à supprimer.
	 */
	@Override
	public void delete(ICC donnees) {
		this.delete(donnees);
	}

	/**
	 * Méthode qui trouve un ICC par son identifiant dans la base de données.
	 * 
	 * @param id Identifiant de l'ICC.
	 * @return L'ICC trouvé ou null s'il n'existe pas.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public ICC findById(String... id) throws SQLException {
		List<ICC> iccs = this.find(new RequeteSelectICCById(), id);
		if (iccs.isEmpty()) {
			return null;
		}
		return iccs.get(0);
	}

	/**
	 * Méthode qui récupère tous les ICC de la base de données.
	 * 
	 * @return Une liste contenant tous les ICC.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public List<ICC> findAll() throws SQLException {
		return this.find(new RequeteSelectICC());
	}

	/**
	 * Méthode qui crée une instance d'ICC à partir d'un curseur de résultat SQL.
	 * 
	 * @param curseur Résultat SQL contenant les données de l'ICC.
	 * @return Une instance d'ICC.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	@Override
	protected ICC creerInstance(ResultSet curseur) throws SQLException {
		ICC icc = null;
		try {
			icc = new ICC(curseur.getString("annee"), curseur.getString("trimestre"), curseur.getDouble("indice"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return icc;
	}

}
