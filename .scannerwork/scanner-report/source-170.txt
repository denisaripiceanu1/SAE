package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un bien de la table "BIEN" en fonction de son identifiant.
 */
public class RequeteDeleteBien implements Requete<Bien> {

    /**
     * Retourne la requête SQL pour supprimer un bien en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM BIEN WHERE ID_Bien = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du bien.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant du bien à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du bien à supprimer.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Bien dont on souhaite supprimer l'enregistrement.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Bien donnee) throws SQLException {
    	// clé primaire
        prSt.setString(1, donnee.getIdBien()); 
    }
}
