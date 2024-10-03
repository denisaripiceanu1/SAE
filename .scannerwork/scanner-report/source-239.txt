package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectNbLocation implements Requete<Louer> {

	@Override
	public String requete() {
		return "Select count(*) FROM LOUER WHERE Id_locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		prSt.setString(1, data.getLocataire().getIdLocataire());
	}

}
