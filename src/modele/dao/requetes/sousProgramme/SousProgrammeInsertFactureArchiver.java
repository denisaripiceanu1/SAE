package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modele.Facture;
import modele.Louer;

public class SousProgrammeInsertFactureArchiver implements SousProgramme<Facture> {

	@Override
	public String appelSousProgramme() {
		return "{ call Inserer_Archivage_Facture(?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]); // clé priamire SIRET
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
		prSt.setString(8, parametres[7]);
		prSt.setString(9, parametres[8]);
		prSt.setString(10, parametres[9]);
		prSt.setString(11, parametres[10]);
		prSt.setString(12, parametres[11]);
	}

	@Override
	public void parametres(PreparedStatement prSt, Facture donnee) throws SQLException {
		prSt.setString(1, donnee.getNumero()); // clé priamire de Locataire
		prSt.setDate(2, convertirDate(donnee.getDateEmission()));
		prSt.setDate(3, convertirDate(donnee.getDatePaiement()));
		prSt.setString(4, donnee.getModePaiement());
		prSt.setString(5, donnee.getNumeroDevis());
		prSt.setString(6, donnee.getDesignation());
		prSt.setDouble(7, donnee.getMontantReelPaye());
		prSt.setDouble(8, donnee.getMontant());
		prSt.setInt(9, donnee.getImputableLocataire());

		// Paramètres potentiellement nuls
		if (donnee.getImmeuble() != null && donnee.getImmeuble().getImmeuble() != null) {
			prSt.setString(10, donnee.getImmeuble().getImmeuble());
		} else {
			prSt.setNull(10, java.sql.Types.VARCHAR);
		}

		if (donnee.getBien() != null && donnee.getBien().getIdBien() != null) {
			prSt.setString(11, donnee.getBien().getIdBien());
		} else {
			prSt.setNull(11, java.sql.Types.VARCHAR);
		}

		if (donnee.getEntreprise() != null && donnee.getEntreprise().getSiret() != null) {
			prSt.setString(12, donnee.getEntreprise().getSiret());
		} else {
			prSt.setNull(12, java.sql.Types.VARCHAR);
		}

	}

	@Override
	public void parametres(PreparedStatement prSt, Facture donnee, int Sequence) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub

	}

	private Date convertirDate(String dateStr) throws SQLException {
		try {
			SimpleDateFormat formatEntree = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date parsed = formatEntree.parse(dateStr);

			// Formater la date pour la sortie
			SimpleDateFormat formatSortie = new SimpleDateFormat("dd/MM/yy");
			String dateFormatee = formatSortie.format(parsed);

			// Convertir la date formatée en objet java.sql.Date
			return Date.valueOf(dateFormatee);
		} catch (ParseException e) {
			throw new SQLException("Erreur de format de date : " + dateStr, e);
		}
	}

}
