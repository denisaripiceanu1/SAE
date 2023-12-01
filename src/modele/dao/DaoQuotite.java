package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Quotite;
import modele.dao.requetes.select.RequeteSelectQuotite;
import modele.dao.requetes.select.RequeteSelectQuotiteById;

public class DaoQuotite extends DaoModele<Quotite> implements Dao<Quotite>{

	@Override
	public void create(Quotite donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Quotite donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Quotite donnees) {
		delete(donnees);
		
	}

	@Override
	public Quotite findById(String... id) throws SQLException{
		List<Quotite> quotites = find(new RequeteSelectQuotiteById(), id);
		if (quotites.isEmpty()) {
			return null;
		}
		return quotites.get(0);
	}

	@Override
	public List<Quotite> findAll() throws SQLException{
		return find(new RequeteSelectQuotite());
	}

	@Override
	protected Quotite creerInstance(ResultSet curseur) throws SQLException {
		Quotite quotite = null;
		try {
			quotite = new Quotite(curseur.getString("type_quotite"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotite;
	}
    
}
