package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotite;
import modele.dao.requetes.Requete;

public class RequeteSelectQuotiteById implements Requete<Quotite>{

	@Override
	public String requete() {
		return "SELECT * FROM Quotite WHERE type_quotite = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotite data) throws SQLException {
		prSt.setString(1, data.getType_quotite());
		
	}

}
