package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Releve;
import modele.dao.requetes.Requete;

public class RequeteSelectReleveByCompteur implements Requete<Releve> {

	@Override
	public String requete() {
		return "SELECT * FROM Relevé WHERE Id_Compteur = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Releve data) throws SQLException {
		prSt.setString(1, data.getCompteur().getIdCompteur());
	}

}
