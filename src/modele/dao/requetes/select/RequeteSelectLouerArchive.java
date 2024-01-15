package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerArchive implements Requete<Louer> {

	@Override
	public String requete() {
		return "SELECT * FROM Archivage_Louer";
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
