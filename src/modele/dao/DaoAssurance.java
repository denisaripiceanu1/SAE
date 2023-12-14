package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Assurance;
import modele.Entreprise;
import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectAssurance;
import modele.dao.requetes.select.RequeteSelectAssuranceById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertAssurance;
import modele.dao.requetes.update.RequeteUpdateAssurance;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	@Override
	public void create(Assurance donnees) throws SQLException {
		SousProgramme<Assurance> sp = new SousProgrammeInsertAssurance();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Assurance donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateAssurance(), donnees);
	}

	@Override
	public void delete(Assurance donnees) {
		this.delete(donnees);
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

			DaoEntreprise daoEntreprise = new DaoEntreprise();
			Entreprise entreprise = daoEntreprise.findById("SIRET");

			assurance = new Assurance(numeroPolice, montantInit, immeuble, entreprise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assurance;
	}

	@Override
	public List<Assurance> findAll() throws SQLException {
		return this.find(new RequeteSelectAssurance());
	}

	@Override
	public Assurance findById(String... id) throws SQLException {
		List<Assurance> assurances = this.find(new RequeteSelectAssuranceById(), id);
		if (assurances.isEmpty()) {
			return null;
		}
		return assurances.get(0);
	}

}
