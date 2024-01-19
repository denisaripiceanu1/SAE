package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheance implements Requete<Echeance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {
		// TODO Auto-generated method stub
	}
	
}
