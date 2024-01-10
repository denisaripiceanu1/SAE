package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Impôt;
import modele.dao.requetes.select.RequeteSelectImpôt;
import modele.dao.requetes.select.RequeteSelectImpôtById;

public class DaoImpôt extends DaoModele<Impôt> implements Dao<Impôt> {

	@Override
	public void create(Impôt donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Impôt donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Impôt donnees) {
		delete(donnees);

	}

	@Override
	public Impôt findById(String... id) throws SQLException {
		List<Impôt> impots = find(new RequeteSelectImpôtById(), id);
		if (impots.isEmpty()) {
			return null;
		}
		return impots.get(0);
	}

	@Override
	public List<Impôt> findAll() throws SQLException {
		return find(new RequeteSelectImpôt());
	}

	@Override
	protected Impôt creerInstance(ResultSet curseur) throws SQLException {
		Impôt impôt = null;
		try {
			impôt = new Impôt(curseur.getInt("id_Impot"), curseur.getString("nom"), curseur.getDouble("montant"), curseur.getString("annee"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return impôt;
	}

}
