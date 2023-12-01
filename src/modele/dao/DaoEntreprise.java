package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.dao.requetes.select.RequeteSelectEntreprise;
import modele.dao.requetes.select.RequeteSelectEntrepriseById;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise>{

	@Override
	public void create(Entreprise donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Entreprise donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entreprise donnees) {
		delete(donnees);
		
	}

	@Override
	public Entreprise findById(String... id)  throws SQLException {
		List<Entreprise> entreprises = find(new RequeteSelectEntrepriseById(), id);
		if (entreprises.isEmpty()) {
			return null;
		}
		return entreprises.get(0);
	}

	@Override
	public List<Entreprise> findAll()  throws SQLException {
		return find(new RequeteSelectEntreprise());
	}

	@Override
	protected Entreprise creerInstance(ResultSet curseur) throws SQLException {
		Entreprise entreprise = null;
		try {
			entreprise = new Entreprise(curseur.getString("SIRET"), curseur.getString("nom"),
					curseur.getString("adresse"),curseur.getString("cp"),curseur.getString("ville"), curseur.getString("mail"),curseur.getString("telephone"),curseur.getString("IBAN"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entreprise;
	}

}
