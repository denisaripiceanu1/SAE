package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Diagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnosticById;

public class DaoDiagnostic extends DaoModele<Diagnostic> implements Dao<Diagnostic> {

	@Override
	public void create(Diagnostic donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Diagnostic donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Diagnostic donnees) {
		delete(donnees);

	}

	@Override
	protected Diagnostic creerInstance(ResultSet curseur) throws SQLException {
		Diagnostic diagnostic = null;
		try {
			// Récupérer l'identifiant du Bien
			String idBien = curseur.getString("Id_Bien");
			DaoBien daoBien = new DaoBien();
			Bien bien = daoBien.findById(idBien);

			// Convertir les dates en chaînes de caractères
			java.sql.Date dateValidite = curseur.getDate("date_validite");
			String dateValiditeStr = dateValidite.toString();

			diagnostic = new Diagnostic(curseur.getInt("Id_Diagnostic"), dateValiditeStr,
					curseur.getString("type_diagnostic"), bien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public Diagnostic findById(String... id) throws SQLException {
		List<Diagnostic> diagnostic = find(new RequeteSelectDiagnosticById(), id);
		if (diagnostic.isEmpty()) {
			return null;
		}
		return diagnostic.get(0);
	}

	@Override
	public List<Diagnostic> findAll() throws SQLException {
		return find(new RequeteSelectDiagnostic());

	}

}
