package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.Releve;
import modele.dao.requetes.Requete;

public class RequeteSelectReleve implements Requete<Releve> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Releve";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Releve data) throws SQLException {
	}


}
