package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ICC;
import modele.Louer;

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


	@Override
	public void parametresSequence(CallableStatement prSt, ICC donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, ICC donnees) {
		// TODO Auto-generated method stub
		
	}
}
