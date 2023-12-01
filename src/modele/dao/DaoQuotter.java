package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Bien;
import modele.Quotite;
import modele.Quotter;
import modele.Échéance;
import modele.dao.requetes.select.RequeteSelectAssuranceById;
import modele.dao.requetes.select.RequeteSelectQuotite;
import modele.dao.requetes.select.RequeteSelectQuotter;
import modele.dao.requetes.select.RequeteSelectQuotterById;

public class DaoQuotter extends DaoModele<Quotter> implements Dao<Quotter> {

	@Override
	public void create(Quotter donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Quotter donnees) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Quotter donnees) throws SQLException {
		delete(donnees);
	}

	@Override
	protected Quotter creerInstance(ResultSet curseur) throws SQLException {
		Quotter quotter = null;
		try {
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);
			
			String typeQ = curseur.getString("Type_quotite");
			DaoQuotite daoQuotite = new DaoQuotite();
			Quotite quotite = daoQuotite.findById(typeQ);
			
			quotter = new Quotter(bien, quotite, curseur.getDouble("pourcentage"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotter;
	}

	@Override
	public Quotter findById(String... id) throws SQLException {
        List<Quotter> quotter = find(new RequeteSelectQuotterById(), id);
        if (quotter.isEmpty()) {
            return null;
        }
        return quotter.get(0);
	}

	@Override
	public List<Quotter> findAll() throws SQLException {
		return find(new RequeteSelectQuotter());
	}

}
