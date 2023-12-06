package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Locataire;
import modele.dao.requetes.Requete;

public class RequeteUpdateLocataire implements Requete<Locataire>{
	
	@Override
	public String requete() {
		return "UPDATE Locataire SET nom = ?, prenom = ?, telephone = ?, mail = ?, date_naissance = ? WHERE Id_Locataire = ?";
	}
	
	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getNom());
		prSt.setString(2, data.getPrenom());
		prSt.setString(3, data.getTelephone());
		prSt.setString(4, data.getMail());
		prSt.setDate(5, Date.valueOf(data.getDateNaissance()));
		prSt.setString(6, data.getIdLocataire()); // clé priamire de Locataire
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
