package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.requetes.Requete;

public class RequeteSelectAssuranceByLogement implements Requete<Assurance> {

	@Override
	public String requete() {
		return "SELECT * FROM ASSURANCE WHERE Id_Immeuble = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
		prSt.setString(1, data.getNuméroPolice());
	}

}