package controleur.outils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LireCSV {
    public static void main(String[] args) {
    	//faut mettre le fichier ou il est stocker la fin .csv (tout le lien)
        String csvFilePath = "";

        try (Reader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
            	// on aura que 2 pour Loyer et id_locatiare
                String loyer = csvRecord.get(0);   // pour recuperer Loyer
                String id = csvRecord.get(1);  // pour l'autre

                System.out.println("Loyer: " + loyer + ", id: " + id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
