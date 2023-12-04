package modele.dao.requetes.select;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Imposer;
import modele.dao.requetes.Requete;

public class RequeteSelectImposer implements Requete<Imposer> {

	@Override
	public String requete() {
		return "SELECT * FROM Imposer";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Imposer data) throws SQLException {
	}

}
