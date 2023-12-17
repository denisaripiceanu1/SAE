package controleur.outils;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
            selectedFilePath = selectedFile.getAbsolutePath();  // on stock le chemin pour le mettre dans la bd 
        }
    }

    public String importPDFCheminString() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null; // Return null if no file is selected
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }
    
    public void importPDFBD(int id,String nom) throws FileNotFoundException, SQLException {
    	
    	Connection cn = CictOracleDataSource.getConnectionBD();
    	
        String sql = "INSERT INTO documents (id, nom, fichier_pdf) VALUES (?, ?, ?)";
        PreparedStatement pstmt = cn.prepareStatement(sql);

        File pdfFile = new File(this.getSelectedFilePath());
        FileInputStream input = new FileInputStream(pdfFile);

        pstmt.setInt(1, id);
        pstmt.setString(2, nom);
        pstmt.setBinaryStream(3, input, (int) pdfFile.length());
        pstmt.executeUpdate();
        pstmt.close();
    }
}
