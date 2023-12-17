package modele.dao.requetes.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Charge;
import modele.dao.requetes.Requete;

public class RequeteSelectChargeAll implements Requete<Charge> {

	@Override
	public String requete() {
        return "SELECT * FROM Charge WHERE nom=? AND montant_reel=? AND montant_previsionnel=? AND deductible=? AND Id_Bien=?";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... id) throws SQLException {
	    // Initialisez les paramètres dans l'ordre requis
	    prSt.setString(1, id[0]); // nom
	    prSt.setDouble(2, Double.parseDouble(id[1])); // montant_reel
	    prSt.setDouble(3, Double.parseDouble(id[2])); // montant_previsionnel
	    
	    // Correction : Utilisez les entiers 1 et 0 pour deductible
	    if ("Oui".equalsIgnoreCase(id[3])) {
	        prSt.setInt(4, 1);  // deductible
	    } else if ("Non".equalsIgnoreCase(id[3])) {
	        prSt.setInt(4, 0);
	    } else {
	        // Gérer le cas où la valeur n'est ni "Oui" ni "Non"
	        prSt.setInt(4, -1);  // Utilisez une valeur par défaut ou ajustez en fonction de votre logique
	    }

	    prSt.setString(5, id[4]); // Id_Bien
	}




	@Override
	public void parametres(PreparedStatement prSt, Charge data) throws SQLException {
	}
}
