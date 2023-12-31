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

	@Override
	public void create(ICC donnees) throws SQLException {
		SousProgramme<ICC> sp = new SousProgrammeInsertICC();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(ICC donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ICC donnees) {
		delete(donnees);

	}

	@Override
	public ICC findById(String... id) throws SQLException {
		List<ICC> iccs = find(new RequeteSelectICCById(), id);
		if (iccs.isEmpty()) {
			return null;
		}
		return iccs.get(0);
	}

	@Override
	public List<ICC> findAll() throws SQLException {
		return find(new RequeteSelectICC());
	}

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
