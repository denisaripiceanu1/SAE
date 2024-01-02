package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Immeuble;
import modele.Quotite;
import modele.Quotter;
import modele.dao.requetes.delete.RequeteDeleteQuotter;
import modele.dao.requetes.delete.RequeteDeleteQuotterByImmeuble;
import modele.dao.requetes.select.RequeteSelectBienparImmeuble;
import modele.dao.requetes.select.RequeteSelectQuotter;
import modele.dao.requetes.select.RequeteSelectQuotterByBien;
import modele.dao.requetes.select.RequeteSelectQuotterById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertQuotter;

public class DaoQuotter extends DaoModele<Quotter> implements Dao<Quotter> {

	@Override
	public void create(Quotter donnees) throws SQLException {
		SousProgramme<Quotter> sp = new SousProgrammeInsertQuotter();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Quotter donnees) throws SQLException {

	}

	@Override
	public void delete(Quotter donnees) throws SQLException {
		miseAJour(new RequeteDeleteQuotter(), donnees);
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

	public List<Quotter> findQuotterByBien(String id) throws SQLException {
		return this.find(new RequeteSelectQuotterByBien(), id);
	}

	// Y A DES MODIF A FAIRE LAAAAAAAA
	public void deleteByBien(Immeuble immeuble) throws SQLException {
		RequeteDeleteQuotterByImmeuble requete = new RequeteDeleteQuotterByImmeuble();

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectBienparImmeuble().requete())) {
			{
				requete.parametres(st, immeuble.getImmeuble());
				st.executeUpdate();
			}

		}

	}
}
