package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un locataire en fonction de son identifiant.
 */
public class RequeteDeleteLocataire implements Requete<Locataire> {

    /**
     * Retourne la requête SQL pour supprimer un locataire en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM LOCATAIRE WHERE Id_Locataire = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du locataire
     * pour effectuer la suppression du locataire correspondant.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants éventuels (ici, l'identifiant du locataire).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Locataire
     * pour effectuer la suppression du locataire correspondant.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Locataire contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
        prSt.setString(1, data.getIdLocataire());
    }
}

