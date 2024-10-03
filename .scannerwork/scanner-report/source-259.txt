package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Compteur;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un compteur.
 *
 * @param donnee Objet Compteur contenant les données à insérer.
 */
public class SousProgrammeInsertCompteur implements SousProgramme<Compteur>{

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Compteur(?, ?, ?, ?, ?)}";
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
     * Paramètre la PreparedStatement avec les valeurs de l'entité Compteur donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Compteur pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Compteur donnee) throws SQLException {
		prSt.setString(1, donnee.getIdCompteur());
		prSt.setString(2, donnee.getTypeComp());
		prSt.setDouble(3, donnee.getPrix_abonnement()); // Changer la valeur de l'abonnement par défaut
		
		// Si on n'entre pas d'immeuble pour le compteur
		// Sinon, insérer l'immeuble
		if (donnee.getImmeuble() == null) {
			prSt.setString(4, null);
		} else {
			prSt.setString(4, donnee.getImmeuble().getImmeuble());
		}
		
		// Si on n'entre pas de bien pour le compteur
		// Sinon, insérer le bien
		if (donnee.getBien() == null) {
			prSt.setString(5, null);
		} else {
			prSt.setString(5, donnee.getBien().getIdBien());
		}
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Compteur pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Compteur pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Compteur donnee) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Compteur pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Compteur pour laquelle les paramètres de calcul doivent être définis.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Compteur donnees) {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}

