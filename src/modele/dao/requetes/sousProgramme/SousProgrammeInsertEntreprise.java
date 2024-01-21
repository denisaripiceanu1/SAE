package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Entreprise;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'une entreprise.
 *
 * @param donnee Objet Entreprise contenant les données à insérer.
 */
public class SousProgrammeInsertEntreprise implements SousProgramme<Entreprise> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Entreprise(?,?,?,?,?,?,?,?)}";
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
		prSt.setString(1, parametres[0]); // clé primaire SIRET
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
		prSt.setString(8, parametres[7]);
	}

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité Entreprise donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Entreprise pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametres(PreparedStatement prSt, Entreprise donnee) throws SQLException {
		prSt.setString(1, donnee.getSiret()); // clé primaire de Locataire
		prSt.setString(2, donnee.getNom());
		prSt.setString(3, donnee.getAdresse());
		prSt.setString(4, donnee.getCp());
		prSt.setString(5, donnee.getVille());
		prSt.setString(6, donnee.getMail());
		prSt.setString(7, donnee.getTelephone());
		prSt.setString(8, donnee.getIban());
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Entreprise pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Entreprise pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
	@Override
	public void parametresSequence(CallableStatement prSt, Entreprise donnee) throws SQLException {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Entreprise pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Entreprise pour laquelle les paramètres de calcul doivent être définis.
     */
	@Override
	public void parametresCalcul(CallableStatement st, Entreprise donnees) {
		// TODO Auto-generated method stub
		// La méthode n'est pas utilisée dans ce contexte
	}

}

