package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer une location en fonction de l'identifiant du bien, du locataire
 * et de la date de début de la location.
 */
public class RequeteDeleteLocation implements Requete<Louer> {

    /**
     * Retourne la requête SQL pour supprimer une location en fonction de l'identifiant du bien,
     * de l'identifiant du locataire et de la date de début de la location.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM Louer WHERE ID_Bien = ? AND Id_locataire = ? AND Date_debut = ?";
    }

    /**
     * Paramètre la PreparedStatement avec les identifiants et la date de début de la location
     * pour effectuer la suppression de la location correspondante.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants et date de début éventuels (ici, ID_Bien, Id_locataire et Date_debut).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // ID_Bien
        prSt.setString(2, id[1]); // Id_locataire
        prSt.setDate(3, Date.valueOf(id[2])); // Date_debut
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Louer
     * pour effectuer la suppression de la location correspondante.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param data  Objet Louer contenant les données nécessaires pour la requête.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
        prSt.setString(1, data.getBien().getIdBien()); // ID_Bien
        prSt.setString(2, data.getLocataire().getIdLocataire()); // Id_locataire
        prSt.setDate(3, Date.valueOf(data.getDateDebut())); // Date_debut
    }
}

