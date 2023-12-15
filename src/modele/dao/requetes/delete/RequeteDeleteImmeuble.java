package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

public class RequeteDeleteImmeuble implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "DELETE FROM IMMEUBLE WHERE ID_Immeuble = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Immeuble donnee) throws SQLException {
		prSt.setString(1, donnee.getImmeuble()); // cle primaire
	}

}
