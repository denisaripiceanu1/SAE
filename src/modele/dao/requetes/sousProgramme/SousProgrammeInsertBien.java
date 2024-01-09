package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;

public class SousProgrammeInsertBien implements SousProgramme<Bien> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Bien(?,?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Bien donnee) throws SQLException {
		prSt.setString(1, donnee.getIdBien());
		prSt.setDouble(2, donnee.getSurfaceHabitable());
		prSt.setInt(3, donnee.getNbPieces());
		prSt.setInt(4, donnee.getNumEtage());
		prSt.setDate(5, java.sql.Date.valueOf(donnee.getDateAcquisition()));
		prSt.setString(6, donnee.getImmeuble().getImmeuble());
		prSt.setString(7, donnee.getType_bien());

	}

	@Override
	public void parametres(PreparedStatement prSt, Bien donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
