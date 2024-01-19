package modele.dao.requetes.update;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class RequeteUpdateLocataire implements Requete<Locataire> {

	@Override
	public String requete() {
		return "UPDATE Locataire SET nom = ?, prenom = ?, telephone = ?, mail = ?, date_naissance = ? WHERE Id_Locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[1]); // Nom du locataire
		prSt.setString(2, id[2]); // Prénom du locataire
		prSt.setString(3, id[3]); // Numéro de téléphone du locataire
		prSt.setString(4, id[4]); // Adresse e-mail du locataire
		prSt.setDate(5, Date.valueOf(id[5])); // Date de naissance du locataire
		prSt.setString(6, id[0]); // ID du locataire (clé primaire)
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		// Paramétrage des valeurs pour la requête UPDATE à partir de l'objet Locataire
		prSt.setString(1, data.getNom()); // Nom du locataire
		prSt.setString(2, data.getPrenom()); // Prénom du locataire
		prSt.setString(3, data.getTelephone()); // Numéro de téléphone du locataire
		prSt.setString(4, data.getMail()); // Adresse e-mail du locataire

		// Date de naissance du locataire
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
		    java.util.Date parsedDate = dateFormat.parse(data.getDateNaissance());
		    prSt.setDate(5, new Date(parsedDate.getTime()));
		} catch (ParseException e) {
		    e.printStackTrace();  // Gestion de l'erreur en cas d'échec de la conversion de la date
		}

		prSt.setString(6, data.getIdLocataire()); // ID du locataire (clé primaire)
	}

}
