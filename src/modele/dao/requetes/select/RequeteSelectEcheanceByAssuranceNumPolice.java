package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheanceByAssuranceNumPolice implements Requete<Echeance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance WHERE NUMERO_POLICE = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {

	}

}
