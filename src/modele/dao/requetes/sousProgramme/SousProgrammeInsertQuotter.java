package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Quotter;

public class SousProgrammeInsertQuotter implements SousProgramme<Quotter> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Quotter(?, ?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
		prSt.setString(1, donnee.getBien().getIdBien());
		prSt.setString(2, donnee.getTypeQuotite().getType_quotite());
		prSt.setDouble(3, donnee.getPourcentage());
	}

	@Override
	public void parametresSequence(CallableStatement prSt, Quotter donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Quotter donnees) {
		// TODO Auto-generated method stub
		
	}
}