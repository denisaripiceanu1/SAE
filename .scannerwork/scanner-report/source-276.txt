package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.requetes.Requete;

public class RequeteUpdateAssurance implements Requete<Assurance> {

	@Override
	public String requete() {
		return "UPDATE Assurance SET montant = ?, Id_Bien = ?, SIRET = ? WHERE numero_police = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
	    // Paramétrage des valeurs pour la requête UPDATE à partir de l'objet Assurance
	    prSt.setFloat(1, data.getMontant()); // Montant de l'assurance
	    prSt.setString(2, data.getBien().getIdBien()); // ID du bien associé à l'assurance
	    prSt.setString(3, data.getEntreprise().getSiret()); // SIRET de l'entreprise d'assurance associée
	    prSt.setString(4, data.getNuméroPolice()); // Numéro de police de l'assurance
	}

}
