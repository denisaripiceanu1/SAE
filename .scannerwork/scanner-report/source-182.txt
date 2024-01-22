package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer toutes les locations associées à un bien spécifique,
 * identifié par l'ID_Immeuble.
 */
public class RequeteDeleteLocationByBien implements Requete<Louer> {

    /**
     * Retourne la requête SQL pour supprimer toutes les locations associées à un bien
     * identifié par l'ID_Immeuble.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM Louer "
                + "WHERE ID_Bien IN "
                + "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'Immeuble
     * pour effectuer la suppression des locations associées à ce bien.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiant de l'Immeuble (ID_Immeuble).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // ID_Immeuble
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Louer contenant le bien concerné
     * pour effectuer la suppression des locations associées à ce bien.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Louer contenant le bien associé aux locations à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
        prSt.setString(1, data.getBien().getImmeuble().getImmeuble()); // ID_Immeuble
    }
}

