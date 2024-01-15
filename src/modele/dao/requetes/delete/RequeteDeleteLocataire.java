package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class RequeteDeleteLocataire implements Requete<Locataire> {

	@Override
	public String requete() {
		return "DELETE FROM LOCATAIRE WHERE Id_Locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getIdLocataire());
	}

}
