package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteDeleteEcheance implements Requete<Echeance> {

	@Override
	public String requete() {
		return "DELETE FROM ECHEANCE WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE  ? ";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
		prSt.setString(1, donnee.getAssurance().getNuméroPolice());
		prSt.setString(2, donnee.getDateEcheance());
	}

}
