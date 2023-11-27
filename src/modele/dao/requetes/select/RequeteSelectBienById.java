
package modele.dao.requetes.select;

import modele.Bien;
import modele.dao.requetes.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectBienById implements Requete<Bien> {

    @Override
    public String requete() {
        return "SELECT * FROM Bien WHERE Id_Bien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Bien data) throws SQLException {
        prSt.setString(1, data.getIdBien());
    }

}