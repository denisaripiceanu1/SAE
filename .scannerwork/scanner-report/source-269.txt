package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un Locataire.
 *
 * @param donnee Objet Locataire contenant les données à insérer.
 */
public class SousProgrammeInsertLocataire implements SousProgramme<Locataire> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Locataire(?,?,?,?,?,?)}";
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
		prSt.setString(1, parametres[0]); // clé primaire de Locataire
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setDate(6, Date.valueOf(parametres[5]));
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Locataire donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Locataire pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Locataire donnee) throws SQLException {
		prSt.setString(1, donnee.getIdLocataire()); // clé primaire de Locataire
		prSt.setString(2, donnee.getNom());
		prSt.setString(3, donnee.getPrenom());
		prSt.setString(4, donnee.getTelephone());
		prSt.setString(5, donnee.getMail());
		prSt.setDate(6, Date.valueOf(donnee.getDateNaissance()));
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Locataire pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Locataire pour laquelle les paramètres de calcul doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Locataire donnee) {
		// TODO Auto-generated method stub
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Locataire pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Locataire pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Locataire donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

}
