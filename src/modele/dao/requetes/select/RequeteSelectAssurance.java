package modele.dao.requetes.select;

import modele.Assurance;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectAssurance implements Requete<Assurance> {

	@Override
	public String requete() {
		return "SELECT * FROM ASSURANCE";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
	}
}
