package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.Quotter;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un Quotter (Quotter).
 *
 * @param donnee Objet Quotter contenant les données du Quotter à insérer.
 */
public class SousProgrammeInsertQuotter implements SousProgramme<Quotter> {

    /**
     * Retourne l'appel du sous-programme SQL pour l'insertion d'un Quotter.
     *
     * @return Appel du sous-programme SQL pour l'insertion d'un Quotter.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Quotter(?, ?, ?)}";
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Quotter pour l'insertion (non implémenté).
     *
     * @param prSt       PreparedStatement à paramétrer.
     * @param parametres Paramètres du Quotter à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'objet Quotter pour l'insertion.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Quotter contenant les données du Quotter à insérer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
		prSt.setString(1, donnee.getBien().getIdBien());
		prSt.setString(2, donnee.getTypeQuotite().getType_quotite());
		prSt.setDouble(3, donnee.getPourcentage());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Quotter pour les calculs spécifiques (non implémenté).
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet Quotter contenant les données pour lesquelles les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Quotter donnees) {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'objet Quotter pour les requêtes sur les séquences (non implémenté).
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet Quotter contenant les données pour lesquelles les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Quotter donnee) throws SQLException {
		// TODO Auto-generated method stub
	}
}
