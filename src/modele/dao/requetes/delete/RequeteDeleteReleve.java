package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Releve;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un relevé spécifique identifié par l'ID du compteur, la date du relevé
 * et la valeur de l'index du compteur.
 */
public class RequeteDeleteReleve implements Requete<Releve> {

    /**
     * Retourne la requête SQL pour supprimer un relevé spécifique identifié par l'ID du compteur,
     * la date du relevé et la valeur de l'index du compteur.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM Relevé WHERE ID_Compteur = ? AND date_relevé = ? AND indexComp = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'ID du compteur, la date du relevé et la valeur de l'index du compteur
     * pour effectuer la suppression du relevé correspondant.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Tableau de chaînes de caractères contenant l'ID du compteur, la date du relevé et la valeur de l'index du compteur.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // ID du compteur
        prSt.setDate(2, Date.valueOf(id[1].substring(0, 10))); // Date du relevé (enlevant l'heure)
        prSt.setDouble(3, Double.parseDouble(id[2])); // Valeur de l'index du compteur
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Releve contenant le compteur, la date du relevé et la valeur de l'index
     * pour effectuer la suppression du relevé correspondant.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Releve contenant le compteur, la date du relevé et la valeur de l'index à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Releve donnee) throws SQLException {
        prSt.setString(1, donnee.getCompteur().getIdCompteur()); // ID du compteur
        prSt.setDate(2, Date.valueOf(donnee.getDate_releve().substring(0, 10))); // Date du relevé (enlevant l'heure)
        prSt.setDouble(3, donnee.getIndexComp()); // Valeur de l'index du compteur
    }
}

