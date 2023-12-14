package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Bien;
import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectBien;
import modele.dao.requetes.select.RequeteSelectBienById;
import modele.dao.requetes.select.RequeteSelectBienparImmeuble;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertBien;
import modele.dao.requetes.update.RequeteUpdateBien;

public class DaoBien extends DaoModele<Bien> implements Dao<Bien> {

	// private static Iterateur<Bien> iterateurBien;

	@Override
	public void create(Bien donnees) throws SQLException {
		SousProgramme<Bien> sp = new SousProgrammeInsertBien();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
	}

	@Override
	public void update(Bien donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateBien(), donnees);
	}

	@Override
	public void delete(Bien donnees) {
		this.delete(donnees);
	}

	@Override
	protected Bien creerInstance(ResultSet curseur) throws SQLException {
		Bien bien = null;
		try {
			// Convertir les dates en chaînes de caractères
			java.sql.Date dateAcquisition = curseur.getDate("date_acquisition");
			String dateAcquisitionStr = dateAcquisition.toString();

			String idImmeuble = curseur.getString("Id_Immeuble");
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			Immeuble immeuble = daoImmeuble.findById(idImmeuble);

			bien = new Bien(curseur.getString("Id_Bien"), curseur.getDouble("surface_habitable"),
					curseur.getInt("nb_pieces"), curseur.getInt("num_etage"), dateAcquisitionStr,
					curseur.getString("type_bien"), immeuble

			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bien;
	}

	@Override
	public Bien findById(String... id) throws SQLException {
		List<Bien> biens = this.find(new RequeteSelectBienById(), id);
		if (biens.isEmpty()) {
			return null;
		}
		return biens.get(0);
	}

	@Override
	public List<Bien> findAll() throws SQLException {
		return this.find(new RequeteSelectBien());
	}

	// ---------------- AUTRES METHODES ----------------//
	
	public List<Bien> findBiensparImmeuble(String id) throws SQLException {
		List<Bien> biens = null;

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectBienparImmeuble().requete())) {
			new RequeteSelectBienparImmeuble().parametres(st, id);
			ResultSet res = st.executeQuery();
			biens = this.convertirResultSetEnListe(res);
			st.close();
		}

		return biens;
	}

	private List<Bien> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Bien> biens = new ArrayList<>();

		while (res.next()) {
			Bien bien = this.creerInstance(res);
			biens.add(bien);
		}
		return biens;
	}

	public List<String> getAllIdBien() throws SQLException {
	    List<String> identifiers = new ArrayList<>();

	    // Remplacez "SELECT id_logement FROM votre_table_logement" par la requête SQL appropriée
	    String sql = "SELECT ID_Bien FROM BIEN";

	    try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
	         ResultSet resultSet = st.executeQuery()) {

	        while (resultSet.next()) {
	            identifiers.add(resultSet.getString("ID_Bien"));
	        }
	    }

	    return identifiers;
	}


	public Iterateur<Bien> findAllIterateur() throws SQLException {
//        RequeteSelectBien req = new RequeteSelectBien();
//        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
//        req.parametres(st);
//        ResultSet res = st.executeQuery();
//
//        iterateurBien = new Iterateur<>(res, this);
//        return DaoBien.iterateurBien;
		return null;
	}
}
