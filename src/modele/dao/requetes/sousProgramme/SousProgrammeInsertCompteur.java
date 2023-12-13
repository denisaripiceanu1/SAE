package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.SousProgramme;

public class SousProgrammeInsertCompteur implements SousProgramme<Compteur>{

	@Override
	public String appelSousProgramme() {
		return "{call Insert_Compteur(?, ?, ?, ?, ?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
//		prSt.setString(1, parametres[0]);
//		prSt.setString(2, parametres[1]);
//		prSt.setString(3, parametres[2]);
//		prSt.setString(4, parametres[3]); String idCompteur, String typeComp, Bien bien, Immeuble immeuble
//		prSt.setString(5, parametres[4]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Compteur donnee) throws SQLException {
		prSt.setString(1, donnee.getIdCompteur());
		prSt.setString(2, donnee.getTypeComp());
		prSt.setDouble(3, 1.0);
		prSt.setString(4, donnee.getBien().getIdBien());
		prSt.setString(5, donnee.getImmeuble().getImmeuble());
	}

}
