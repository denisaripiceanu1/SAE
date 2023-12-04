package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Impôt;
import modele.dao.requetes.Requete;

public class RequeteSelectImpôt implements Requete<Impôt> {

	@Override
	public String requete() {
		return "SELECT * FROM Impot";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Impôt data) throws SQLException {
	}

}
