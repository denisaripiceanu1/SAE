package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

public class RequeteDeleteBien implements Requete<Bien> {

	@Override
	public String requete() {
		return "DELETE FROM BIEN WHERE ID_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		

	}

	@Override
	public void parametres(PreparedStatement prSt, Bien donnee) throws SQLException {
		prSt.setString(1, donnee.getIdBien()); // cle primaire
	}

}
