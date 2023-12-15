package controleur.outils;

import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PDFImporter extends JFrame {

    private static PDFImporter instance;
    private static PDFListe pdfListe;
    private String selectedFilePath;  // Attribut pour stocker le chemin du fichier

    private PDFImporter() {
        this.setTitle("PDF Importer");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initializeComponents();
        pdfListe = new PDFListe();
    }

    public static PDFImporter getInstance() {
        if (instance == null) {
            instance = new PDFImporter();
        }
        return instance;
    }

    private void initializeComponents() {
        JButton btnImportPDF = new JButton("Import PDF");
        btnImportPDF.addActionListener(e -> importPDFChemin());
        this.setLayout(new FlowLayout());
        this.add(btnImportPDF);
    }

    public void importPDFChemin() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedFilePath = selectedFile.getAbsolutePath();  // on stock le chemin pour le mettre dans la bd 
            pdfListe.addPDFFile(selectedFile);  //pour ajouter a la liste de mes document
        }
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }
}
