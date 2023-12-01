package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.Releve;
import modele.dao.requetes.Requete;

public class RequeteSelectReleveById  implements Requete<Releve>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Releve WHERE Id_Compteur = ? AND date_relevé = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(0, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Releve data) throws SQLException {
		prSt.setString(1, data.getCompteur().toString());
		prSt.setString(2, data.getDate_releve());
	}

}
