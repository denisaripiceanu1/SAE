
package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Diagnostics;

public class SousProgrammeInsertDiagnostic implements SousProgramme<Diagnostics> {
	
	@Override
	public String appelSousProgramme() {
		return "{call Insert_Diagnostic(?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

	
	public void parametres(PreparedStatement prSt, Diagnostics donnee, int Sequence) throws SQLException {
		prSt.setDate(1, java.sql.Date.valueOf(donnee.getDateValidite()));
		prSt.setString(2, donnee.getTypeDiagnostic());
		prSt.setString(3, donnee.getBien().getIdBien());
	}

}


