package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

//Bien = = Immeuble dans la BD
/**
 * Requête permettant de supprimer les associations de Quotter pour les biens d'un immeuble spécifique,
 * identifié par l'ID_Immeuble.
 */
public class RequeteDeleteQuotterByImmeuble implements Requete<Quotter> {

    /**
     * Retourne la requête SQL pour supprimer les associations de Quotter pour les biens d'un immeuble spécifique,
     * identifié par l'ID_Immeuble.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM QUOTTER "
                + "WHERE ID_Bien IN "
                + "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble (ID_Immeuble) pour effectuer
     * la suppression des associations Quotter associées à ses biens.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiant de l'immeuble (ID_Immeuble).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Quotter contenant le bien associé à l'immeuble pour effectuer
     * la suppression des associations Quotter.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Quotter contenant le bien associé à l'immeuble à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
        prSt.setString(1, donnee.getBien().getImmeuble().getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}
