package modele.dao.requetes.select;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Diagnostics;
import modele.dao.requetes.Requete;

public class RequeteSelectDiagnostic implements Requete<Diagnostics> {

	@Override
	public String requete() {
		return "SELECT * FROM Diagnostic";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Diagnostics data) throws SQLException {
		// TODO Auto-generated method stub
	}
}
