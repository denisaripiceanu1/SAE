package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;

public class SousProgrammeInsertQuotter implements SousProgramme<Quotter> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Quotter(?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
		prSt.setString(1, donnee.getTypeQuotite().getType_quotite());
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}