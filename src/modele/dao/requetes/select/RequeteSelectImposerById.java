package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.dao.requetes.Requete;

public class RequeteSelectImposerById implements Requete<Imposer>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Imposer WHERE Id_Bien = ? AND Id_Impot = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(0, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Imposer data) throws SQLException {
		prSt.setString(1, data.getBien().toString());
		prSt.setString(2, data.getImpot().toString());
	}

}
