package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.Bien;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour l'insertion d'un bien.
 *
 * @param donnee Objet Bien contenant les données à insérer.
 */
public class SousProgrammeInsertBien implements SousProgramme<Bien> {

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
    @Override
    public String appelSousProgramme() {
        return "{call Inserer_Bien(?,?,?,?,?,?,?)}";
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
     * Paramètre la PreparedStatement avec les valeurs de l'entité Bien donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité Bien pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Bien donnee) throws SQLException {
        prSt.setString(1, donnee.getIdBien());
        prSt.setDouble(2, donnee.getSurfaceHabitable());
        prSt.setInt(3, donnee.getNbPieces());
        prSt.setInt(4, donnee.getNumEtage());
        prSt.setDate(5, java.sql.Date.valueOf(donnee.getDateAcquisition()));
        prSt.setString(6, donnee.getImmeuble().getImmeuble());
        prSt.setString(7, donnee.getType_bien());
    }

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Bien pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité Bien pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametresSequence(CallableStatement prSt, Bien donnee) throws SQLException {
        // TODO Auto-generated method stub
    }

    /**
     * Paramètre la CallableStatement avec les valeurs de l'entité Bien pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité Bien pour laquelle les paramètres de calcul doivent être définis.
     */
    @Override
    public void parametresCalcul(CallableStatement st, Bien donnees) {
        // TODO Auto-generated method stub
    }

}

