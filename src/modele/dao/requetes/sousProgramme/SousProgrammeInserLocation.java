package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;

public class SousProgrammeInserLocation implements SousProgramme<Louer> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Louer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
		prSt.setString(1, donnee.getLocataire().getIdLocataire());
		prSt.setString(2, donnee.getBien().getIdBien());
		prSt.setDate(3, java.sql.Date.valueOf(donnee.getDateDebut()));

		// Paramètre potentiellement nul

		prSt.setNull(4, java.sql.Types.INTEGER);

		prSt.setDouble(5, donnee.getLoyerTTC());
		prSt.setDouble(6, donnee.getProvision_chargeMens_TTC());
		prSt.setDouble(7, donnee.getCautionTTC());
		prSt.setString(8, donnee.getBail());
		prSt.setString(9, donnee.getEtat_lieux());

		// Paramètres potentiellement nuls
		if (donnee.getDateDepart() == null) {
			prSt.setNull(10, java.sql.Types.DATE);
		} else {
			prSt.setDate(10, java.sql.Date.valueOf(donnee.getDateDepart()));
		}

		prSt.setInt(11, donnee.getLoyerPaye());

		prSt.setString(12, "2023"); // annee

		prSt.setString(13, "1"); // trimestre

		prSt.setDouble(14, donnee.getMontantReelPaye());
	}

}
