package modele.dao.requetes.sousProgramme.calculs;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.sousProgramme.SousProgramme;

public class SousProgrammeSoldeToutCompte implements SousProgramme<Louer> {
	
	@Override
	public String appelSousProgramme() {
	    return "{ ? = call calculerSoldeDeToutCompte(?,?,?) }";
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
	public void parametresCalcul(CallableStatement prSt, Louer donnee) throws SQLException {
		prSt.registerOutParameter(1, java.sql.Types.DOUBLE);
		prSt.setString(2, donnee.getBien().getIdBien());
		prSt.setString(3, donnee.getLocataire().getIdLocataire());
		prSt.setDate(4, java.sql.Date.valueOf(donnee.getDateDebut()));
	}


	@Override
	public void parametresSequence(CallableStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}


