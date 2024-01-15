package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Quotite;

public class SousProgrammeInsertQuotite implements SousProgramme<Quotite> {

	@Override
	public String appelSousProgramme() {
		return "{ call Insert_Quotite(?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Quotite donnee) throws SQLException {
		prSt.setString(1, donnee.getType_quotite());
	}


	@Override
	public void parametresSequence(CallableStatement prSt, Quotite donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Quotite donnees) {
		// TODO Auto-generated method stub
		
	}
}