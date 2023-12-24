package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

//Bien = Immeuble
public class RequeteDeleteQuotterByImmeuble implements Requete<Quotter> {

    @Override
    public String requete() {
        return "DELETE FROM QUOTTER "
        		+ "WHERE ID_Bien IN "
        		+ "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
    }

    @Override
    public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
        prSt.setString(1, donnee.getBien().getImmeuble().getImmeuble()); // clé étrangère (ID_Immeuble)
    }
}