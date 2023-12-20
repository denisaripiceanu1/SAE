package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ICC;

public class SousProgrammeInsertICC implements SousProgramme<ICC> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_ICC(?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, ICC donnee) throws SQLException {
		prSt.setString(1, donnee.getAnnee());
		prSt.setString(2, donnee.getTrimestre());
		prSt.setDouble(3, donnee.getIndice());

	}
}
