package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Quotter;
import modele.Échéance;

public class DaoQuotter extends DaoModele<Quotter> implements Dao<Quotter> {

	@Override
	public void create(Quotter donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Quotter donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Quotter donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Quotter creerInstance(ResultSet curseur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quotter findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quotter> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
