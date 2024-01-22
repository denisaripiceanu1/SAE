package modele.dao.requetes.update;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Entreprise;
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

	public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {
		// Paramétrage des valeurs pour la requête UPDATE à partir de l'objet Entreprise
		prSt.setString(1, data.getNom()); 		// Nom de l'entreprise
		prSt.setString(2, data.getAdresse());	// Adresse de l'entreprise
		prSt.setString(3, data.getCp());		// Code postal de l'entreprise
		prSt.setString(4, data.getVille());		// Ville de l'entreprise
		prSt.setString(5, data.getMail());		// Adresse e-mail de l'entreprise
		prSt.setString(6, data.getTelephone());	// Numéro de téléphone de l'entreprise
		prSt.setString(7, data.getIban());		// IBAN de l'entreprise
		prSt.setString(8, data.getSiret()); 	// Numéro SIRET (clé primaire) pour identifier l'entreprise à mettre à jour

	}

}
