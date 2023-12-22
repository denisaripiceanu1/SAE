package modele.dao.requetes.select;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheanceById implements Requete<Echeance> {

	@Override
	public String requete() {
		return "SELECT * FROM Echeance WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setDate(2, Date.valueOf(id[1]));
		// le format n'est pas le bon car il y a l'heure d'affichée
	}

	@Override
	public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {

	}

}