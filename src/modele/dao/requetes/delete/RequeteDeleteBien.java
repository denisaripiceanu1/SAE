package modele.dao.requetes.delete;

import modele.dao.requetes.select.RequeteSelectBienById;

public class RequeteDeleteBien extends RequeteSelectBienById {

	@Override
	public String requete() {
		return "DELETE FROM BIEN WHERE ID_Bien = ?";
	}
}
