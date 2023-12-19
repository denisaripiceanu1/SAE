package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;

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


}
