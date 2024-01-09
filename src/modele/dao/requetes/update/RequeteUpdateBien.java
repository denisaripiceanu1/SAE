package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

public class RequeteUpdateBien implements Requete<Bien> {

	@Override
	public String requete() {
		return "UPDATE Bien SET surface_habitable = ?, nb_pieces = ?, num_etage = ?, date_acquisition = ?, type_bien = ? ,Id_Immeuble = ? WHERE Id_Bien = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, Bien data) throws SQLException {
		prSt.setDouble(1, data.getSurfaceHabitable());
		prSt.setInt(2, data.getNbPieces());
		prSt.setInt(3, data.getNumEtage());
		prSt.setDate(4, Date.valueOf(data.getDateAcquisition()));
		prSt.setString(5, data.getType_bien());
		prSt.setString(6, data.getImmeuble().getImmeuble());
		prSt.setString(7, data.getIdBien()); // cle primaire
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub

	}
}