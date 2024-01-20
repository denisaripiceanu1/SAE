package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;
import modele.dao.requetes.Requete;

/**
 * Requête permettant de supprimer un diagnostic de la table "Diagnostic"
 * en fonction de son identifiant.
 */
public class RequeteDeleteDiagnostic implements Requete<Diagnostics> {

    /**
     * Retourne la requête SQL pour supprimer un diagnostic en fonction de son identifiant.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM Diagnostic WHERE Id_Diagnostic = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du diagnostic à supprimer.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant du diagnostic dont on souhaite effectuer la suppression.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du diagnostic à supprimer.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param data Diagnostic dont on souhaite effectuer la suppression.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Diagnostics data) throws SQLException {
        prSt.setInt(1, data.getIdDiagnostic());
    }
}

