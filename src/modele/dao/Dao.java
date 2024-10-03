package modele.dao;

import java.sql.SQLException;
import java.util.List;

// Interface pour implementer le comportement DAO
public interface Dao<T> {

	public void create(T donnees) throws SQLException;
	
	public void update(T donnees) throws SQLException;

	public void delete(T donnees) throws SQLException;

	public T findById(String... id) throws SQLException;

	public List<T> findAll() throws SQLException;
}
