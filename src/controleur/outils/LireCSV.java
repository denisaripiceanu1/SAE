package controleur.outils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import modele.dao.CictOracleDataSource;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertLocataire;

public class LireCSV {

	public LireCSV() {

	}

	public void lireCSV(String chemin) {
		Connection cn = CictOracleDataSource.getConnectionBD();
		SousProgrammeInsertLocataire insertLocataire = new SousProgrammeInsertLocataire();

		try (Reader reader = new FileReader(chemin); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

			for (CSVRecord csvRecord : csvParser) {
				try (PreparedStatement prSt = cn.prepareStatement(insertLocataire.appelSousProgramme())) {
					insertLocataire.parametres(prSt, csvRecord.get(0), // Id_Locataire
							csvRecord.get(1), // Nom
							csvRecord.get(2), // Prenom
							csvRecord.get(3), // Telephone
							csvRecord.get(4), // Mail
							csvRecord.get(5) // Date de naissance
					);
					prSt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
