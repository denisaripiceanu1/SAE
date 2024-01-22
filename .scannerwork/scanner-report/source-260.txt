
package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Compteur;
import modele.Diagnostics;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un diagnostic.
 *
 * @param donnee Objet Diagnostics contenant les données à insérer.
 */
public class SousProgrammeInsertDiagnostic implements SousProgramme<Diagnostics> {
	
    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{call Insert_Diagnostic(?,?,?,?)}";
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
     * Paramètre la PreparedStatement avec les valeurs de l'entité Diagnostics donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Diagnostics pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Diagnostics pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Diagnostics pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	public void parametresSequence(CallableStatement prSt, Diagnostics donnee) throws SQLException {
		prSt.setDate(1, java.sql.Date.valueOf(donnee.getDateValidite()));
		prSt.setString(2, donnee.getTypeDiagnostic());
		prSt.setString(3, donnee.getBien().getIdBien());
		prSt.registerOutParameter(4, java.sql.Types.INTEGER);
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Diagnostics pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Diagnostics pour laquelle les paramètres de calcul doivent être définis.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Diagnostics donnees) {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}



