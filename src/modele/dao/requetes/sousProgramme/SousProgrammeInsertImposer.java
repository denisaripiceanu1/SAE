package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.Louer;

public class SousProgrammeInsertImposer implements SousProgramme<Imposer> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Imposer(?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Imposer donnee) throws SQLException {
		prSt.setString(1, donnee.getBien().getIdBien());
		prSt.setDouble(2, donnee.getImpot().getIdImpot());

	}

	@Override
	public void parametresSequence(CallableStatement prSt, Imposer donnee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametresCalcul(CallableStatement st, Imposer donnees) {
		// TODO Auto-generated method stub

	}

}