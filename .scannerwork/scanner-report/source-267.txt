package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un lien entre un Bien et un Impôt (Imposer).
 *
 * @param donnee Objet Imposer contenant les données à insérer.
 */
public class SousProgrammeInsertImposer implements SousProgramme<Imposer> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Imposer(?,?)}";
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
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Imposer donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Imposer pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Imposer donnee) throws SQLException {
		prSt.setString(1, donnee.getBien().getIdBien());
		prSt.setDouble(2, donnee.getImpot().getIdImpot());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Imposer pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Imposer pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Imposer donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Imposer pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Imposer pour laquelle les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Imposer donnees) {
		// TODO Auto-generated method stub
	}

}
