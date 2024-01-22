package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Impôt;
import modele.dao.requetes.Requete;

public class RequeteSelectImpôtById implements Requete<Impôt> {

	@Override
	public String requete() {
		return "SELECT * FROM Impot WHERE Id_Impot = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Impôt data) throws SQLException {
		prSt.setInt(1, data.getIdImpot());
	}

}
