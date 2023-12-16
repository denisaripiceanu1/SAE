
package modele.dao.requetes.select;

import modele.Charge;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectChargeById implements Requete<Charge> {

	@Override
	public String requete() {
        return "SELECT * FROM Charge WHERE nom = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Charge data) throws SQLException {
		//prSt.setLong(1, data.getIdCharge()); L'ID est auto incrementé dans la BDD
	}

}