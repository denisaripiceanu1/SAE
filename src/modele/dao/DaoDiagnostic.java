package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Charge;
import modele.Diagnostic;

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

			diagnostic = new Diagnostic(curseur.getInt("Id_Diagnostic"), curseur.getString("date_validite"),
					curseur.getString("type_diagnostic"), bien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public Diagnostic findById(String... id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diagnostic> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
