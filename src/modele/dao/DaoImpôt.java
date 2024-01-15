package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modele.Impôt;
import modele.dao.requetes.select.RequeteSelectImpôt;
import modele.dao.requetes.select.RequeteSelectImpôtById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertImpot;

public class DaoImpôt extends DaoModele<Impôt> implements Dao<Impôt> {

	@Override
	public void create(Impôt donnees) throws SQLException {
		SousProgramme<Impôt> sp = new SousProgrammeInsertImpot();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	// Méthode qui créer l'objet puis récupère son ID depuis la BD juste après la
	// création lorsque c'est une séquence
	public int createAvecSequence(Impôt donnees) throws SQLException {
	    SousProgramme<Impôt> sp = new SousProgrammeInsertImpot();
	    CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
	    sp.parametresSequence(st, donnees);
	    int idImpot = -1; // Initialiser à une valeur qui ne peut pas être valide
	    st.executeUpdate();
	    idImpot = st.getInt(4);  // Récupérer la valeur de l'ID généré, 4 ème parametre dans le sous programme 
	    st.close();
	    return idImpot;
	}


	@Override
	public void update(Impôt donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Impôt donnees) {
		this.delete(donnees);

	}

	@Override
	public Impôt findById(String... id) throws SQLException {
		List<Impôt> impots = this.find(new RequeteSelectImpôtById(), id);
		if (impots.isEmpty()) {
			return null;
		}
		return impots.get(0);
	}

	@Override
	public List<Impôt> findAll() throws SQLException {
		return this.find(new RequeteSelectImpôt());
	}

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
