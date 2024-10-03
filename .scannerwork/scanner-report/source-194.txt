package modele.dao.requetes.select;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Compteur;
import modele.dao.requetes.Requete;

public class RequeteSelectCompteur implements Requete<Compteur> {

	@Override
	public String requete() {
		return "SELECT * FROM Compteur";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Compteur data) throws SQLException {
		// TODO Auto-generated method stub
	}
}
