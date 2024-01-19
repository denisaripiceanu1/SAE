package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

public class RequeteSelectBien implements Requete<Bien> {

	@Override
	public String requete() {
		return "SELECT * FROM Bien ORDER BY Id_Bien";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Bien data) throws SQLException {
		// TODO Auto-generated method stub	
	}
}
