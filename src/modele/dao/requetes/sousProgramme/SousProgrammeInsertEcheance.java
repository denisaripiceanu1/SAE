package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Echeance;
import modele.Louer;

public class SousProgrammeInsertEcheance implements SousProgramme<Echeance> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Echeance(?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
		prSt.setString(1, donnee.getAssurance().getNuméroPolice());
		prSt.setDate(2, java.sql.Date.valueOf(donnee.getDateEcheance()));

	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub
		
	}

}