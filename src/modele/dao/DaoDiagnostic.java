package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Diagnostics;
import modele.dao.requetes.delete.RequeteDeleteDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnostic;
import modele.dao.requetes.select.RequeteSelectDiagnosticById;
import modele.dao.requetes.select.RequeteSelectDiagnoticByBien;

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

			diagnostic = new Diagnostics(/* curseur.getInt("Id_Diagnostic") */ dateValiditeStr,
					curseur.getString("type_diagnostic"), bien);

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
	

	public List<Diagnostics> findDiagnosticByBien(String... id) throws SQLException {
		return find(new RequeteSelectDiagnoticByBien(), id);
	}

	public Diagnostics findByIdBien(String... id) throws SQLException {
		List<Diagnostics> diagnostic = this.find(new RequeteSelectDiagnoticByBien(), id);
		if (diagnostic.isEmpty()) {
			return null;
		}
		return diagnostic.get(0);
	}

}
