package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Immeuble;
import modele.dao.requetes.select.RequeteSelectBien;
import modele.dao.requetes.select.RequeteSelectBienById;
import modele.dao.requetes.update.RequeteUpdateBien;

public class DaoBien extends DaoModele<Bien> implements Dao<Bien> {

	// private static Iterateur<Bien> iterateurBien;

	@Override
	public void create(Bien donnees) {
//		SousProgramme<Bien> sp = new SpAjoutBien();
//		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
//		sp.parametres(st, data);
//		st.execute();

	}

	@Override
	public void update(Bien donnees) throws SQLException {
		miseAJour(new RequeteUpdateBien(), donnees);
	}

	@Override
	public void delete(Bien donnees) {
		delete(donnees);
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
		List<Bien> biens = find(new RequeteSelectBienById(), id);
		if (biens.isEmpty()) {
			return null;
		}
		return biens.get(0);
	}

	@Override
	public List<Bien> findAll() throws SQLException {
		return find(new RequeteSelectBien());
	}
//	@Override
//	public Iterateur<Bien> findAllIterateur() throws SQLException {
//        RequeteSelectBien req = new RequeteSelectBien();
//        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
//        req.parametres(st);
//        ResultSet res = st.executeQuery();
//
//        iterateurBien = new Iterateur<>(res, this);
//        return DaoBien.iterateurBien;
//    }
}
