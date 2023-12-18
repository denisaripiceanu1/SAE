package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteUpdateFacture implements Requete<Facture> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "UPDATE SET dateEmission = ?, datePaiment = ?, modePaiement = ?, numeroDevis = ?, designation = ?, accompteVerse = ?,"
				+ " imputableLocataire = ?, Id_Immeuble = ?, Id_Bien = ?, SIRET = ? WHERE numero = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {

		prSt.setDate(1, Date.valueOf(data.getDateEmission()));
		prSt.setDate(2, Date.valueOf(data.getDatePaiement()));
		prSt.setString(3, data.getModePaiement());
		prSt.setString(4, data.getNumeroDevis());
		prSt.setString(5, data.getDesignation());
		prSt.setDouble(6, data.getAccompteVerse());
		prSt.setInt(7, data.getImputableLocataire());
		prSt.setString(8, data.getImmeuble().getImmeuble());
		prSt.setString(9, data.getBien().getIdBien());
		prSt.setString(10, data.getEntreprise().getSiret());
		prSt.setString(11, data.getNumero());
	}

}
