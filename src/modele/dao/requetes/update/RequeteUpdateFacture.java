package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteUpdateFacture implements Requete<Facture> {

	@Override
	public String requete() {
		return "UPDATE Facture SET date_emission = ?, date_paiement = ?, mode_Paiement = ?, numero_Devis = ?, designation = ?, accompte_Verse = ?, montant = ?, "
				+ " imputable_Locataire = ?, Id_Immeuble = ?, Id_Bien = ?, SIRET = ? WHERE numero = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {

	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
		prSt.setDate(1, data.getDateEmissionAsSqlDate());
		prSt.setDate(2, data.getDatePaiementAsSqlDate());
		prSt.setString(3, data.getModePaiement());
		prSt.setString(4, data.getNumeroDevis());
		prSt.setString(5, data.getDesignation());
		prSt.setDouble(6, data.getAccompteVerse());
		prSt.setDouble(7, data.getMontant());
		prSt.setInt(8, data.getImputableLocataire());

		prSt.setNull(9, java.sql.Types.VARCHAR);

		prSt.setString(10, data.getBien().getIdBien());

		if (data.getEntreprise() != null && data.getEntreprise().getSiret() != null) {
			prSt.setString(11, data.getEntreprise().getSiret());
		} else {
			prSt.setNull(11, java.sql.Types.VARCHAR);
		}
		prSt.setString(12, data.getNumero());
	}

}
