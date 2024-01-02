package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Releve;
import modele.dao.requetes.Requete;

public class RequeteDeleteReleve implements Requete<Releve> {

	@Override
	public String requete() {
		return "DELETE FROM Relevé WHERE ID_Compteur = ? AND date_relevé = ? AND indexComp = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Releve donnee) throws SQLException {
		prSt.setString(1, donnee.getCompteur().getIdCompteur());
		prSt.setDate(2, Date.valueOf(donnee.getDate_releve().substring(0, 10)));
		prSt.setDouble(3, donnee.getIndexComp());// cle primaire
	}

}
