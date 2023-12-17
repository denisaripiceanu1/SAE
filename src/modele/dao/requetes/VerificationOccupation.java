package modele.dao.requetes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VerificationOccupation implements Requete<Boolean> {

    private Connection connection;

    // Constructeur prenant la connexion en paramètre
    public VerificationOccupation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String requete() {
        // La requête vérifie si le logement est loué en fonction de l'Id_Bien
        return "SELECT COUNT(*) FROM Louer WHERE Id_Bien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Boolean data) throws SQLException {
        // Cette méthode n'est pas utilisée dans ce contexte, vous pouvez laisser vide
    }

    // Méthode pour exécuter la requête
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
