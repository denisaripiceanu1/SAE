package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class RequeteSelectLocataireById implements Requete<Locataire> {

	@Override
	public String requete() {
		return "SELECT * FROM Locataire WHERE Id_Locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);

	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getIdLocataire());

	}

}