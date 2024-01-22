package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Echeance;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'une échéance.
 *
 * @param donnee Objet Echeance contenant les données à insérer.
 */
public class SousProgrammeInsertEcheance implements SousProgramme<Echeance> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Echeance(?,?)}";
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
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Echeance donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Echeance pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
		prSt.setString(1, donnee.getAssurance().getNuméroPolice());
		prSt.setDate(2, java.sql.Date.valueOf(donnee.getDateEcheance()));
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Echeance pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Echeance pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Echeance donnee) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Echeance pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Echeance pour laquelle les paramètres de calcul doivent être définis.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Echeance donnees) {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}
