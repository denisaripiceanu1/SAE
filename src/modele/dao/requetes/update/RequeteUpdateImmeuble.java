package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

public class RequeteUpdateImmeuble implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "UPDATE Immeuble SET adresse = ?, cp = ?, ville = ?, periode_construction = ?, type_immeuble = ?"
				+ "WHERE Id_Immeuble = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble data) throws SQLException {
		prSt.setString(1, data.getAdresse());
		prSt.setString(2, data.getCp());
		prSt.setString(3, data.getVille());
		prSt.setString(4, data.getPeriodeConstruction());
		prSt.setString(5, data.getType_immeuble());
		prSt.setString(6, data.getImmeuble()); // cle primaire
	}

}
