package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Echeance;
import modele.dao.requetes.select.RequeteSelectEcheance;
import modele.dao.requetes.select.RequeteSelectEcheanceById;

public class DaoEcheance extends DaoModele<Echeance> implements Dao<Echeance> {

	@Override
	public void create(Echeance donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Echeance donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Echeance donnees) {
		delete(donnees);

	}

	@Override
	protected Echeance creerInstance(ResultSet curseur) throws SQLException {
		Echeance echeance = null;
		try {

			echeance = new Echeance(curseur.getString("numero_police"), curseur.getString("date_echeance"),
					curseur.getDouble("montant_echeance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return echeance;
	}

	@Override
	public Echeance findById(String... id) throws SQLException {
		List<Echeance> echeances = find(new RequeteSelectEcheanceById(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}

	@Override
	public List<Echeance> findAll() throws SQLException {
		return find(new RequeteSelectEcheance());
	}

}
