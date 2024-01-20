package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer les factures liées à un immeuble
 * en fonction de l'identifiant de l'immeuble.
 */
public class RequeteDeleteFactureByImmeuble implements Requete<Immeuble> {

    /**
     * Retourne la requête SQL pour supprimer les factures liées à un immeuble
     * en fonction de l'identifiant de l'immeuble.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM FACTURE "
             + "WHERE ID_Bien IN "
             + "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant de l'immeuble
     * pour effectuer la suppression des factures associées.
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
     * Paramètre la PreparedStatement avec l'objet Immeuble
     * pour effectuer la suppression des factures associées à cet immeuble.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Immeuble contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Immeuble data) throws SQLException {
        prSt.setString(1, data.getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}

