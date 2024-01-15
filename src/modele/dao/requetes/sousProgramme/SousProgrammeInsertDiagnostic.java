
package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Compteur;
import modele.Diagnostics;
import modele.Louer;

public class SousProgrammeInsertDiagnostic implements SousProgramme<Diagnostics> {
	
	@Override
	public String appelSousProgramme() {
		return "{call Insert_Diagnostic(?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

	
	public void parametresSequence(CallableStatement prSt, Diagnostics donnee) throws SQLException {
		prSt.setDate(1, java.sql.Date.valueOf(donnee.getDateValidite()));
		prSt.setString(2, donnee.getTypeDiagnostic());
		prSt.setString(3, donnee.getBien().getIdBien());
		prSt.registerOutParameter(4, java.sql.Types.INTEGER);
	}

	@Override
	public void parametresCalcul(CallableStatement st, Diagnostics donnees) {
		// TODO Auto-generated method stub
		
	}

}


