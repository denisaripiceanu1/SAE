package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotite;
import modele.dao.SousProgramme;

public class SousProgrammeInsertQuotite implements SousProgramme<Quotite> {

	@Override
	public String appelSousProgramme() {
		return "{ call Insert_Quotite(?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Quotite donnee) throws SQLException {
		prSt.setString(1, donnee.getType_quotite());
		prSt.setDouble(2, donnee.getPourcentage().getPourcentage());
	}
}