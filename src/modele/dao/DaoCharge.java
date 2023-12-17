package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Bien;
import modele.Charge;
import modele.dao.requetes.select.RequeteSelectAssuranceByLogement;
import modele.dao.requetes.select.RequeteSelectCharge;
import modele.dao.requetes.select.RequeteSelectChargeAll;
import modele.dao.requetes.select.RequeteSelectChargeById;
import modele.dao.requetes.select.RequeteSelectChargeByLogement;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertCharge;
import modele.dao.requetes.update.RequeteUpdateCharge;

public class DaoCharge extends DaoModele<Charge> implements Dao<Charge> {

	@Override
	public void create(Charge donnees) throws SQLException {
		SousProgramme<Charge> sp = new SousProgrammeInsertCharge();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Charge donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateCharge(), donnees);

	}

	@Override
	public void delete(Charge donnees) {
		this.delete(donnees);

	}

	@Override
	protected Charge creerInstance(ResultSet curseur) throws SQLException {
		Charge charge = null;
		try {
			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			charge = new Charge( curseur.getString("nom"), curseur.getDouble("montant_reel"),
					curseur.getDouble("montant_previsionnel"), curseur.getInt("deductible"), bien);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return charge;
	}

	@Override
	public Charge findById(String... id) throws SQLException {
		List<Charge> charges = this.find(new RequeteSelectChargeById(), id);
		if (charges.isEmpty()) {
			return null;
		}
		return charges.get(0);
	}

	@Override
	public List<Charge> findAll() throws SQLException {
		return this.find(new RequeteSelectCharge());
	}

	// ---------------- AUTRES METHODES ----------------//

	public List<Charge> findByLogement(String idImmeuble) throws SQLException {
		return this.find(new RequeteSelectChargeByLogement(), idImmeuble);
	}
	
	public Charge findByAll(String... id) throws SQLException {
		List<Charge> charges = this.find(new RequeteSelectChargeAll(), id);
		if (charges.isEmpty()) {
			return null;
		}
		return charges.get(0);
	}
}