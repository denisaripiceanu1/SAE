package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

public class RequeteSelectQuotterById implements Requete<Quotter> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Quotter WHERE Id_Bien = ? AND Type_quotite = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter data) throws SQLException {
		prSt.setString(1, data.getBien().toString());
		prSt.setString(2, data.getTypeQuotite().toString());

	}

}
