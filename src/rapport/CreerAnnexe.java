package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modele.Immeuble;
import modele.dao.DaoImmeuble;
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
            List<Proprietes> proprietes = new ArrayList<>();

            // Utilisez le DAO pour récupérer les immeubles
            DaoImmeuble daoImmeuble = new DaoImmeuble();

            try {
                List<Immeuble> immeubles = daoImmeuble.findAll();

                for (Immeuble immeuble : immeubles) {
                    // Vous pouvez obtenir d'autres informations nécessaires à partir de l'objet Immeuble
                    int nombreLocaux = daoImmeuble.getNombreLogementsDansImmeuble(immeuble.getImmeuble());

                    Proprietes propriete = new Proprietes(immeuble.getImmeuble(), immeuble.getType_immeuble(),
                            immeuble.getPeriodeConstruction(), immeuble.getAdresse(), nombreLocaux);
                    proprietes.add(propriete);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            ajouterUnSousTitre(document, "Caractéristiques des propriétés");
            ajouterInfosProprietes(document, proprietes);

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

    private static class Proprietes {
        private String propertyName;
        private String propertyType;
        private String periodeConstruction;
        private String adresse;
        private int nombreLocaux;

        public Proprietes(String propertyName, String propertyType, String periodeConstruction, String adresse, int nombreLocaux) {
            this.propertyName = propertyName;
            this.propertyType = propertyType;
            this.periodeConstruction = periodeConstruction;
            this.adresse = adresse;
            this.nombreLocaux = nombreLocaux;
        }
    }

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

    private static void ajouterUnSousTitre(XWPFDocument document, String title) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(14);
        run.setText(title);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(6);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
    }

    private static void ajouterLigne(XWPFDocument document, String text, int value) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text + "\t" + value);
    }

    private static void ajouterUnTitre(XWPFDocument document, String title) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setText(title);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(12);
    }

    private static void ajouterFooter(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setItalic(true);
        run.setText(text);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setSpacingBefore(12);
        paragraph.setSpacingAfter(12);
    }

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

    private static void ajouterInfosProprietes(XWPFDocument document, List<Proprietes> properties) {
        List<String> headers = List.of("Nom de la Propriété", "Type", "Période de Construction", "Adresse", "Nombre de Locaux");
        List<List<String>> data = new ArrayList<>();

        for (Proprietes property : properties) {
            List<String> rowData = List.of(property.propertyName, property.propertyType, property.periodeConstruction, property.adresse, String.valueOf(property.nombreLocaux));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

    private static void ajouterTableRecettes(XWPFDocument document, List<InfosRecettes> incomes) {
        List<String> headers = List.of("Nom de la Propriété", "Description", "Montant");
        List<List<String>> data = new ArrayList<>();

        for (InfosRecettes income : incomes) {
            List<String> rowData = List.of(income.propertyName, income.description, String.valueOf(income.amount));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

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