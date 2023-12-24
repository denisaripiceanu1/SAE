package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteDeleteEcheance implements Requete<Echeance> {

	@Override
	public String requete() {
		return "DELETE FROM ECHEANCE WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE = ? ";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
		prSt.setString(1, donnee.getAssurance().getNuméroPolice());
		prSt.setDate(2, Date.valueOf(donnee.getDateEcheance().substring(0, 10))); // Pour enlever l'heure de la date et éviter les bug de format de type "YYYY-DD-MM HH:MM" on garde que les 10 premiers pour enlever "HH:MM"
	}

}
