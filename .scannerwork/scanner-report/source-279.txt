package modele.dao.requetes.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteUpdateFacture implements Requete<Facture> {

	@Override
	public String requete() {
		return "UPDATE Facture SET date_emission = ?, date_paiement = ?, mode_Paiement = ?, numero_Devis = ?, designation = ?, montant_reel_paye = ?, montant = ?, "
				+ " imputable_Locataire = ?, Id_Immeuble = ?, Id_Bien = ?, SIRET = ? WHERE numero = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
		// Paramétrage des valeurs pour la requête UPDATE à partir de l'objet Facture
		prSt.setDate(1, data.getDateEmissionAsSqlDate()); // Date d'émission
		prSt.setDate(2, data.getDatePaiementAsSqlDate()); // Date de paiement
		prSt.setString(3, data.getModePaiement()); // Mode de paiement
		prSt.setString(4, data.getNumeroDevis()); // Numéro du devis
		prSt.setString(5, data.getDesignation()); // Désignation de la facture
		prSt.setDouble(6, data.getMontantReelPaye()); // Montant réel payé
		prSt.setDouble(7, data.getMontant()); // Montant total de la facture
		prSt.setInt(8, data.getImputableLocataire()); // Imputable au locataire (boolean)
		// ID de l'immeuble associé à la facture
		if (data.getImmeuble() == null) {
			prSt.setNull(9, java.sql.Types.VARCHAR);
		} else {
			prSt.setString(9, data.getImmeuble().getImmeuble());
		}
		// ID du bien associé à la facture
		if (data.getBien() == null) {
			prSt.setNull(10, java.sql.Types.VARCHAR);
		} else {
			prSt.setString(10, data.getBien().getIdBien());
		}
		// SIRET de l'entreprise associée à la facture
		if (data.getEntreprise() != null && data.getEntreprise().getSiret() != null) {
			prSt.setString(11, data.getEntreprise().getSiret());
		} else {
			prSt.setNull(11, java.sql.Types.VARCHAR);
		}
		// Numéro de la facture à mettre à jour
		prSt.setString(12, data.getNumero());
	}

}
