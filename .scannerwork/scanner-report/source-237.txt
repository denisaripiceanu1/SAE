package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerProvision implements Requete<Louer> {

	@Override
	public String requete() {
		return "SELECT annee, SUM(provision_chargeMens_TTC) FROM Louer GROUP BY annee";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO document why this method is empty
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		// TODO Auto-generated method stub

	}

}
