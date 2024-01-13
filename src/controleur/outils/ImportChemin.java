package controleur.outils;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportChemin {

	private String selectedFilePath;

	// Renommé pour éviter la confusion avec un constructeur
	public void choisirChemin() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf", "CSV Files", "csv"));

		// Utilisez null comme parent si cette classe n'est pas un composant Swing
		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			selectedFilePath = selectedFile.getAbsolutePath(); // stocke le chemin
		}
	}

	public String getSelectedFilePath() {
		return this.selectedFilePath;
	}
}
