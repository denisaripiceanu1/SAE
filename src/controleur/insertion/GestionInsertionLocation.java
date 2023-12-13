package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionColocataire;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener {

	private Fenetre_InsertionLocation fil;

	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter un colocataire":
			Fenetre_InsertionColocataire fenetreColo = new Fenetre_InsertionColocataire();
			fenetre_Principale.getLayeredPane().add(fenetreColo);
			fenetreColo.setVisible(true);
			fenetreColo.moveToFront();
			break;
		case "Ajouter un bail":
			// un pdf
			break;
		case "Ajouter l'état des lieux":
			importerEtStockerPDF();
			break;
		case "Ajouter":
			// Ajouter le code pour gérer l'ajout de la location
			break;
		case "Annuler":
			this.fil.dispose();
			break;
		}
	}
	
	private void importerEtStockerPDF() {
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
}