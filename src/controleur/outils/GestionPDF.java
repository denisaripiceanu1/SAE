package controleur.outils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GestionPDF {

    private static GestionPDF instance;

    private GestionPDF() {
        // Constructeur privé
    }

    public static GestionPDF getInstance() {
        if (instance == null) {
            instance = new GestionPDF();
        }
        return instance;
    }

    public void importerEtStockerPDF() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File destinationFile = new File("chemin/vers/le/dossier/de/stockage/" + selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // D'autres méthodes liées à la gestion des PDF peuvent être ajoutées ici
}
