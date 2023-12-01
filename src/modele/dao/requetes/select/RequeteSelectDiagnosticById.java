package modele.dao.requetes.select;

import modele.Diagnostic;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectDiagnosticById implements Requete<Diagnostic> {

	@Override
	public String requete() {
		return "SELECT * FROM Diagnostic WHERE Id_Diagnostic = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Diagnostic data) throws SQLException {
		prSt.setInt(1, data.getIdDiagnostic());
	}

}