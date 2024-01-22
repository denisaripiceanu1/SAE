package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

public class RequeteSelectImmeubleById implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "SELECT * FROM Immeuble WHERE Id_Immeuble = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble data) throws SQLException {
		prSt.setString(1, data.getImmeuble());
	}
}
