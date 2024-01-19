package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

public class RequeteUpdateImmeuble implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "UPDATE Immeuble SET adresse = ?, cp = ?, ville = ?, periode_construction = ?, type_immeuble = ?"
				+ "WHERE Id_Immeuble = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble data) throws SQLException {
		// Paramétrage des valeurs pour la requête UPDATE à partir de l'objet correspondant
		prSt.setString(1, data.getAdresse()); //  Adresse de l'immeuble
		prSt.setString(2, data.getCp()); // Code postal de l'immeuble
		prSt.setString(3, data.getVille()); // Ville de l'immeuble
		prSt.setString(4, data.getPeriodeConstruction());// Période de construction de l'immeuble
		prSt.setString(5, data.getType_immeuble()); // Type de l'immeuble
		prSt.setString(6, data.getImmeuble()); // ID de l'immeuble (clé primaire)

	}

}
