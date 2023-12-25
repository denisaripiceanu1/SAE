package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.dao.requetes.Requete;

public class RequeteSelectDiagnoticByBien implements Requete<Diagnostics>{

	@Override
	public String requete() {
		return "SELECT * FROM Diagnostic WHERE Id_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Diagnostics data) throws SQLException {
		prSt.setString(1, data.getBien().getImmeuble().getImmeuble());
	}

}
