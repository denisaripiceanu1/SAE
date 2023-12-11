package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Compteur;
import modele.dao.SousProgramme;

public class sousProgrammeAjoutCompteur implements SousProgramme<Compteur>{

	@Override
	public String appelSousProgramme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
