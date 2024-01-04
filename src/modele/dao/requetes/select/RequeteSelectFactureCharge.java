package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteSelectFactureCharge implements Requete<Facture> {

    public String requete() {
        return "SELECT * FROM Facture WHERE designation NOT IN ('Travaux', 'Loyer') ORDER BY Id_Bien ASC, date_emission DESC";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
    }

    @Override
    public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
    }
}
