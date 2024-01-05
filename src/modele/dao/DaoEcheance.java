package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Echeance;
import modele.dao.requetes.delete.RequeteDeleteEcheance;
import modele.dao.requetes.select.RequeteSelectEcheance;
import modele.dao.requetes.select.RequeteSelectEcheanceByAssuranceNumPolice;
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
	public void delete(Echeance donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteEcheance(), donnees);

	}

	@Override
	protected Echeance creerInstance(ResultSet curseur) throws SQLException {
		Echeance echeance = null;
		try {
			// Récupérer l'identifiant de l'Assurance
			String numeroPolice = curseur.getString("numero_police");
			DaoAssurance daoAssurance = new DaoAssurance();
			Assurance a = daoAssurance.findById(numeroPolice);

			echeance = new Echeance(a, curseur.getString("date_echeance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return echeance;
	}

	@Override
	public Echeance findById(String... id) throws SQLException {
		List<Echeance> echeances = this.find(new RequeteSelectEcheanceById(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}

	public Echeance findByAssuranceNumPolice(String... id) throws SQLException {
		List<Echeance> echeances = this.find(new RequeteSelectEcheanceByAssuranceNumPolice(), id);
		if (echeances.isEmpty()) {
			return null;
		}
		return echeances.get(0);
	}
	
	public List<Echeance> findByAssuranceNumPoliceList(String idImmeuble) throws SQLException {
		return this.find(new RequeteSelectEcheanceByAssuranceNumPolice(), idImmeuble);
	}

	@Override
	public List<Echeance> findAll() throws SQLException {
		return this.find(new RequeteSelectEcheance());
	}

}
