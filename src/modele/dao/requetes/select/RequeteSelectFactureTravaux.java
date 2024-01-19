package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteSelectFactureTravaux implements Requete<Facture> {

    public String requete() {
        return "SELECT * FROM Facture WHERE designation ='Travaux'";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
    }

    @Override
    public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
		// TODO Auto-generated method stub
    }
}
