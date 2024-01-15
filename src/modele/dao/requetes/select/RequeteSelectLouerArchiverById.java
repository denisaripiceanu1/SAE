package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerArchiverById implements Requete<Louer> {

	@Override
	public String requete() {
		return "SELECT * FROM Louer WHERE Id_Bien = ? AND Id_Locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// Assurez-vous de convertir les chaînes en types appropriés pour la base de
		// données
		prSt.setString(1, id[0]); // Id_Bien
		prSt.setString(2, id[1]); //
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		// Assurez-vous de convertir les types appropriés pour la base de données
		prSt.setString(1, data.getBien().getIdBien());
		prSt.setString(2, data.getLocataire().getIdLocataire());
		/*
		 * // Convertir la date au format AAAA-MM-JJ SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd"); String dateDebutStr =
		 * sdf.format(data.getDateDebut()); prSt.setDate(3,
		 * java.sql.Date.valueOf(dateDebutStr));
		 */
	}
}
