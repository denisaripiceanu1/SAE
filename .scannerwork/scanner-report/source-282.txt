package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;
import modele.dao.requetes.Requete;

public class RequeteUpdateLouer implements Requete<Louer> {

	@Override
	public String requete() {
		return "UPDATE Louer SET nb_mois = ?, loyer_TTC = ?, caution_TTC = ?, bail = ?, date_derniere_reg = ?, loyer_paye = ?, montant_reel_paye = ?, "
				+ "annee = ?, trimestre = ?, provision_chargeMens_TTC = ?, etat_lieux = ? "
				+ "WHERE Id_Locataire = ? AND Id_Bien = ? AND Date_Debut = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer data) throws SQLException {
	    // Paramétrage des valeurs pour la requête UPDATE à partir de l'objet Assurance
		prSt.setInt(1, data.getNbMois()); // Nombre de mois du contrat de location
		prSt.setDouble(2, data.getLoyerTTC()); 	// Montant du loyer TTC
		prSt.setDouble(3, data.getCautionTTC()); // Montant de la caution TTC
		prSt.setString(4, data.getBail());  // Type de bail
		prSt.setDate(5, Date.valueOf(data.getDateDerniereRegularisation())); // Date de la dernière régularisation
		prSt.setInt(6, data.getLoyerPaye()); // Montant du loyer déjà payé
		prSt.setDouble(7, data.getMontantReelPaye()); // Montant réel déjà payé (incluant loyer et charges)
		prSt.setString(8, data.getIcc().getAnnee()); // Année de l'ICC (Indice du Coût de la Construction)
		prSt.setString(9, data.getIcc().getTrimestre()); // Trimestre de l'ICC
		prSt.setDouble(10, data.getProvision_chargeMens_TTC()); // Provision mensuelle pour charges TTC
		prSt.setString(11, data.getEtat_lieux()); // État des lieux du bien
		prSt.setString(12, data.getLocataire().getIdLocataire()); // ID du locataire associé au contrat de location
		prSt.setString(13, data.getBien().getIdBien()); // ID du bien associé au contrat de location
		prSt.setDate(14, Date.valueOf(data.getDateDebut())); // Date de début du contrat de location
	}

}
