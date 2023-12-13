package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Quotite;
import modele.Quotter;
import modele.dao.requetes.select.RequeteSelectQuotite;
import modele.dao.requetes.select.RequeteSelectQuotiteById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertQuotite;

public class DaoQuotite extends DaoModele<Quotite> implements Dao<Quotite> {

	@Override
	public void create(Quotite donnees) throws SQLException {
		SousProgramme<Quotite> sp = new SousProgrammeInsertQuotite();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Quotite donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Quotite donnees) {
		this.delete(donnees);

	}

	@Override
	public Quotite findById(String... id) throws SQLException {
		List<Quotite> quotites = this.find(new RequeteSelectQuotiteById(), id);
		if (quotites.isEmpty()) {
			return null;
		}
		return quotites.get(0);
	}

	@Override
	public List<Quotite> findAll() throws SQLException {
		return this.find(new RequeteSelectQuotite());
	}

	@Override
	protected Quotite creerInstance(ResultSet curseur) throws SQLException {
		Quotite quotite = null;
		try {

			Double pourcentage_q = curseur.getDouble("pourcentage");
			String pourcentage_q_Str = pourcentage_q.toString();
			DaoQuotter daoQuotter = new DaoQuotter();
			Quotter pourcentage = daoQuotter.findById(pourcentage_q_Str);

			quotite = new Quotite(curseur.getString("type_quotite"), pourcentage);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotite;
	}

}
