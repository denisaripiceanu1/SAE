package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'une assurance.
 *
 * @param donnee Objet Assurance contenant les données à insérer.
 */
public class SousProgrammeInsertAssurance implements SousProgramme<Assurance> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
    @Override
    public String appelSousProgramme() {
        return "{call Inserer_Assurance(?,?,?,?)}";
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
     * Paramètre la PreparedStatement avec les valeurs de l'entité Assurance donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Assurance pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Assurance donnee) throws SQLException {
        prSt.setString(1, donnee.getNuméroPolice());
        prSt.setFloat(2, donnee.getMontant());
        prSt.setString(3, donnee.getBien().getIdBien());
        prSt.setString(4, donnee.getEntreprise().getSiret());
    }

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Assurance pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Assurance pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametresSequence(CallableStatement prSt, Assurance donnee) throws SQLException {
        // TODO Auto-generated method stub
    }

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Assurance pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Assurance pour laquelle les paramètres de calcul doivent être définis.
     */
    @Override
    public void parametresCalcul(CallableStatement st, Assurance donnees) {
        // TODO Auto-generated method stub
    }

}
