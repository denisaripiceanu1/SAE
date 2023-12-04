package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotite;
import modele.dao.requetes.Requete;

public class RequeteSelectQuotite implements Requete<Quotite> {

	@Override
	public String requete() {
		return "SELECT * FROM Quotite";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotite data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
