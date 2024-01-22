package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Facture;

/**
 * Classe représentant un sous-programme SQL pour l'archivage d'une facture.
 *
 * @param donnee Objet Facture contenant les données à archiver.
 */
public class SousProgrammeInsertFactureArchiver implements SousProgramme<Facture> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Archivage_Facture(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs fournies dans le tableau de chaînes de caractères.
     *
     * @param prSt      PreparedStatement à paramétrer.
     * @param parametres Tableau de chaînes de caractères contenant les valeurs à paramétrer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]); // clé primaire numero
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
		prSt.setString(8, parametres[7]);
		prSt.setString(9, parametres[8]);
		prSt.setString(10, parametres[9]);
		prSt.setString(11, parametres[10]);
		prSt.setString(12, parametres[11]);
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Facture donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Facture pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Facture donnee) throws SQLException {
		prSt.setString(1, donnee.getNumero()); // clé primaire de Locataire
		prSt.setDate(2, convertirDate(donnee.getDateEmission()));
		prSt.setDate(3, convertirDate(donnee.getDatePaiement()));
		prSt.setString(4, donnee.getModePaiement());
		prSt.setString(5, donnee.getNumeroDevis());
		prSt.setString(6, donnee.getDesignation());
		prSt.setDouble(7, donnee.getMontantReelPaye());
		prSt.setDouble(8, donnee.getMontant());
		prSt.setInt(9, donnee.getImputableLocataire());

		// Paramètres potentiellement nuls
		if (donnee.getImmeuble() != null && donnee.getImmeuble().getImmeuble() != null) {
			prSt.setString(10, donnee.getImmeuble().getImmeuble());
		} else {
			prSt.setNull(10, java.sql.Types.VARCHAR);
		}

		if (donnee.getBien() != null && donnee.getBien().getIdBien() != null) {
			prSt.setString(11, donnee.getBien().getIdBien());
		} else {
			prSt.setNull(11, java.sql.Types.VARCHAR);
		}

		if (donnee.getEntreprise() != null && donnee.getEntreprise().getSiret() != null) {
			prSt.setString(12, donnee.getEntreprise().getSiret());
		} else {
			prSt.setNull(12, java.sql.Types.VARCHAR);
		}

	}

    /**
     * Convertit une chaîne de caractères représentant une date au format "dd-MM-yyyy" en un objet Date.
     *
     * @param dateStr Chaîne de caractères représentant une date.
     * @return Objet Date résultant de la conversion.
     * @throws SQLException Si une erreur de format de date survient.
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

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Facture pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Facture pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Facture donnee) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Facture pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Facture pour laquelle les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Facture donnees) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}

