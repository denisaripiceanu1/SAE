package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Quotite;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'une quotité (Quotite).
 *
 * @param donnee Objet Quotite contenant les données de la quotité à insérer.
 */
public class SousProgrammeInsertQuotite implements SousProgramme<Quotite> {

    /**
     * Retourne l'appel du sous-programme SQL pour l'insertion d'une quotité.
     *
     * @return Appel du sous-programme SQL pour l'insertion d'une quotité.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Insert_Quotite(?)}";
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Quotite pour l'insertion (non implémenté).
     *
     * @param prSt       PreparedStatement à paramétrer.
     * @param parametres Paramètres de la quotité à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Quotite pour l'insertion.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Quotite contenant les données de la quotité à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Quotite donnee) throws SQLException {
		prSt.setString(1, donnee.getType_quotite());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Quotite pour les calculs spécifiques (non implémenté).
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet Quotite contenant les données pour lesquelles les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Quotite donnees) {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Quotite pour les requêtes sur les séquences (non implémenté).
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet Quotite contenant les données pour lesquelles les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Quotite donnee) throws SQLException {
		// TODO Auto-generated method stub
	}
}
