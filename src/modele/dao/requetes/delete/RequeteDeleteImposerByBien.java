package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

public class RequeteDeleteImposerByBien implements Requete<Quotter>{

	@Override
	public String requete() {
        return "DELETE FROM Imposer "
        		+ "WHERE ID_Bien IN "
        		+ "(SELECT ID_Bien FROM BIEN WHERE ID_Immeuble = ?)";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter data) throws SQLException {
		prSt.setString(1, data.getBien().getImmeuble().getImmeuble());
		
	}

}
