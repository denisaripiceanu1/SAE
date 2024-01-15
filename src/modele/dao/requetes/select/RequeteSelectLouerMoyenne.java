package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.MoyenneMediane;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerMoyenne implements Requete<MoyenneMediane> {

	@Override
	public String requete() {
		return "SELECT AVG(loyer_TTC) AS MoyenneLoyer FROM Louer";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, MoyenneMediane data) throws SQLException {
		// TODO Auto-generated method stub

	}

}
