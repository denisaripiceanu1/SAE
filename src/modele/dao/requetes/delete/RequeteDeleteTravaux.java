package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer une facture de travaux spécifique identifiée par son numéro.
 */
public class RequeteDeleteTravaux implements Requete<Facture> {

    /**
     * Retourne la requête SQL pour supprimer une facture de travaux spécifique identifiée par son numéro.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM FACTURE WHERE NUMERO = ?";
    }

    /**
     * Paramètre la PreparedStatement avec le numéro de la facture de travaux à supprimer.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Tableau de chaînes de caractères contenant le numéro de la facture à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // Numéro de la facture (clé primaire)
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Facture contenant le numéro de la facture à supprimer.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet Facture contenant le numéro de la facture à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Facture donnee) throws SQLException {
        prSt.setString(1, donnee.getNumero()); // Numéro de la facture (clé primaire)
    }
}

