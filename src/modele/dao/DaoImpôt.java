package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Impôt;
import modele.dao.requetes.select.RequeteSelectImpôt;
import modele.dao.requetes.select.RequeteSelectImpôtById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertImpot;

public class DaoImpôt extends DaoModele<Impôt> implements Dao<Impôt> {

	/**
	 * Méthode qui insère un impôt dans la base de données en utilisant un sous-programme.
	 * 
	 * @param donnees Impôt à insérer.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public void create(Impôt donnees) throws SQLException {
		SousProgramme<Impôt> sp = new SousProgrammeInsertImpot();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui crée un impôt dans la base de données et récupère son ID généré par une séquence.
	 * 
	 * @param donnees Impôt à insérer.
	 * @return L'ID généré pour l'impôt inséré.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	public int createAvecSequence(Impôt donnees) throws SQLException {
	    SousProgramme<Impôt> sp = new SousProgrammeInsertImpot();
	    CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
	    sp.parametresSequence(st, donnees);
	    int idImpot = -1; // Initialiser à une valeur qui ne peut pas être valide
	    st.executeUpdate();
	    idImpot = st.getInt(4);  // Récupérer la valeur de l'ID généré, 4ème paramètre dans le sous-programme 
	    st.close();
	    return idImpot;
	}

	/**
	 * Méthode qui met à jour un impôt dans la base de données (non implémentée dans cette classe).
	 * 
	 * @param donnees Impôt à mettre à jour.
	 */
	@Override
	public void update(Impôt donnees) {
		// TODO Auto-generated method stub
	}

	/**
	 * Méthode qui supprime un impôt de la base de données en utilisant la méthode de la classe mère.
	 * 
	 * @param donnees Impôt à supprimer.
	 */
	@Override
	public void delete(Impôt donnees) {
		this.delete(donnees);
	}

	/**
	 * Méthode qui trouve un impôt par son identifiant dans la base de données.
	 * 
	 * @param id Identifiant de l'impôt.
	 * @return L'impôt trouvé ou null s'il n'existe pas.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public Impôt findById(String... id) throws SQLException {
		List<Impôt> impots = this.find(new RequeteSelectImpôtById(), id);
		if (impots.isEmpty()) {
			return null;
		}
		return impots.get(0);
	}

	/**
	 * Méthode qui récupère tous les impôts de la base de données.
	 * 
	 * @return Une liste contenant tous les impôts.
	 * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
	 */
	@Override
	public List<Impôt> findAll() throws SQLException {
		return this.find(new RequeteSelectImpôt());
	}

	/**
	 * Méthode qui crée une instance d'Impôt à partir d'un curseur de résultat SQL.
	 * 
	 * @param curseur Résultat SQL contenant les données de l'Impôt.
	 * @return Une instance d'Impôt.
	 * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
	 */
	@Override
	protected Impôt creerInstance(ResultSet curseur) throws SQLException {
		Impôt impôt = null;
		try {
			impôt = new Impôt(curseur.getString("nom"), curseur.getDouble("montant"), curseur.getString("annee"));
			impôt.setIdImpot(curseur.getInt("Id_Impot"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return impôt;
	}

}
