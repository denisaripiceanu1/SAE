package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Compteur;
import modele.dao.requetes.Requete;

public class RequeteDeleteCompteur implements Requete<Compteur>{
	@Override
	public String requete() {
		return "DELETE FROM Compteur WHERE id_compteur = ?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(PreparedStatement prSt, Compteur data) throws SQLException {
		prSt.setString(1, data.getIdCompteur()); 
		
	}
}
