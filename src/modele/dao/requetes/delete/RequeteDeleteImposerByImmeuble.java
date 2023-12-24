package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Imposer;
import modele.dao.requetes.Requete;

public class RequeteDeleteImposerByImmeuble implements Requete<Imposer> {

    @Override
    public String requete() {
        return "DELETE FROM IMPOSER "
        		+ "WHERE ID_Bien IN "
        		+ "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
    }

    @Override
    public void parametres(PreparedStatement prSt, Imposer data) throws SQLException {
        prSt.setString(1, data.getBien().getImmeuble().getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}
