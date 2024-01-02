package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

//Bien = Immeuble
public class RequeteDeleteQuotter implements Requete<Quotter> {

	@Override
	public String requete() {
		return "DELETE FROM QUOTTER WHERE Id_Bien = ? AND type_quotite = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);// clé prirmaire la maison la maison
	}

	@Override
	public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
		prSt.setString(1, donnee.getBien().getIdBien());
		prSt.setString(2, donnee.getTypeQuotite().getType_quotite());// clé primaire
	}
}