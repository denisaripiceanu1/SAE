package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer une facture de travaux en fonction de son numéro.
 */
public class RequeteDeleteFactureTravaux implements Requete<Facture> {

    /**
     * Retourne la requête SQL pour supprimer une facture de travaux
     * en fonction de son numéro.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM FACTURE WHERE NUMERO = ?";
    }

    /**
     * Paramètre la PreparedStatement avec le numéro de la facture
     * pour effectuer la suppression de la facture de travaux.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants éventuels (ici, le numéro de la facture).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé primaire (NUMERO)
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Facture
     * pour effectuer la suppression de la facture de travaux.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Facture contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Facture donnee) throws SQLException {
        prSt.setString(1, donnee.getNumero()); // clé primaire (NUMERO)
    }
}

