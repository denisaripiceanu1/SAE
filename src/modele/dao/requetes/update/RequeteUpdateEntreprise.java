package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;
import modele.Immeuble;
import modele.dao.requetes.Requete;

public class RequeteUpdateEntreprise implements Requete<Entreprise> {

	@Override
	public String requete() {
		return "UPDATE Entreprise SET nom = ?, adresse = ?, cp = ?, ville = ?, mail = ?, telephone = ?, IBAN = ?"
				+ "WHERE SIRET = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {
		prSt.setString(1, data.getNom());
		prSt.setString(2, data.getAdresse());
		prSt.setString(3, data.getCp());
		prSt.setString(4, data.getVille());
		prSt.setString(5, data.getMail());
		prSt.setString(6, data.getTelephone());
		prSt.setString(7, data.getIban());
		prSt.setString(8, data.getSiret()); // cle primaire
	}

}
