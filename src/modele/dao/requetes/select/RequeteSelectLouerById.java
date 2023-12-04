package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerById implements Requete<Louer> {

	@Override
	public String requete() {
		return "SELECT * FROM Louer where Id_Locataire = ? and Id_Bien = ? and Date_Debut = ? ";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
		prSt.setString(3, id[2]);

	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		prSt.setString(1, data.getIdLocataire().toString());
		prSt.setString(2, data.getIdBien().toString());
		prSt.setString(3, data.getDateDebut().toString());
	}

}
