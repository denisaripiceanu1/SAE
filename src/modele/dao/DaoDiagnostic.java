package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modele.Bien;
import modele.Diagnostics;
import modele.dao.requetes.delete.RequeteDeleteDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnosticById;
import modele.dao.requetes.select.RequeteSelectDiagnoticByBien;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertDiagnostic;

public class DaoDiagnostic extends DaoModele<Diagnostics> implements Dao<Diagnostics> {

	@Override
	public void create(Diagnostics donnees) throws SQLException {
		// TODO Auto-generated method stub

	}

	// Méthode qui créer l'objet puis récupère son ID depuis la BD juste après la
	// création lorsque c'est une séquence
	public int createAvecSequence(Diagnostics donnees) throws SQLException {
		SousProgramme<Diagnostics> sp = new SousProgrammeInsertDiagnostic();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, donnees, Statement.RETURN_GENERATED_KEYS);
		int idDiagnostic = -1; // Initialiser à une valeur qui ne peut pas être valide
		int ligneInseree = st.executeUpdate();

		if (ligneInseree > 0) {
			// La ligne a été insérée avec succès, récupérer l'ID généré
			ResultSet resultSet = st.getGeneratedKeys();
			if (resultSet.next()) {
				idDiagnostic = resultSet.getInt(1);
			}
		}
		return idDiagnostic;
	}

	@Override
	public void update(Diagnostics donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Diagnostics donnees) throws SQLException {
		this.miseAJour(new RequeteDeleteDiagnostic(), donnees);
	}

	@Override
	protected Diagnostics creerInstance(ResultSet curseur) throws SQLException {
		Diagnostics diagnostic = null;
		try {
			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			// Convertir les dates en chaînes de caractères
			java.sql.Date dateValidite = curseur.getDate("date_validite");
			String dateValiditeStr = dateValidite.toString();

			diagnostic = new Diagnostics(dateValiditeStr, curseur.getString("type_diagnostic"), bien);

			diagnostic.setIdDiagnostic(curseur.getInt("Id_Diagnostic"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public Diagnostics findById(String... id) throws SQLException {
		List<Diagnostics> diagnostic = this.find(new RequeteSelectDiagnosticById(), id);
		if (diagnostic.isEmpty()) {
			return null;
		}
		return diagnostic.get(0);
	}

	@Override
	public List<Diagnostics> findAll() throws SQLException {
		return this.find(new RequeteSelectDiagnostic());
	}

	public List<Diagnostics> findDiagnosticByBien(String id) throws SQLException {
		return this.find(new RequeteSelectDiagnoticByBien(), id);
	}

	public Diagnostics findByIdBien(String... id) throws SQLException {
		List<Diagnostics> diagnostic = this.find(new RequeteSelectDiagnoticByBien(), id);
		if (diagnostic.isEmpty()) {
			return null;
		}
		return diagnostic.get(0);
	}

}
