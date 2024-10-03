package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

public class RequeteUpdateBien implements Requete<Bien> {

	@Override
	public String requete() {
		return "UPDATE Bien SET surface_habitable = ?, nb_pieces = ?, num_etage = ?, date_acquisition = ?, type_bien = ? ,Id_Immeuble = ? WHERE Id_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, Bien data) throws SQLException {
		// Paramétrage des valeurs pour la requête UPDATE à partir de l'objet correspondant
		prSt.setDouble(1, data.getSurfaceHabitable());       // Paramètre 1 : Surface habitable du bien
		prSt.setInt(2, data.getNbPieces());                  // Paramètre 2 : Nombre de pièces du bien
		prSt.setInt(3, data.getNumEtage());                  // Paramètre 3 : Numéro d'étage du bien
		prSt.setDate(4, Date.valueOf(data.getDateAcquisition()));  // Paramètre 4 : Date d'acquisition du bien
		prSt.setString(5, data.getType_bien());              // Paramètre 5 : Type de bien
		prSt.setString(6, data.getImmeuble().getImmeuble()); // Paramètre 6 : ID de l'immeuble associé au bien
		prSt.setString(7, data.getIdBien());                 // Paramètre 7 : ID du bien (clé primaire)
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}
}