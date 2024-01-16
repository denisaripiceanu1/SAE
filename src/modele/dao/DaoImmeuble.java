package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Immeuble;
import modele.Facture;
import rapport.FraisCharges;
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
		st.close();
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
			st.close();
		}

		return identifiants;
	}

	public int getNombreLogementsDansImmeuble(String idImmeuble) throws SQLException {
		int nombreLogements = 0;

		String sql = "SELECT COUNT(*) FROM Bien WHERE Id_Immeuble = ?";

		try (PreparedStatement pstmt = CictOracleDataSource.getConnectionBD().prepareStatement(sql)) {
			pstmt.setString(1, idImmeuble);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					nombreLogements = rs.getInt(1);
				}
				rs.close();
			}
			pstmt.close();
		}

		return nombreLogements;
	}

	public int getSommeLoyersDansImmeublePourPeriode(String idImmeuble, String periodeImpotDebut, String periodeImpotFin) throws SQLException {
	    int sommeLoyers = 0;

	    String sql = "SELECT SUM(f.montant_reel_paye) " +
	                 "FROM Facture f " +
	                 "INNER JOIN Bien b ON f.Id_Bien = b.Id_Bien " +
	                 "WHERE b.Id_Immeuble = ? " +
	                 "  AND f.Designation = 'Loyer' " +
	                 "  AND f.date_emission BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')";

	    try (PreparedStatement pstmt = CictOracleDataSource.getConnectionBD().prepareStatement(sql)) {
	        pstmt.setString(1, idImmeuble);
	        pstmt.setString(2, periodeImpotDebut);
	        pstmt.setString(3, periodeImpotFin);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                sommeLoyers = rs.getInt(1);
	            }
	        }
	    }
 
	    return sommeLoyers;
	}

	public List<FraisCharges> getFraisEtChargesParImmeuble(String idImmeuble, String periodeDebut, String periodeFin) {
	    List<FraisCharges> fraisCharges = new ArrayList<>();

	    // Vous devez ajuster cette requête en fonction de votre modèle de données exact
	    String sql = "SELECT i.Id_Immeuble, f.Designation, SUM(f.Montant) as MontantTotal " +
	                 "FROM Facture f " +
	                 "INNER JOIN Immeuble i ON f.Id_Immeuble = i.Id_immeuble " +
	                 "WHERE i.Id_Immeuble = ? " +
	                 "AND f.Designation IN ('Eau', 'Electricité', 'Électricité', 'Ordures ménagères') " +
	                 "AND f.date_emission BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') " +
	                 "GROUP BY i.Id_immeuble, f.designation";

	    try (PreparedStatement pstmt = CictOracleDataSource.getConnectionBD().prepareStatement(sql)) {
	        pstmt.setString(1, idImmeuble);
	        pstmt.setString(2, periodeDebut);
	        pstmt.setString(3, periodeFin);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                String nomImmeuble = rs.getString("Id_Immeuble");  // Correction du nom de la colonne
	                String designation = rs.getString("Designation");
	                int montantTotal = rs.getInt("MontantTotal");

	                // Créez une instance de FraisCharges et ajoutez-la à la liste
	                fraisCharges.add(new FraisCharges(nomImmeuble, designation, montantTotal));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Gérez l'exception en fonction de vos besoins (relever ou lancer une exception personnalisée, etc.)
	        throw new RuntimeException("Erreur lors de la récupération des frais et charges.", e);
	    }

	    return fraisCharges;
	}



}
