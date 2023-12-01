package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectAssurance;
import modele.dao.requetes.select.RequeteSelectAssuranceById;
import modele.dao.requetes.select.RequeteSelectEntreprise;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	@Override
	public void create(Assurance donnees) {
		// TODO: Implémenter la création
	}

	@Override
	public void update(Assurance donnees) {
		// TODO: Implémenter la mise à jour
	}

	@Override
	public void delete(Assurance donnees) {
		// TODO: Implémenter la suppression
	}

	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
		Assurance assurance = null;
		 try {
		        String numeroPolice = curseur.getString("numero_police");
		        float montantInit = curseur.getFloat("montant_init");

		        // Récupérer l'identifiant de l'immeuble
		        String idImmeuble = curseur.getString("Id_Immeuble");
		        DaoImmeuble daoImmeuble = new DaoImmeuble();
		        Immeuble immeuble = daoImmeuble.findById(idImmeuble);

		        assurance = new Assurance(numeroPolice, montantInit, immeuble);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		return assurance;
	}

	@Override
	public List<Assurance> findAll() throws SQLException {
		return find(new RequeteSelectAssurance());
	}

	@Override
	public Assurance findById(String... id) throws SQLException {
        List<Assurance> assurances = find(new RequeteSelectAssuranceById(), id);
        if (assurances.isEmpty()) {
            return null;
        }
        return assurances.get(0);
    }

}
