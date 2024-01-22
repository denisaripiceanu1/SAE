package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'archivage de location (Louer).
 *
 * @param donnee Objet Louer contenant les données de la location à archiver.
 */
public class SousProgrammeInsertLocationArchiver implements SousProgramme<Louer> {

    /**
     * Retourne l'appel du sous-programme SQL pour l'archivage d'une location.
     *
     * @return Appel du sous-programme SQL pour l'archivage d'une location.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Archivage_Louer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Louer pour l'archivage (non implémenté).
     *
     * @param prSt       PreparedStatement à paramétrer.
     * @param parametres Paramètres de la location à archiver.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Louer pour l'archivage.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Louer contenant les données de la location à archiver.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
		prSt.setString(1, donnee.getLocataire().getIdLocataire());
		prSt.setString(2, donnee.getBien().getIdBien());
		prSt.setDate(3, java.sql.Date.valueOf(donnee.getDateDebut()));

		// nb_mois --> Paramètre potentiellement nul
		prSt.setNull(4, java.sql.Types.INTEGER);

		prSt.setDouble(5, donnee.getLoyerTTC());
		prSt.setDouble(6, donnee.getProvision_chargeMens_TTC());
		prSt.setDouble(7, donnee.getCautionTTC());
		prSt.setString(8, donnee.getBail());
		prSt.setString(9, donnee.getEtat_lieux());

		// Paramètres potentiellement nuls
		if (donnee.getDateDerniereRegularisation() == null) {
			prSt.setNull(10, java.sql.Types.DATE);
		} else {
			prSt.setDate(10, java.sql.Date.valueOf(donnee.getDateDerniereRegularisation()));
		}

		prSt.setInt(11, donnee.getLoyerPaye());

		prSt.setString(12, donnee.getIcc().getAnnee()); // annee

		prSt.setString(13, donnee.getIcc().getTrimestre()); // trimestre

		prSt.setDouble(14, donnee.getMontantReelPaye());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Louer pour les calculs spécifiques (non implémenté).
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet Louer contenant les données pour lesquelles les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Louer pour les requêtes sur les séquences (non implémenté).
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet Louer contenant les données pour lesquelles les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub
	}
}

