package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Compteur;
import modele.Releve;
import modele.dao.requetes.delete.RequeteDeleteReleve;
import modele.dao.requetes.select.RequeteSelectReleve;
import modele.dao.requetes.select.RequeteSelectReleveByCompteur;
import modele.dao.requetes.select.RequeteSelectReleveById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertReleve;

public class DaoReleve extends DaoModele<Releve> implements Dao<Releve> {

	@Override
	public void create(Releve donnees) throws SQLException {
		SousProgramme<Releve> sp = new SousProgrammeInsertReleve();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	@Override
	public void update(Releve donnees) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Releve donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteReleve(), donnees);
	}

	@Override
	protected Releve creerInstance(ResultSet curseur) throws SQLException {
		Releve releve = null;
		try {
			String idCompteur = curseur.getString("Id_Compteur");
			DaoCompteur daoCompteur = new DaoCompteur();
			Compteur compteur = daoCompteur.findById(idCompteur);

			releve = new Releve(compteur, curseur.getString("date_relevé"), curseur.getDouble("indexComp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return releve;
	}

	@Override
	public Releve findById(String... id) throws SQLException {
		List<Releve> releve = this.find(new RequeteSelectReleveById(), id);
		if (releve.isEmpty()) {
			return null;
		}
		return releve.get(0);
	}

	@Override
	public List<Releve> findAll() throws SQLException {
		return this.find(new RequeteSelectReleve());
	}

	public List<Releve> findReleveByCompteur(String id) throws SQLException {
		return this.find(new RequeteSelectReleveByCompteur(), id);
	}

}
