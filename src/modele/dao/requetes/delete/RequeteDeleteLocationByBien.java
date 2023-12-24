package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteDeleteLocationByBien implements Requete<Louer>{

	@Override
	public String requete() {
        return "DELETE FROM Louer "
        		+ "WHERE ID_Bien IN "
        		+ "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]); // clé étrangère (ID_Immeuble)
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		prSt.setString(1, data.getBien().getImmeuble().getImmeuble()); // clé étrangère (ID_Immeuble)
	}

}
