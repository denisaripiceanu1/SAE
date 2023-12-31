package modele.dao.requetes.update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.CictOracleDataSource;
import modele.dao.requetes.Requete;

public class RequeteUpdateLocataire implements Requete<Locataire> {

    @Override
    public String requete() {
        // Only update non-primary key fields in the Locataire table
        return "UPDATE Locataire SET nom = ?, prenom = ?, telephone = ?, mail = ?, date_naissance = ? WHERE Id_Locataire = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[1]); // nom
        prSt.setString(2, id[2]); // prénom
        prSt.setString(3, id[3]); // téléphone
        prSt.setString(4, id[4]); // mail
        prSt.setDate(5, Date.valueOf(id[5])); // date de naissance
        prSt.setString(6, id[0]); // id locataire
    }

    @Override
    public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
        System.out.println("Paramètres de mise à jour : " + data);
        prSt.setString(1, data.getNom());
        prSt.setString(2, data.getPrenom());
        prSt.setString(3, data.getTelephone());
        prSt.setString(4, data.getMail());
        prSt.setDate(5, Date.valueOf(data.getDateNaissance()));
        prSt.setString(6, data.getIdLocataire()); // Old Id_Locataire
    }

    // Method to update Id_Locataire in Louer table
    public void updateLouerIdLocataire(String oldIdLocataire, String newIdLocataire) throws SQLException {
        String sql = "UPDATE Louer SET Id_Locataire = ? WHERE Id_Locataire = ?";
        try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql)) {
            st.setString(1, newIdLocataire);
            st.setString(2, oldIdLocataire);
            st.executeUpdate();
        }
    }
}
