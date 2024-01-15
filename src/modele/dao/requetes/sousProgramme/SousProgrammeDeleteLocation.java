package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Locataire;
import modele.Louer;

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
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, locataire.toString());
		prSt.setString(2, bien.toString());

		java.sql.Date dateDebut = ((CallableStatement) prSt).getDate("date_debut");
		prSt.setDate(3, dateDebut);
	}

	@Override
	public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresSequence(CallableStatement prSt, Louer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresCalcul(CallableStatement st, Louer donnees) {
		// TODO Auto-generated method stub
		
	}
}
