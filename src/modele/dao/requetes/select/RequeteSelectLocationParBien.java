package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteSelectLocationParBien implements Requete<Louer>{

    @Override
    public String requete() {
        return "SELECT * FROM Louer WHERE Id_Bien = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
        prSt.setString(1, data.getBien().getImmeuble().getImmeuble());
    }
}

