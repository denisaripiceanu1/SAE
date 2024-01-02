package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.dao.requetes.Requete;

public class RequeteSelectImposerByBien implements Requete<Imposer> {

	@Override
	public String requete() {
		return "SELECT * FROM Imposer WHERE Id_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Imposer data) throws SQLException {
		prSt.setString(1, data.getBien().getIdBien());
	}

}
