package modele.dao.requetes.select;

import modele.Echeance;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEcheanceById implements Requete<Echeance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance WHERE numero_police = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {
		prSt.setString(1, data.getAssurance().getNuméroPolice());
	}

}