package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Charge;
import modele.dao.requetes.Requete;

public class RequeteUpdateCharge implements Requete<Charge> {

	@Override
	public String requete() {
		// PROBLEME
		return "UPDATE Charge SET nom = ?, montant_reel = ?, montant_previsionnel = ?, deductible = ? WHERE Id_Charge = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Charge data) throws SQLException {
		prSt.setString(1, data.getNom());
		prSt.setDouble(2, data.getMontantReel());
		prSt.setDouble(3, data.getMontantPrevisionnel());
		prSt.setInt(4, data.isDeductible());
		prSt.setInt(5, data.getIdCharge());

	}

}
