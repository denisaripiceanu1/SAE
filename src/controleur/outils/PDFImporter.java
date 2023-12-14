package controleur.outils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PDFImporter extends JFrame {

    private static PDFImporter instance;
    private static PDFListe pdfListe;

    private PDFImporter() {
        setTitle("PDF Importer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
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
        btnImportPDF.addActionListener(e -> importPDF());

        this.setLayout(new FlowLayout());
        this.add(btnImportPDF);
    }

    private void importPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pdfListe.addPDFFile(selectedFile);
        }
    }
    //panel_MesDocuments.setLayout(new BorderLayout());
    //PDFViewer pdfViewer = new PDFViewer();
    //panel_MesDocuments.add(pdfViewer, BorderLayout.CENTER);
}
