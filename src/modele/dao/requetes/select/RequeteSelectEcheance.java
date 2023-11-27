package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Échéance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheance implements Requete<Échéance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Échéance data) throws SQLException {
	}
}
