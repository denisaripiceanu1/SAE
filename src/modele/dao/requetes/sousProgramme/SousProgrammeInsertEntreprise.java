package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;
import modele.Louer;

public class SousProgrammeInsertEntreprise implements SousProgramme<Entreprise> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Entreprise(?,?,?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]); // clé priamire SIRET
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
		prSt.setString(8, parametres[7]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Entreprise donnee) throws SQLException {
		prSt.setString(1, donnee.getSiret()); // clé priamire de Locataire
		prSt.setString(2, donnee.getNom());
		prSt.setString(3, donnee.getAdresse());
		prSt.setString(4, donnee.getCp());
		prSt.setString(5, donnee.getVille());
		prSt.setString(6, donnee.getMail());
		prSt.setString(7, donnee.getTelephone());
		prSt.setString(8, donnee.getIban());
	}


	@Override
	public void parametres(PreparedStatement prSt, Entreprise donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub
		
	}

}
