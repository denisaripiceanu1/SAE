package modele.dao.requetes.delete;

import modele.dao.requetes.select.RequeteSelectChargeById;

public class RequeteDeleteCharge extends RequeteSelectChargeById{
	@Override
	public String requete() {
		return "DELETE FROM Charge WHERE ID_Charge = ?";
	}


}
