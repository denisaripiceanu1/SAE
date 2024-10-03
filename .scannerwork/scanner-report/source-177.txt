package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un immeuble en fonction de son identifiant.
 */
public class RequeteDeleteImmeuble implements Requete<Immeuble> {

    /**
     * Retourne la requête SQL pour supprimer un immeuble en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM IMMEUBLE WHERE ID_Immeuble = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble
     * pour effectuer la suppression de l'immeuble.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants éventuels (ici, l'identifiant de l'immeuble).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé primaire (ID_Immeuble)
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Immeuble
     * pour effectuer la suppression de l'immeuble.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Immeuble contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Immeuble donnee) throws SQLException {
        prSt.setString(1, donnee.getImmeuble()); // clé primaire (ID_Immeuble)
    }
}

