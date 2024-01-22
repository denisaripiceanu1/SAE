package modele.dao.requetes.select;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Echeance;
import modele.dao.requetes.Requete;

public class RequeteSelectEcheanceById implements Requete<Echeance> {

    @Override
    public String requete() {
        return "SELECT * FROM Echeance WHERE NUMERO_POLICE = ? AND DATE_ECHEANCE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        try {
            prSt.setString(1, id[0]);
            prSt.setDate(2, java.sql.Date.valueOf(id[1]));
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur lors de la conversion de la date : " + e.getMessage());
            throw e; // Propagez l'exception pour une gestion ultérieure
        }
    }


    @Override
    public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {
        prSt.setString(1, data.getAssurance().getNuméroPolice());
        prSt.setDate(2, java.sql.Date.valueOf(data.getDateEcheance()));
    }
}
