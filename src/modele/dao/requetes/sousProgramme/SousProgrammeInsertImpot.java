package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Impôt;
import modele.Louer;

public class SousProgrammeInsertImpot implements SousProgramme<Impôt> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Impot(?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Impôt donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametresSequence(CallableStatement prSt, Impôt donnee) throws SQLException {
		prSt.setString(1, donnee.getNom());
		prSt.setDouble(2, donnee.getMontant());
		prSt.setString(3, donnee.getAnnee());
		prSt.registerOutParameter(4, java.sql.Types.INTEGER);
	}

	@Override
	public void parametresCalcul(CallableStatement st, Impôt donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}