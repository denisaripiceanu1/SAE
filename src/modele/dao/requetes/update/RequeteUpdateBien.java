package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.dao.requetes.Requete;

public class RequeteUpdateBien implements Requete<Bien>{


		@Override
		public String requete() {
			return "UPDATE Bien SET surface_habitable = ?, nb_pieces = ?, num_etages = ?, date_acquisition = ?, Id_Immeuble = ? WHERE Id_Bien = ?";
		}
		@Override
		public void parametres(PreparedStatement prSt, Bien data) throws SQLException {
			prSt.setDouble(1, data.getSurfaceHabitable());
			prSt.setInt(2, data.getNbPieces());
			prSt.setInt(3, data.getNumEtage());
			prSt.setString(4, data.getDateAcquisition());
			prSt.setString(5, data.getImmeuble().toString());
			prSt.setString(6, data.getIdBien().toString()); // cle primaire 
	}
		@Override
		public void parametres(PreparedStatement prSt, String... id) throws SQLException {
			// TODO Auto-generated method stub
			
		}
}