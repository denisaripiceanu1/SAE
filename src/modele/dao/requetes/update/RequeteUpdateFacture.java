package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteUpdateFacture implements Requete<Facture> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "UPDATE Facture SET date_emission = ?, date_paiement = ?, mode_Paiement = ?, numero_Devis = ?, designation = ?, accompte_Verse = ?,"
				+ " imputable_Locataire = ?, Id_Immeuble = ?, Id_Bien = ?, SIRET = ? WHERE numero = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setDate(1, java.sql.Date.valueOf(id[0]));
		prSt.setDate(2, convertToDate(id[1]));
		prSt.setString(3, id[2]);
		prSt.setString(4, id[3]);
		prSt.setString(5, id[4]);
		prSt.setDouble(6, Double.parseDouble(id[5]));
		prSt.setInt(7, Integer.parseInt(id[6]));
		if (id[7] != null) {
			prSt.setString(8, id[0]);
		} else {
			prSt.setNull(8, java.sql.Types.VARCHAR);
		}

		if (id[8] != null) {
			prSt.setString(9, id[9]);
		} else {
			prSt.setNull(9, java.sql.Types.VARCHAR);
		}
		prSt.setString(10, id[10]);
		prSt.setString(11, id[11]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {

		prSt.setDate(1, java.sql.Date.valueOf(data.getDateEmission()));
		prSt.setDate(2, java.sql.Date.valueOf(data.getDatePaiement()));
		prSt.setString(3, data.getModePaiement());
		prSt.setString(4, data.getNumeroDevis());
		prSt.setString(5, data.getDesignation());
		prSt.setDouble(6, data.getAccompteVerse());
		prSt.setInt(7, data.getImputableLocataire());
		if (data.getImmeuble() != null) {
			prSt.setString(8, data.getImmeuble().getImmeuble());
		} else {
			prSt.setNull(8, java.sql.Types.VARCHAR);
		}

		if (data.getBien() != null) {
			prSt.setString(9, data.getBien().getIdBien());
		} else {
			prSt.setNull(9, java.sql.Types.VARCHAR);
		}
		prSt.setString(10, data.getEntreprise().getSiret());
		prSt.setString(11, data.getNumero());
	}

	private java.sql.Date convertToDate(String dateString) {
		try {
			return java.sql.Date.valueOf(dateString);
		} catch (IllegalArgumentException e) {
			// Handle invalid date format, log the error, etc.
			return null;
		}
	}

}
