package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Facture;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'une facture.
 *
 * @param donnee Objet Facture contenant les données à insérer.
 */
public class SousProgrammeInsertFacture implements SousProgramme<Facture> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Facture(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
	public void parametresCSV(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]); // clé primaire Numero
		prSt.setDate(2, convertirDateJour(parametres[1])); // date émission
		prSt.setDate(3, convertirDate(parametres[2])); // date paiement
		prSt.setString(4, parametres[3]); // mode de paiement
		prSt.setNull(5, java.sql.Types.VARCHAR); // Numero devis
		prSt.setString(6, parametres[4]); // designation
		prSt.setString(7, parametres[5]); // montant reel paye
		prSt.setString(8, parametres[6]); // montant
		prSt.setString(9, parametres[7]); // imputable locataire
		prSt.setNull(10, java.sql.Types.VARCHAR); // Id immeuble
		prSt.setString(11, parametres[8]); // Id Bien
		prSt.setNull(12, java.sql.Types.VARCHAR); // SIRET
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
		prSt.setDate(2, java.sql.Date.valueOf(donnee.getDateEmission()));
		if (donnee.getDatePaiement().isEmpty()) {
			prSt.setNull(3, java.sql.Types.DATE);
		} else {
			prSt.setDate(3, java.sql.Date.valueOf(donnee.getDatePaiement()));
		}
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
     * Convertit une chaîne de caractères représentant une date au format "dd/MM/yy" en un objet Date.
     *
     * @param dateEnString Chaîne de caractères représentant une date.
     * @return Objet Date résultant de la conversion.
     */
	private Date convertirDate(String dateEnString) {
		try {
			// Convertir le format "05/10/23" en "dd/MM/yy"
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			java.util.Date dateUtil = sdf.parse(dateEnString);

			// Convertir java.util.Date en java.sql.Date
			return new Date(dateUtil.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * Convertit une chaîne de caractères représentant une date au format "MM/yy" en un objet Date.
     * Ajoute le jour 01 au format "MM/YY" avant de le convertir.
     *
     * @param dateEnString Chaîne de caractères représentant une date.
     * @return Objet Date résultant de la conversion.
     */
	private Date convertirDateJour(String dateEnString) {
		try {
			// Ajoutez le jour 01 au format "MM/YY" avant de le convertir
			SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
			java.util.Date dateUtil = sdf.parse("01/" + dateEnString);

			// Convertir java.util.Date en java.sql.Date
			return new Date(dateUtil.getTime());
		} catch (ParseException e) {
			// Gérer l'exception en fonction de vos besoins
			e.printStackTrace();
			return null;
		}
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Facture pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Facture pour laquelle les paramètres de calcul doivent être définis.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Facture donnees) {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}

