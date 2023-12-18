package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class SousProgrammeInsertAssurance implements SousProgramme<Assurance> {

	@Override
	public String appelSousProgramme() {
		return "{call Insert_Assurance(?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance donnee) throws SQLException {
		prSt.setString(1, donnee.getNuméroPolice());
		prSt.setFloat(2, donnee.getMontantInit());
		prSt.setString(3, donnee.getBien().getIdBien());
		prSt.setString(4, donnee.getEntreprise().getSiret());
	}

}