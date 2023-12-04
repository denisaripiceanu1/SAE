package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

public class RequeteSelectQuotter implements Requete<Quotter>{

	@Override
	public String requete() {
		return "SELECT * FROM Quotter";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
