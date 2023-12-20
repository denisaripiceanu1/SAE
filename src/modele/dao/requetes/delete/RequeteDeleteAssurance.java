package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.requetes.Requete;

public class RequeteDeleteAssurance implements Requete<Assurance> {

	@Override
	public String requete() {
		return "DELETE FROM ASSURANCE WHERE NUMERO_POLICE = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance donnee) throws SQLException {
		prSt.setString(1, donnee.getNuméroPolice()); // cle primaire
	}

}
