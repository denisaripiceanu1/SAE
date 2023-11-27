package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Requete<T> {
	public String requete();

	public void parametres(PreparedStatement prSt, String... id) throws SQLException;

	public void parametres(PreparedStatement prSt, T data) throws SQLException;
}