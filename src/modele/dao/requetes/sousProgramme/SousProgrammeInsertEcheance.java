package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Echeance;

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

}