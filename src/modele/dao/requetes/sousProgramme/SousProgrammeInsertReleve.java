package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Releve;

public class SousProgrammeInsertReleve implements SousProgramme<Releve> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Relevé(?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Releve donnee) throws SQLException {
		prSt.setString(1, donnee.getCompteur().getIdCompteur());
		prSt.setDate(2, Date.valueOf(donnee.getDate_releve()));
		prSt.setDouble(3, donnee.getIndexComp());

	}


	@Override
	public void parametresSequence(CallableStatement prSt, Releve donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Releve donnees) {
		// TODO Auto-generated method stub
		
	}
}
