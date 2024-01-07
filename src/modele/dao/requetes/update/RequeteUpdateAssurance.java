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
		prSt.setFloat(1, data.getMontant());
		prSt.setString(2, data.getBien().getIdBien());
		prSt.setString(3, data.getEntreprise().getSiret());
		prSt.setString(4, data.getNuméroPolice());
	}

}
