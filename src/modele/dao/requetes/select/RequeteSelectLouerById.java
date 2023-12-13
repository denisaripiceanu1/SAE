package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLouerById implements Requete<Louer> {

    @Override
    public String requete() {
        return "SELECT * FROM Louer WHERE Id_Bien = ? AND Id_Locataire = ? AND Date_Debut = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Assurez-vous de convertir les chaînes en types appropriés pour la base de données
        prSt.setString(1, id[0]);  // Id_Bien
        prSt.setString(2, id[1]);  // Id_Locataire
        prSt.setDate(3, java.sql.Date.valueOf(id[2]));  // Date_Debut
    }

    @Override
    public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
        // Assurez-vous de convertir les types appropriés pour la base de données
        prSt.setString(1, data.getIdBien().toString());
        prSt.setString(2, data.getIdLocataire().toString());
        
        // Convertir la date au format AAAA-MM-JJ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDebutStr = sdf.format(data.getDateDebut());
        prSt.setDate(3, java.sql.Date.valueOf(dateDebutStr));
    }
}
