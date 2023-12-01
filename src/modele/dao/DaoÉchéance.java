package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Échéance;
import modele.dao.requetes.select.RequeteSelectEcheance;
import modele.dao.requetes.select.RequeteSelectEcheanceById;

public class DaoÉchéance extends DaoModele<Échéance> implements Dao<Échéance> {

	@Override
	public void create(Échéance donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Échéance donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Échéance donnees) {
		delete(donnees);

	}

	@Override
	protected Échéance creerInstance(ResultSet curseur) throws SQLException {
		Échéance echeance = null;
		try {

			echeance = new Échéance(curseur.getString("numero_police"), curseur.getString("dateEcheance"),
					curseur.getDouble("montantEcheance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return echeance;
	}

	@Override
	public Échéance findById(String... id) throws SQLException {
		List<Échéance> echeances = find(new RequeteSelectEcheanceById(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}

	@Override
	public List<Échéance> findAll() throws SQLException {
		return find(new RequeteSelectEcheance());
	}

}
