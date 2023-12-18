package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;

public class SousProgrammeInsertImmeuble implements SousProgramme<Immeuble> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Immeuble(?, ?, ?, ?, ?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
//		prSt.setString(1, parametres[0]);
//		prSt.setString(2, parametres[1]);
//		prSt.setString(3, parametres[2]);
//		prSt.setString(4, parametres[3]);
//		prSt.setInt(5, Integer.parseInt(parametres[4])); // Pour convertir en Int avant l'entrée dans la BD
//		prSt.setDate(6, java.sql.Date.valueOf(parametres[5]));// Pour la date 
//		prSt.setString(7, parametres[6]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble donnee) throws SQLException {
		prSt.setString(1, donnee.getImmeuble());
		prSt.setString(2, donnee.getAdresse());
		prSt.setString(3, donnee.getCp());
		prSt.setString(4, donnee.getVille());
		prSt.setString(5, donnee.getPeriodeConstruction());
		prSt.setString(6, donnee.getType_immeuble());
	}

}
