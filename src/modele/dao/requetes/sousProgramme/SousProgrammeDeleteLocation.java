package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Locataire;
import modele.Louer;
import modele.dao.SousProgramme;

public class SousProgrammeDeleteLocation implements SousProgramme<Louer> {

	private Locataire locataire;
	private Bien bien;
	private String dateDebut;

	public SousProgrammeDeleteLocation(Locataire locataire, Bien bien, String dateDebut) {
		this.locataire = locataire;
		this.bien = bien;
		this.dateDebut = dateDebut;
	}

	@Override
	public String appelSousProgramme() {
		return "{call DETRUIREBien(?, ?, ?, ?)}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, locataire.toString());
		prSt.setString(2, bien.toString());

		java.sql.Date dateDebut = prSt.getDate("date_debut");
		prSt.setDate(3, dateDebut);
	}
}
