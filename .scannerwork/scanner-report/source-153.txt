package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Bien;
import modele.Immeuble;
import modele.dao.requetes.delete.RequeteDeleteBien;
import modele.dao.requetes.select.RequeteSelectBien;
import modele.dao.requetes.select.RequeteSelectBienById;
import modele.dao.requetes.select.RequeteSelectBienparImmeuble;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertBien;
import modele.dao.requetes.update.RequeteUpdateBien;

public class DaoBien extends DaoModele<Bien> implements Dao<Bien> {

	/**
	 * Méthode qui crée un étatAppelable pour insérer un nouveau bien dans la
	 * base de données depuis les sous-programmes.
	 */
	@Override
	public void create(Bien donnees) throws SQLException {
		SousProgramme<Bien> sp = new SousProgrammeInsertBien();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees);
		st.execute();
		st.close();
	}

	/**
	 * Méthode qui permet de modifier les valeurs d'un bien dans la base de données
	 * depuis une requête des sous-programmes.
	 */
	@Override
	public void update(Bien donnees) throws SQLException {
		this.miseAJour(new RequeteUpdateBien(), donnees);
	}

	/**
	 * Méthode qui permet de supprimer un bien dans la base de données depuis une
	 * requête des sous-programmes.
	 */
	@Override
	public void delete(Bien donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteBien(), donnees);
	}

	/**
	 * Méthode qui crée une instance de Bien à partir du curseur d'une requête dans
	 * la base de données.
	 */
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
					curseur.getString("type_bien"), immeuble);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bien;
	}

	/**
	 * Méthode qui renvoie un Bien en fonction de son ID depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public Bien findById(String... id) throws SQLException {
		List<Bien> biens = this.find(new RequeteSelectBienById(), id);
		if (biens.isEmpty()) {
			return null;
		}
		return biens.get(0);
	}

	/**
	 * Méthode qui renvoie la liste de tous les biens depuis les requêtes des
	 * sous-programmes.
	 */
	@Override
	public List<Bien> findAll() throws SQLException {
		return this.find(new RequeteSelectBien());
	}

	// ---------------- AUTRES METHODES ----------------//

	/**
	 * Méthode qui renvoie un Bien en fonction de l'ID d'un immeuble qui lui est
	 * associé depuis les requêtes des sous-programmes.
	 */
	public Bien findBienByImmeubleObject(String id) throws SQLException {
		List<Bien> biens = this.find(new RequeteSelectBienparImmeuble(), id);
		if (biens.isEmpty()) {
			return null;
		}
		return biens.get(0);
	}

	/**
	 * Méthode qui renvoie une liste de biens en fonction de l'ID d'un immeuble qui
	 * leur est associé depuis les requêtes des sous-programmes.
	 */
	public List<Bien> findBiensparImmeuble(String id) throws SQLException {
		List<Bien> biens = null;

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
				.prepareStatement(new RequeteSelectBienparImmeuble().requete())) {
			new RequeteSelectBienparImmeuble().parametres(st, id);
			ResultSet res = st.executeQuery();
			biens = this.convertirResultSetEnListe(res);
		}

		return biens;
	}

	/**
	 * Méthode privée qui convertit un ResultSet en une liste de biens.
	 */
	private List<Bien> convertirResultSetEnListe(ResultSet res) throws SQLException {
		List<Bien> biens = new ArrayList<>();

		while (res.next()) {
			Bien bien = this.creerInstance(res);
			biens.add(bien);
		}
		return biens;
	}

	/**
	 * Méthode qui renvoie la liste de tous les identifiants de bien depuis la
	 * base de données.
	 */
	public List<String> getAllIdBien() throws SQLException {
		List<String> identifiants = new ArrayList<>();

		String sql = "SELECT ID_Bien FROM BIEN";

		try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
				ResultSet resultSet = st.executeQuery()) {

			while (resultSet.next()) {
				identifiants.add(resultSet.getString("ID_Bien"));
			}
		}

		return identifiants;
	}

}
