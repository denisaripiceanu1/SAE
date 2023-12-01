package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Locataire;
import modele.Échéance;
import modele.dao.requetes.select.RequeteSelectEcheance;
import modele.dao.requetes.select.RequeteSelectEcheanceById;
import modele.dao.requetes.select.RequeteSelectLocataire;
import modele.dao.requetes.select.RequeteSelectLocataireById;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	@Override
	public void create(Locataire donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Locataire donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Locataire donnees) {
		delete(donnees);

	}

	@Override
	public Locataire findById(String... id) throws SQLException{
		List<Locataire> locataires = find(new RequeteSelectLocataireById(), id);
		if (locataires.isEmpty()) {
			return null;
		}
		return locataires.get(0);
	}

	@Override
	public List<Locataire> findAll() throws SQLException{
		return find(new RequeteSelectLocataire());
	}

	@Override
	protected Locataire creerInstance(ResultSet curseur) throws SQLException {
		Locataire locataire = null;
		try {
			locataire = new Locataire(curseur.getString("Id_Locataire"), curseur.getString("nom"),
					curseur.getString("prenom"), curseur.getString("telephone"), curseur.getString("mail"),
					curseur.getString("date_naissance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locataire;
	}

}