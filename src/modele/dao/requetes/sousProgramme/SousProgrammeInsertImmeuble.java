package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un Immeuble.
 *
 * @param donnee Objet Immeuble contenant les données à insérer.
 */
public class SousProgrammeInsertImmeuble implements SousProgramme<Immeuble> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Immeuble(?, ?, ?, ?, ?, ?)}";
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
     * Paramètre la PreparedStatement avec les valeurs de l'entité Immeuble donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Immeuble pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Immeuble donnee) throws SQLException {
	    prSt.setString(1, donnee.getImmeuble());
	    prSt.setString(2, donnee.getAdresse());
	    prSt.setString(3, donnee.getCp());
	    prSt.setString(4, donnee.getVille());
	    prSt.setString(5, donnee.getPeriodeConstruction());
	    prSt.setString(6, donnee.getType_immeuble());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Immeuble pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Immeuble pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Immeuble donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Immeuble pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Immeuble pour laquelle les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Immeuble donnees) {
		// TODO Auto-generated method stub
	}

}

