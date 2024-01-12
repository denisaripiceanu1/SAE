package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.Louer;

public class SousProgrammeInsertImmeuble implements SousProgramme<Immeuble> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Immeuble(?, ?, ?, ?, ?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble donnee) throws SQLException {
	    prSt.setString(1, donnee.getImmeuble());
	    prSt.setString(2, donnee.getAdresse());
	    prSt.setString(3, donnee.getCp());
	    prSt.setString(4, donnee.getVille());
	    prSt.setString(5, donnee.getPeriodeConstruction());
	    prSt.setString(6, donnee.getType_immeuble());
	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub
		
	}


}
