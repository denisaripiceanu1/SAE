package modele.dao;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.List;

import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectImmeuble;
import modele.dao.requetes.select.RequeteSelectImmeubleById;
import modele.dao.requetes.update.RequeteUpdateImmeuble;

public class DaoImmeuble extends DaoModele<Immeuble> implements Dao<Immeuble> {

	@Override
	public void create(Immeuble donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Immeuble donnees) throws SQLException {
		miseAJour(new RequeteUpdateImmeuble(), donnees);

	}

	@Override
	public void delete(Immeuble donnees) {
		delete(donnees);

	}

	@Override
	public Immeuble findById(String... id) throws SQLException {
		List<Immeuble> immeuble = find(new RequeteSelectImmeubleById(), id);
		if (immeuble.isEmpty()) {
			return null;
		}
		return immeuble.get(0);
	}

	@Override
	public List<Immeuble> findAll() throws SQLException {
		return find(new RequeteSelectImmeuble());
	}

	@Override
	protected Immeuble creerInstance(ResultSet curseur) throws SQLException {
		Immeuble immeuble = null;
		try {
			// Convertir les dates en chaînes de caractères
			java.sql.Date dateAcquisition = curseur.getDate("date_acquisition");
			String dateAcquisitionStr = dateAcquisition.toString();

			immeuble = new Immeuble(curseur.getString("Id_Immeuble"), curseur.getString("adresse"),
					curseur.getString("cp"), curseur.getString("ville"), curseur.getString("periode_construction"),
					curseur.getInt("nb_logement"), dateAcquisitionStr, curseur.getString("type_immeuble"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return immeuble;
	}

}
