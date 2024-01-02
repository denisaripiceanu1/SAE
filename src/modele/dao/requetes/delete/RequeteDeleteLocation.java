package modele.dao.requetes.delete;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteDeleteLocation implements Requete<Louer> {

	@Override
	public String requete() {
		return "DELETE FROM Louer WHERE ID_Bien = ? AND Id_locataire = ? AND Date_debut = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]); //
		prSt.setString(2, id[1]);
		prSt.setDate(3, Date.valueOf(id[2]));
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		prSt.setString(1, data.getBien().getIdBien()); //
		prSt.setString(2, data.getLocataire().getIdLocataire());
		prSt.setDate(3, Date.valueOf(data.getDateDebut()));
	}

}
