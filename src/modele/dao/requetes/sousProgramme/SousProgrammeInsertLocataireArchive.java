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
		prSt.setString(2, data.getNom());
		prSt.setString(3, data.getPrenom());
		prSt.setString(4, data.getMail());
		prSt.setDate(6, java.sql.Date.valueOf(data.getDateNaissance()));
	}

	@Override
	public String appelSousProgramme() {
		// TODO Auto-generated method stub
		return "{ call Archivage_locataire(?,?,?,?,?,?)}";
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
