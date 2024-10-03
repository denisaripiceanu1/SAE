package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.ICC;
import modele.dao.requetes.Requete;

public class RequeteSelectICCById implements Requete<ICC> {

	@Override
	public String requete() {
		return "SELECT * FROM ICC WHERE annee = ? and trimestre = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);

	}

	@Override
	public void parametres(PreparedStatement prSt, ICC data) throws SQLException {
		prSt.setString(1, data.getAnnee());
		prSt.setString(2, data.getTrimestre());

	}

}
