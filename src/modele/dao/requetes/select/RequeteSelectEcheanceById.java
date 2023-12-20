package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheanceById implements Requete<Echeance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE  ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {

	}

}