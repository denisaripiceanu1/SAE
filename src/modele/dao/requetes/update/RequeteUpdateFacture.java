package modele.dao.requetes.update;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.requetes.Requete;

public class RequeteUpdateFacture implements Requete<Facture>{

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "UPDATE SET numero = ?, dateEmission = ?, datePaiment = ?, modePaiement = ?, numeroDevis = ?, designation = ?, accompteVerse = ?,"
				+ " imputableLocataire = ?, Id_Immeuble = ?, Id_Bien = ?, SIRET = ? WHERE idFacture = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
        prSt.setString(1, data.getNumero());
        prSt.setDate(2, Date.valueOf(data.getDateEmission()));
        prSt.setDate(3, Date.valueOf(data.getDatePaiement()));
        prSt.setString(4, data.getModePaiement());
        prSt.setString(5, data.getNumeroDevis());
        prSt.setString(6, data.getDesignation());
        prSt.setDouble(7, data.getAccompteVerse());
        prSt.setInt(8, data.getImputableLocataire());
        prSt.setString(9, data.getImmeuble().getImmeuble());
        prSt.setString(10, data.getBien().getIdBien());
        prSt.setString(11, data.getEntreprise().getSiret());
        prSt.setInt(12, data.getIdFacture());
	}

}
