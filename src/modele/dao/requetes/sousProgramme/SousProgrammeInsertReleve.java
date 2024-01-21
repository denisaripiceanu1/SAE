package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Releve;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un Releve (Releve).
 *
 * @param donnee Objet Releve contenant les données du Releve à insérer.
 */
public class SousProgrammeInsertReleve implements SousProgramme<Releve> {

    /**
     * Retourne l'appel du sous-programme SQL pour l'insertion d'un Releve.
     *
     * @return Appel du sous-programme SQL pour l'insertion d'un Releve.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Relevé(?,?,?)}";
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Releve pour l'insertion (non implémenté).
     *
     * @param prSt       PreparedStatement à paramétrer.
     * @param parametres Paramètres du Releve à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Releve pour l'insertion.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Releve contenant les données du Releve à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Releve donnee) throws SQLException {
		prSt.setString(1, donnee.getCompteur().getIdCompteur());
		prSt.setDate(2, Date.valueOf(donnee.getDate_releve()));
		prSt.setDouble(3, donnee.getIndexComp());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Releve pour les calculs spécifiques (non implémenté).
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet Releve contenant les données pour lesquelles les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Releve donnees) {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Releve pour les requêtes sur les séquences (non implémenté).
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet Releve contenant les données pour lesquelles les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Releve donnee) throws SQLException {
		// TODO Auto-generated method stub
	}
}