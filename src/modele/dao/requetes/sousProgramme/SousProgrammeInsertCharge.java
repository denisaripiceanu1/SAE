package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Charge;
import modele.dao.SousProgramme;

public class SousProgrammeInsertCharge implements SousProgramme<Charge> {

	@Override
	public String appelSousProgramme() {
		return "{call Insert_Charge(?, ?, ?, ?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Charge donnee) throws SQLException {
		prSt.setString(1, donnee.getNom());
		prSt.setDouble(2, donnee.getMontantReel());
		prSt.setDouble(3, donnee.getMontantPrevisionnel());
		prSt.setInt(4, donnee.isDeductible());
		prSt.setString(5, donnee.getBien().getIdBien());
	}

}