package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreerAnnexe {

    public static void main(String[] args) {

        try {
            OutputStream fileOut = new FileOutputStream("src/annexe2044.docx");
            InputStream modele = new FileInputStream("src/vide.docx");

            XWPFDocument document = new XWPFDocument(modele);

            // Entête de la déclaration
            ajouterUnTitre(document, "Annexe 2044 - Déclaration des Revenus Fonciers de " + LocalDate.now().getYear());

            // Informations des propriétés
            List<Proriétés> propriétés = new ArrayList<>();
            propriétés.add(new Proriétés("Immeuble 1", "[Type1]", "[nom et prenom locataire]", "[Date Acquisition1]", "[Adresse1]"));
            propriétés.add(new Proriétés("Immeuble 2", "[Type2]", "[nom et prenom locataire]", "[Date Acquisition2]", "[Adresse2]"));
            propriétés.add(new Proriétés("Immeuble 3", "[Type3]", "[nom et prenom locataire]", "[Date Acquisition3]", "[Adresse3]"));

            ajouterUnSousTitre(document, "Caractéristiques des propriétés");
            ajouterInfosPropriétés(document, propriétés);

            // Recettes
            List<InfosRecettes> recettes = new ArrayList<>();
            recettes.add(new InfosRecettes("Immeuble 1", "Loyers bruts encaissés", 507));
            recettes.add(new InfosRecettes("Immeuble 2", "Loyers bruts encaissés", 507));
            recettes.add(new InfosRecettes("Immeuble 3", "Loyers bruts encaissés", 507));
            recettes.add(new InfosRecettes("Immeuble 1", "Recettes brutes diverses", 0));

            ajouterUnSousTitre(document, "Recettes");
            ajouterTableRecettes(document, recettes);

            // Frais et charges
            List<FraisCharges> fraisEtCharges = new ArrayList<>();
            fraisEtCharges.add(new FraisCharges("Immeuble 1", "Frais d’administration et de gestion", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 1", "Autres frais de gestion", 20));
            fraisEtCharges.add(new FraisCharges("Immeuble 1", "Primes d’assurance", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 1", "Dépenses de réparation, d’entretien et d’amélioration", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Charges récupérables non récupérées au départ du locataire", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Indemnités d’éviction, frais de relogement", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Taxes foncières, taxes annexes", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Régimes particuliers, déductions spécifiques", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Syndic de copropriété : Provisions pour charges", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 2", "Syndic de copropriété : Régularisation des provisions pour charges déduites au titre de 2023", 0));
            fraisEtCharges.add(new FraisCharges("Immeuble 1", "Intérêts d'emprunt (inc frais et assurances)", 0));

            ajouterUnSousTitre(document, "Frais et charges");
            ajouterTableFraisCharge(document, fraisEtCharges);

            // Résultat foncier
            ajouterUnSousTitre(document, "Résultat Foncier");
            ajouterLigne(document, "420 RÉSULTAT", 487);

            // Fin de la déclaration
            ajouterFooter(document, "Fin de la Déclaration");

            document.write(fileOut);
            fileOut.close();
            modele.close();
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // LES METHODES 
    
    // Méthode pour ajouter un sous titre
    private static void ajouterUnSousTitre(XWPFDocument document, String title) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(14);
        run.setText(title);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(6);
        // Utilisez la méthode setAlignment pour définir l'alignement
        paragraph.setAlignment(ParagraphAlignment.CENTER);
    }

    // Méthode pour ajouter une ligne au document
    private static void addLine(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
    }
    
    // Surcharge
    // Refactoring : méthode pour ajouter une ligne à un document et sa valeur associée
    private static void ajouterLigne(XWPFDocument document, String text, int value) {
        addLine(document, text + "\t" + value);
    }

    // Méthode pour ajouter un titre
    private static void ajouterUnTitre(XWPFDocument document, String title) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setText(title);
        // Utilisez la méthode setAlignment pour définir l'alignement
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(12);
    }

    // Méthode pour ajouter un pied de page au document
    private static void ajouterFooter(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setItalic(true);
        run.setText(text);
        // Utilisez la méthode setAlignment pour définir l'alignement
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(12);
    }

    // Méthode pour ajouter un tableau au document
    private static void addTable(XWPFDocument document, List<String> headers, List<List<String>> data) {
        XWPFTable table = document.createTable();

        XWPFTableRow headerRow = table.getRow(0);
        for (int i = 0; i < headers.size(); i++) {
            XWPFTableCell cell = headerRow.getCell(i);
            if (cell == null) {
                cell = headerRow.createCell();
            }
            cell.setText(headers.get(i));
        }

        for (List<String> rowData : data) {
            XWPFTableRow dataRow = table.createRow();
            for (int i = 0; i < headers.size(); i++) {
                XWPFTableCell cell = dataRow.getCell(i);
                if (cell == null) {
                    cell = dataRow.createCell();
                }
                cell.setText(rowData.get(i));
            }
        }
    }


    // Classe pour stocker les informations des propriétés
    private static class Proriétés {
        private String propertyName;
        private String propertyType;
        private String locataire;
        private String dateAcquisition;
        private String adresse;

        public Proriétés(String propertyName, String propertyType, String locataire, String dateAcquisition, String adresse) {
            this.propertyName = propertyName;
            this.propertyType = propertyType;
            this.locataire = locataire;
            this.dateAcquisition = dateAcquisition;
            this.adresse = adresse;
        }
    }

    // Méthode pour ajouter un tableau d'informations de propriétés au document
    private static void ajouterInfosPropriétés(XWPFDocument document, List<Proriétés> properties) {
        List<String> headers = List.of("Nom de la Propriété", "Type", "Locataire", "Date Acquisition", "Adresse");
        List<List<String>> data = new ArrayList<>();

        for (Proriétés property : properties) {
            List<String> rowData = List.of(property.propertyName, property.propertyType, property.locataire, property.dateAcquisition, property.adresse);
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

    // Classe pour stocker les informations des recettes
    private static class InfosRecettes {
        private String propertyName;
        private String description;
        private int amount;

        public InfosRecettes(String propertyName, String description, int amount) {
            this.propertyName = propertyName;
            this.description = description;
            this.amount = amount;
        }
    }

    // Classe pour stocker les informations des charges
    private static class FraisCharges {
        private String propertyName;
        private String description;
        private int amount;

        public FraisCharges(String propertyName, String description, int amount) {
            this.propertyName = propertyName;
            this.description = description;
            this.amount = amount;
        }
    }

    // Méthode pour ajouter un tableau d'informations de recettes au document
    private static void ajouterTableRecettes(XWPFDocument document, List<InfosRecettes> incomes) {
        List<String> headers = List.of("Nom de la Propriété", "Description", "Montant");
        List<List<String>> data = new ArrayList<>();

        for (InfosRecettes income : incomes) {
            List<String> rowData = List.of(income.propertyName, income.description, String.valueOf(income.amount));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

    // Méthode pour ajouter un tableau d'informations de charges au document
    private static void ajouterTableFraisCharge(XWPFDocument document, List<FraisCharges> expenses) {
        List<String> headers = List.of("Nom de la Propriété", "Description", "Montant");
        List<List<String>> data = new ArrayList<>();

        for (FraisCharges expense : expenses) {
            List<String> rowData = List.of(expense.propertyName, expense.description, String.valueOf(expense.amount));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }
}