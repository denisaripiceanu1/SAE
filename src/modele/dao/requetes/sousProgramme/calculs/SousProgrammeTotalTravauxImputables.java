package modele.dao.requetes.sousProgramme.calculs;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.sousProgramme.SousProgramme;

public class SousProgrammeTotalTravauxImputables implements SousProgramme<Louer> {
	
	@Override
	public String appelSousProgramme() {
	    return "{ ? = call totalTravauxImputableLocataire(?) }";
	}


	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub	}
	}
	
	@Override
	public void parametres(PreparedStatement prSt, Louer donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void parametresCalcul(CallableStatement prSt, Louer donnee) throws SQLException {
		prSt.registerOutParameter(1, java.sql.Types.DOUBLE);
		prSt.setString(2, donnee.getLocataire().getIdLocataire());
	}

}


