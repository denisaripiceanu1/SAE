package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

public class RequeteSelectQuotterByBien implements Requete<Quotter>{

	@Override
	public String requete() {
		return "SELECT * FROM Quotter WHERE Id_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter data) throws SQLException {
		prSt.setString(1, data.getBien().getImmeuble().getImmeuble());
	}

}
