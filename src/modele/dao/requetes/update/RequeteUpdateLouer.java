package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteUpdateLouer implements Requete<Louer>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "UPDATE Louer SET nb_mois= ?, loyer_TTC = ? , caution_TTC = ?, bail = ?, date_depart = ?, loyer_paye = ?, montant_reel_paye = ?, "
				+ "annee = ?, trimestre = ?,provision_chargeMens_TTC = ?, etat_lieux = ? "
				+ " WHERE Id_Locataire = ?, Id_Bien = ?, Date_Debut = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
		prSt.setInt(1, data.getNbMois());
		prSt.setDouble(2, data.getLoyerTTC());
		prSt.setDouble(3, data.getCautionTTC());
		prSt.setString(4, data.getBail());
		prSt.setDate(5, Date.valueOf(data.getDateDepart()));
		prSt.setInt(6,data.getLoyerPaye());
		prSt.setDouble(7, data.getMontantReelPaye());
		prSt.setString(8, data.getIcc().getAnnee());
		prSt.setString(9, data.getIcc().getTrimestre());
		prSt.setDouble(10, data.getProvision_chargeMens_TTC());
		prSt.setString(11, data.getEtat_lieux());
		prSt.setString(12, data.getLocataire().getIdLocataire());
		prSt.setString(13, data.getBien().getIdBien());
		prSt.setDate(14,Date.valueOf(data.getDateDebut()));
	}

}
