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
		prSt.setString(1, id[1]); // nom
		prSt.setString(2, id[2]); // prénom
		prSt.setString(3, id[3]); // téléphone
		prSt.setString(4, id[4]); // mail
		prSt.setDate(5, Date.valueOf(id[5])); // date de naissance
		prSt.setString(6, id[0]); // id locataire
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getNom());
		prSt.setString(2, data.getPrenom());
		prSt.setString(3, data.getTelephone());
		prSt.setString(4, data.getMail());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date parsedDate = dateFormat.parse(data.getDateNaissance());
			prSt.setDate(5, new Date(parsedDate.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		prSt.setString(6, data.getIdLocataire());
	}

}
