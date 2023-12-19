package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Compteur;

public class SousProgrammeInsertCompteur implements SousProgramme<Compteur>{

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Compteur(?, ?, ?, ?, ?)}";
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
		prSt.setDouble(3, 1.0); //Changer la valeur de l'abonnement par défaut
		prSt.setString(4, donnee.getImmeuble().getImmeuble());
		//Si on entre pas de bien pour le compteur
		if(donnee.getBien() == null) {
			prSt.setString(5, null);
		} else {
			prSt.setString(5, donnee.getBien().getIdBien());
		}
	}

}
