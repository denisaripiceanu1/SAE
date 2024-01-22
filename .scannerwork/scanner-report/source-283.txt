package modele.dao.requetes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Requête permettant de vérifier si un logement est loué en fonction de son identifiant.
 * La requête utilise la table "Louer" et compte le nombre d'occurrences de l'identifiant du bien.
 * Si le nombre est supérieur à zéro, le logement est considéré comme loué.
 */
public class VerificationOccupation implements Requete<Boolean> {

    private Connection connection;

    // Constructeur prenant la connexion en paramètre
    public VerificationOccupation(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retourne la requête SQL pour vérifier l'occupation d'un logement.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "SELECT COUNT(*) FROM Louer WHERE Id_Bien = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du bien.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param id   Identifiant du bien pour lequel on souhaite vérifier l'occupation.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    /**
     * Paramètre non utilisé dans ce contexte.
     *
     * @param prSt PreparedStatement à paramétrer.
     * @param data Données à utiliser dans la requête (non utilisé ici).
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Boolean data) throws SQLException {
        // Cette méthode n'est pas utilisée dans ce contexte
    }

    /**
     * Vérifie si un logement est loué en fonction de son identifiant.
     *
     * @param idBien Identifiant du bien à vérifier.
     * @return true si le logement est loué, false sinon.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public boolean estLoue(String idBien) throws SQLException {
        String sql = requete();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            parametres(pstmt, idBien);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si le résultat a au moins une ligne, le logement est loué
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }

        // En cas d'erreur ou d'absence de résultat, on considère que le logement n'est pas loué
        return false;
    }
}
