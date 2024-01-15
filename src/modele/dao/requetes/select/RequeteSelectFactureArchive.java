package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteSelectFactureArchive implements Requete<Facture> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Archivage_Facture";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
		// TODO Auto-generated method stub

	}

}
