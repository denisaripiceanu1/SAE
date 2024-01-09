package modele.dao.requetes.sousProgramme;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;

public class SousProgrammeInsertLocataire implements SousProgramme<Locataire> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Locataire(?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]); // clé priamire de Locataire
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setDate(6, Date.valueOf(parametres[5]));
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire donnee) throws SQLException {
		prSt.setString(1, donnee.getIdLocataire()); // clé priamire de Locataire
		prSt.setString(2, donnee.getNom());
		prSt.setString(3, donnee.getPrenom());
		prSt.setString(4, donnee.getTelephone());
		prSt.setString(5, donnee.getMail());
		prSt.setDate(6, Date.valueOf(donnee.getDateNaissance()));
	}
	public void parametres(PreparedStatement prSt, Locataire donnee, int Sequence) throws SQLException {

		// TODO Auto-generated method stub
		
	}

}
