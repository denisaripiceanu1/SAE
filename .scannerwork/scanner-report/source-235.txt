package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.MoyenneMediane;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerMediane implements Requete<MoyenneMediane> {

	@Override
	public String requete() {
		return "SELECT AVG(loyer_TTC) AS MedianeLoyer,\r\n"
				+ "       PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY loyer_TTC) AS MedianLoyer\r\n" + "FROM Louer";
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
