package controleur.outils;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.dao.CictOracleDataSource;

public class PDFImporter extends JFrame {

    private static PDFImporter instance;
    private String selectedFilePath;  // Attribut pour stocker le chemin du fichier

    private PDFImporter() {
        this.setTitle("PDF Importer");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initializeComponents();
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
            selectedFilePath = selectedFile.getAbsolutePath();  // utilisez getAbsolutePath pour être cohérent
        }
    }

    public String importPDFCheminString() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();  // utilisez getAbsolutePath pour être cohérent
        }
        return null; // Return null if no file is selected
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }
}