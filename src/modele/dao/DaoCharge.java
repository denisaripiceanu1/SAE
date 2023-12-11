package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Charge;
import modele.dao.requetes.select.RequeteSelectCharge;
import modele.dao.requetes.select.RequeteSelectChargeById;
import modele.dao.requetes.update.RequeteUpdateCharge;

public class DaoCharge extends DaoModele<Charge> implements Dao<Charge> {

	@Override
	public void create(Charge donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Charge donnees) throws SQLException {
		miseAJour(new RequeteUpdateCharge(), donnees);

	}

	@Override
	public void delete(Charge donnees) {
		delete(donnees);

	}

	@Override
	protected Charge creerInstance(ResultSet curseur) throws SQLException {
		Charge charge = null;
		try {
			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			charge = new Charge(curseur.getInt("Id_Charge"), curseur.getString("nom"),
					curseur.getDouble("montant_reel"), curseur.getDouble("montant_previsionnel"),
					curseur.getInt("deductible"), bien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charge;
	}

	@Override
	public Charge findById(String... id) throws SQLException {
		List<Charge> charges = find(new RequeteSelectChargeById(), id);
		if (charges.isEmpty()) {
			return null;
		}
		return charges.get(0);
	}

	@Override
	public List<Charge> findAll() throws SQLException {
		return find(new RequeteSelectCharge());
	}

}