package modele.dao.requetes.delete;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import modele.Compteur;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un compteur de la table "Compteur"
 * en fonction de son identifiant.
 */
public class RequeteDeleteCompteur implements Requete<Compteur> {

    /**
     * Retourne la requête SQL pour supprimer un compteur en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM Compteur WHERE id_compteur = ?";
    }

    /**
     * Cette méthode n'est pas utilisée dans ce contexte.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant du compteur dont on souhaite effectuer la suppression.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // TODO: Méthode non utilisée dans ce contexte
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du compteur à supprimer.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param data Compteur dont on souhaite effectuer la suppression.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Compteur data) throws SQLException {
        prSt.setString(1, data.getIdCompteur());
    }
}

