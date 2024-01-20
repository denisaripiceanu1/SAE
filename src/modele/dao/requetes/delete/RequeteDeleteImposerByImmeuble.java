package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer les impositions en fonction de l'identifiant d'un immeuble.
 */
public class RequeteDeleteImposerByImmeuble implements Requete<Imposer> {

    /**
     * Retourne la requête SQL pour supprimer les impositions en fonction de l'identifiant d'un immeuble.
     * La sous-requête sélectionne les biens liés à l'immeuble en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM IMPOSER "
        		+ "WHERE ID_Bien IN "
        		+ "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble
     * pour effectuer la suppression des impositions liées aux biens de cet immeuble.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants éventuels (ici, l'identifiant de l'immeuble).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Imposer
     * pour effectuer la suppression des impositions liées aux biens de l'immeuble associé.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Imposer contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Imposer data) throws SQLException {
        prSt.setString(1, data.getBien().getImmeuble().getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}

