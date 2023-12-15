package modele.dao.requetes.select;

import modele.Compteur;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCompteurParImmeuble implements Requete<Compteur> {
	
	@Override
	public String requete() {
		return "SELECT * FROM Compteur WHERE Id_immeuble  = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Compteur data) throws SQLException {
		prSt.setString(1, data.getImmeuble().getImmeuble());
	}

}