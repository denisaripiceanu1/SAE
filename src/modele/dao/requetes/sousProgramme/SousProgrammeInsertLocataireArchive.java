package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Locataire;
import modele.dao.requetes.Requete;

/**
 * Classe représentant un sous-programme SQL pour l'archivage d'un Locataire.
 *
 * @param donnee Objet Locataire contenant les données à archiver.
 */
public class SousProgrammeInsertLocataireArchive implements Requete<Locataire>, SousProgramme<Locataire> {

    /**
     * Retourne la requête SQL pour l'archivage d'un Locataire (non implémenté dans cette classe).
     *
     * @return Requête SQL pour l'archivage d'un Locataire.
     */
	@Override
	public String requete() {
		return null;
	}

    /**
     * Paramètre la PreparedStatement avec l'identifiant du Locataire à archiver.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id    Identifiant du Locataire à archiver.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Locataire donnée pour l'archivage.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param data Objet représentant l'entité Locataire pour laquelle les paramètres d'archivage doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		prSt.setString(1, data.getIdLocataire());
		prSt.setString(2, data.getNom());
		prSt.setString(3, data.getPrenom());
		prSt.setString(5, data.getMail());
		prSt.setString(4, data.getTelephone());
		prSt.setDate(6, convertirDate(data.getDateNaissance()));
	}

    /**
     * Retourne l'appel du sous-programme SQL pour l'archivage d'un Locataire.
     *
     * @return Appel du sous-programme SQL pour l'archivage d'un Locataire.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Archivage_Locataire(?,?,?,?,?,?)}";
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Locataire pour les calculs spécifiques (non implémenté).
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Locataire pour laquelle les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Locataire donnees) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Locataire pour les requêtes sur les séquences (non implémenté).
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Locataire pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Locataire donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Convertit une chaîne de caractères représentant une date au format "dd-MM-yyyy" en un objet Date SQL.
     *
     * @param dateStr Chaîne de caractères représentant une date.
     * @return Objet Date SQL représentant la date convertie.
     * @throws SQLException Si une erreur survient lors de la conversion de la date.
     */
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
}
