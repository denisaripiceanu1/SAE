package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class SousProgrammeInsertLocataireArchive implements Requete<Locataire>, SousProgramme<Locataire> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Archivage_Locataire WHERE Id_Locataire = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getIdLocataire());
	}

	@Override
	public String appelSousProgramme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parametresSequence(CallableStatement prSt, Locataire donnee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametresCalcul(CallableStatement st, Locataire donnees) throws SQLException {
		// TODO Auto-generated method stub

	}

}
