package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class RequeteSelectLocataire implements Requete<Locataire> {

	@Override
	public String requete() {
		return "SELECT * FROM Locataire";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		// TODO Auto-generated method stub
	}

}
