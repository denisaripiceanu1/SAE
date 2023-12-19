package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;

public class SousProgrammeInsertLouer implements SousProgramme<Louer> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Louer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub

	}

}
