package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectMoyenneLoyer implements Requete<Louer> {

	@Override
	public String requete() {
		return "SELECT Id_Locataire, AVG(loyer_TTC) AS Moyenne_Loyer FROM Louer GROUP BY Id_Locataire\r\n";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		// TODO Auto-generated method stub

	}

}
