package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer une échéance de la table "ECHEANCE"
 * en fonction du numéro de police de l'assurance et de la date de l'échéance.
 */
public class RequeteDeleteEcheance implements Requete<Echeance> {

    /**
     * Retourne la requête SQL pour supprimer une échéance en fonction du numéro de police de l'assurance
     * et de la date de l'échéance.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM ECHEANCE WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE = ?";
    }

    /**
     * Cette méthode n'est pas utilisée dans ce contexte.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiants éventuels non utilisés dans cette requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Cette méthode n'est pas utilisée dans ce contexte.
    }

    /**
     * Paramètre la PreparedStatement avec le numéro de police de l'assurance et la date de l'échéance
     * pour effectuer la suppression.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Échéance dont on souhaite effectuer la suppression.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
        prSt.setString(1, donnee.getAssurance().getNuméroPolice());
        prSt.setDate(2, Date.valueOf(donnee.getDateEcheance().substring(0, 10)));
    }
}

