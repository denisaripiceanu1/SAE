package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ICC;
import modele.dao.requetes.Requete;

public class RequeteSelectICC implements Requete<ICC>{

	@Override
	public String requete() {
		return "SELECT * FROM ICC";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, ICC data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
