package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer une assurance de la table "ASSURANCE" en fonction de son numéro de police.
 */
public class RequeteDeleteAssurance implements Requete<Assurance> {

    /**
     * Retourne la requête SQL pour supprimer une assurance en fonction de son numéro de police.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM ASSURANCE WHERE NUMERO_POLICE = ?";
    }

    /**
     * Paramètre non utilisé dans ce contexte.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant de l'assurance (non utilisé ici).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {

    }

    /**
     * Paramètre la PreparedStatement avec le numéro de police de l'assurance.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Assurance dont on souhaite supprimer l'enregistrement.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Assurance donnee) throws SQLException {
        prSt.setString(1, donnee.getNuméroPolice()); // clé primaire
    }
}
