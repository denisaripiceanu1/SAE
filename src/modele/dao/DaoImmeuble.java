package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Immeuble;
import modele.dao.requetes.delete.RequeteDeleteImmeuble;
import modele.dao.requetes.select.RequeteSelectImmeuble;
import modele.dao.requetes.select.RequeteSelectImmeubleById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertImmeuble;
import modele.dao.requetes.update.RequeteUpdateImmeuble;

public class DaoImmeuble extends DaoModele<Immeuble> implements Dao<Immeuble> {

	@Override
	public void create(Immeuble donnees) throws SQLException {
		SousProgramme<Immeuble> sp = new SousProgrammeInsertImmeuble();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Immeuble donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateImmeuble(), donnees);

	}

	@Override
	public void delete(Immeuble donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteImmeuble(), donnees);

	}

	@Override
	public Immeuble findById(String... id) throws SQLException {
		List<Immeuble> immeuble = this.find(new RequeteSelectImmeubleById(), id);
		if (immeuble.isEmpty()) {
			return null;
		}
		return immeuble.get(0);
	}

	@Override
	public List<Immeuble> findAll() throws SQLException {
		return this.find(new RequeteSelectImmeuble());
	}

	@Override
	protected Immeuble creerInstance(ResultSet curseur) throws SQLException {
		Immeuble immeuble = null;
		try {
			immeuble = new Immeuble(curseur.getString("Id_Immeuble"), curseur.getString("adresse"),
					curseur.getString("cp"), curseur.getString("ville"), curseur.getString("periode_construction"),
					 curseur.getString("type_immeuble"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return immeuble;
	}
	
	public List<String> getAllIdImmeuble() throws SQLException {
		List<String> identifiants = new ArrayList<>();

		String sql = "SELECT ID_Immeuble FROM Immeuble";

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
				ResultSet resultSet = st.executeQuery()) {

			while (resultSet.next()) {
				identifiants.add(resultSet.getString("ID_Immeuble"));
			}
			resultSet.close();
		}

		return identifiants;
	}
	

}
