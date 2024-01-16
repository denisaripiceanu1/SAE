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
    
    private static void ajouterResultatFoncier(XWPFDocument document, int resultatFoncier) {
        CreerAnnexe.ajouterUnSousTitre(document, "Résultat Foncier");
        CreerAnnexe.ajouterLigne(document, "RÉSULTAT", resultatFoncier);
    }

    public static void main(String[] args) {

        try {
            OutputStream fileOut = new FileOutputStream("src/annexe2044.docx");
            InputStream modele = new FileInputStream("src/vide.docx");

            XWPFDocument document = new XWPFDocument(modele);

            // Entête de la déclaration
            CreerAnnexe.ajouterUnTitre(document, "Annexe 2044 - Déclaration des Revenus Fonciers de " + LocalDate.now().getYear());

            // Informations
            List<Proprietes> proprietes = new ArrayList<>();
            List<InfosRecettes> recettes = new ArrayList<>();
            List<FraisCharges> fraisEtCharges = new ArrayList<>();
            
            // Utilisez le DAO pour récupérer les immeubles
            DaoImmeuble daoImmeuble = new DaoImmeuble();

            try {
                List<Immeuble> immeubles = daoImmeuble.findAll();

                for (Immeuble immeuble : immeubles) {
                    // Vous pouvez obtenir d'autres informations nécessaires à partir de l'objet Immeuble
                    int nombreLocaux = daoImmeuble.getNombreLogementsDansImmeuble(immeuble.getImmeuble());
                    
                    // Calcule du total des loyers dans l'immeuble
                    int sommeLoyers = daoImmeuble.getSommeLoyersDansImmeublePourPeriode(immeuble.getImmeuble(), (LocalDate.now().getYear()-1)+"-05-01", LocalDate.now().getYear()+"-05-31");
                    
                    List<FraisCharges> fraisEtChargesImmeuble = daoImmeuble.getFraisEtChargesParImmeuble(immeuble.getImmeuble(), (LocalDate.now().getYear()-1)+"-05-01", LocalDate.now().getYear()+"-05-31");
                    
                    Proprietes propriete = new Proprietes(
                            immeuble.getImmeuble(),
                            immeuble.getType_immeuble(),
                            immeuble.getPeriodeConstruction(),
                            immeuble.getAdresse(),
                            nombreLocaux,
                            sommeLoyers
                    );
                    proprietes.add(propriete);
                    recettes.add(new InfosRecettes(immeuble.getImmeuble(), "Loyers bruts encaissés", sommeLoyers));
                    fraisEtCharges.addAll(fraisEtChargesImmeuble);
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ajouterUnSousTitre(document, "Caractéristiques des propriétés");
            ajouterInfosProprietes(document, proprietes);

          
            ajouterUnSousTitre(document, "Recettes");
            ajouterTableRecettes(document, recettes);

            
            ajouterUnSousTitre(document, "Frais et charges");
            ajouterTableFraisCharge(document, fraisEtCharges);
            
            int resultatFoncier = calculerResultatFoncier(recettes, fraisEtCharges);
            ajouterResultatFoncier(document, resultatFoncier);

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
            List<String> rowData = List.of(property.getPropertyName(), property.getPropertyType(), property.getPeriodeConstruction(),
            		property.getAdresse(), String.valueOf(property.getNombreLocaux()));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

    private static void ajouterTableRecettes(XWPFDocument document, List<InfosRecettes> incomes) {
        List<String> headers = List.of("Nom de la Propriété", "Description", "Montant");
        List<List<String>> data = new ArrayList<>();

        for (InfosRecettes income : incomes) {
            List<String> rowData = List.of(income.getPropertyName(), income.getDescription(), String.valueOf(income.getAmount()));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }

    private static void ajouterTableFraisCharge(XWPFDocument document, List<FraisCharges> expenses) {
        List<String> headers = List.of("Nom de la Propriété", "Description", "Montant");
        List<List<String>> data = new ArrayList<>();

        for (FraisCharges expense : expenses) {
            List<String> rowData = List.of(expense.getPropertyName(), expense.getDescription(), String.valueOf(expense.getAmount()));
            data.add(rowData);
        }

        addTable(document, headers, data);
    }
    
    private static int calculerResultatFoncier(List<InfosRecettes> recettes, List<FraisCharges> fraisEtCharges) {
        // Logique de calcul du résultat foncier
        int totalRecettes = recettes.stream().mapToInt(InfosRecettes::getAmount).sum();
        int totalCharges = fraisEtCharges.stream().mapToInt(FraisCharges::getAmount).sum();
        return totalRecettes - totalCharges;
    }
}
