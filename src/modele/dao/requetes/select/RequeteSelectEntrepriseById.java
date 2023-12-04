package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;
import modele.dao.requetes.Requete;

public class RequeteSelectEntrepriseById implements Requete<Entreprise> {

	@Override
	public String requete() {
		return "SELECT * FROM Entreprise WHERE SIRET = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);

	}

	@Override
	public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {
		prSt.setString(1, data.getSiret());

	}

}
