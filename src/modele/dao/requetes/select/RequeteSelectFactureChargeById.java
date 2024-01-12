package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteSelectFactureChargeById implements Requete<Facture> {

    public String requete() {
        return "SELECT * FROM Facture WHERE designation NOT IN ('Travaux') AND numero = ? ORDER BY Id_Bien ASC, date_emission DESC";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
    	prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
    	prSt.setString(1, data.getNumero());
    }
}
