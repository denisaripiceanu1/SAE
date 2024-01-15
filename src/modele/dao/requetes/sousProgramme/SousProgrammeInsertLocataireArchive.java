package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Locataire;
import modele.dao.requetes.Requete;

public class SousProgrammeInsertLocataireArchive implements Requete<Locataire>, SousProgramme<Locataire> {

	@Override
	public String requete() {
		return null;
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
		prSt.setString(5, data.getMail());
		prSt.setString(4, data.getTelephone());
		prSt.setDate(6, convertirDate(data.getDateNaissance()));
	}

	@Override
	public String appelSousProgramme() {
		// TODO Auto-generated method stub
		return "{ call Inserer_Archivage_Locataire(?,?,?,?,?,?)}";
	}

	private Date convertirDate(String dateStr) throws SQLException {
		try {
			SimpleDateFormat formatEntree = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date parsed = formatEntree.parse(dateStr);

			// Formater la date pour la sortie
			SimpleDateFormat formatSortie = new SimpleDateFormat("yyyy-MM-dd");
			String dateFormatee = formatSortie.format(parsed);

			// Convertir la date formatée en objet java.sql.Date
			return Date.valueOf(dateFormatee);
		} catch (ParseException e) {
			throw new SQLException("Erreur de format de date : " + dateStr, e);
		}
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
