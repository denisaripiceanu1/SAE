package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer tous les biens liés à un immeuble de la table "BIEN"
 * en fonction de l'identifiant de l'immeuble.
 */
public class RequeteDeleteBienByImmeuble implements Requete<Immeuble> {

    /**
     * Retourne la requête SQL pour supprimer les biens liés à un immeuble en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM BIEN WHERE ID_Immeuble = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant de l'immeuble dont on souhaite supprimer les biens.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble dont on souhaite supprimer les biens.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param data Immeuble dont on souhaite supprimer les biens.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Immeuble data) throws SQLException {
        prSt.setString(1, data.getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}
