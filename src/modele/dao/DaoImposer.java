package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Compteur;
import modele.Imposer;
import modele.Impôt;
import modele.Locataire;
import modele.Releve;
import modele.dao.requetes.select.RequeteSelectImposer;
import modele.dao.requetes.select.RequeteSelectImposerById;
import modele.dao.requetes.select.RequeteSelectLocataire;
import modele.dao.requetes.select.RequeteSelectReleveById;
import modele.Imposer;

public class DaoImposer extends DaoModele<Imposer> implements Dao<Imposer>{

	@Override
	public void create(Imposer donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Imposer donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Imposer donnees) throws SQLException {
		delete(donnees);
	}

	@Override
	protected Imposer creerInstance(ResultSet curseur) throws SQLException {
		Imposer imposer = null;
		try {
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);
			
			String idImpot = curseur.getString("Id_Impot");
			DaoImpôt daoImpot = new DaoImpôt();
			Impôt impot = daoImpot.findById(idImpot);
			
			imposer = new Imposer(bien,impot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imposer;
	}

	@Override
	public Imposer findById(String... id) throws SQLException {
        List<Imposer> imposer = find(new RequeteSelectImposerById(), id);
        if (imposer.isEmpty()) {
            return null;
        }
        return imposer.get(0);
	}

	@Override
	public List<Imposer> findAll() throws SQLException {
		return find(new RequeteSelectImposer());
	}

}
