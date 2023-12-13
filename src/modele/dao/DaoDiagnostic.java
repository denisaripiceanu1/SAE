package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Diagnostics;
import modele.dao.requetes.select.RequeteSelectDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnosticById;

public class DaoDiagnostic extends DaoModele<Diagnostics> implements Dao<Diagnostics> {

	@Override
	public void create(Diagnostics donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Diagnostics donnees) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Diagnostics donnees) {
		delete(donnees);

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

			diagnostic = new Diagnostics(/* curseur.getInt("Id_Diagnostic")*/ dateValiditeStr,
					curseur.getString("type_diagnostic"), bien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public Diagnostics findById(String... id) throws SQLException {
		List<Diagnostics> diagnostic = find(new RequeteSelectDiagnosticById(), id);
		if (diagnostic.isEmpty()) {
			return null;
		}
		return diagnostic.get(0);
	}

	@Override
	public List<Diagnostics> findAll() throws SQLException {
		return find(new RequeteSelectDiagnostic());

	}

}
