package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.requetes.Requete;

public class RequeteSelectAssuranceByLogement implements Requete<Assurance> {

    @Override
    public String requete() {
        return "SELECT * FROM ASSURANCE A " +
               "JOIN BIEN B ON A.Id_Immeuble = B.Id_Immeuble " +
               "WHERE B.Id_Bien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
        prSt.setString(1, data.getNuméroPolice());
    }
}
