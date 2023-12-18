package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.outils.PDFImporter;
import modele.Bien;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoLocataire;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.outils.PDFImporter;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionColocataire;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener {

	private Fenetre_InsertionLocation fil;
	private PDFImporter gestionPDF;

	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
//		// Ajoutez un gestionnaire d'événements à lblNomEtatDesLieux
//		this.fil.getLblNomEtatDesLieux().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ouvrirPDF(fil.getLblNomEtatDesLieux().getText());
//			}
//		});
//
//		// Ajoutez un gestionnaire d'événements à lblNomBail
//		this.fil.getLblBail().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ouvrirPDF(fil.getLblBail().getText());
//			}
//		});
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
			this.gestionPDF.getInstance().importPDFChemin();
			try {
				// Appeler importPDFCheminString une fois et stocker le résultat dans
				// cheminOrigine
				String cheminOrigine = PDFImporter.getInstance().importPDFCheminString();

				// Si aucune exception n'est levée, cela indique le succès
				// Afficher un message de réussite
				JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
						JOptionPane.INFORMATION_MESSAGE);

				// Mettre à jour le libellé pour permettre l'ouverture du fichier
				fil.getLblBail().setText(cheminOrigine);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;

		case "Ajouter l'état des lieux":
			try {
				// Appeler importPDFCheminString une fois et stocker le résultat dans
				// cheminOrigine
				String cheminOrigine = PDFImporter.getInstance().importPDFCheminString();

				// Si aucune exception n'est levée, cela indique le succès
				// Afficher un message de réussite
				JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
						JOptionPane.INFORMATION_MESSAGE);

				// Mettre à jour le libellé pour permettre l'ouverture du fichier
				fil.getLblNomEtatDesLieux().setText(cheminOrigine);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;

		case "Ajouter":
			Louer location = null;
			try {
				DaoBien daoBien = new DaoBien();
				Bien bien = daoBien.findById(null);

				DaoLocataire daoLocataire = new DaoLocataire();
				Locataire locataire = daoLocataire.findById(null);

//				location = new Louer (
//						locataire,
//						bien,
//						this.fil.getTextField_date_arrivee().getText(),
//						null,/*nb de mois*/
//						Double.parseDouble(this.fil.getTextField_loyer().getText()),
//						Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
//						Double.parseDouble(this.fil.getTextField_caution().getText()),
//						bail,/*bail*/
//						etatLieux,/*etat des lieux*/
//						null,/*date de départ*/
//						null, /* loyer paye*/
//						this.fil.getTable_liste_locataires().getModel().getRowCount(),
//						null,/*montant reel payé*/
//						null,/*trimestre*/
//						null/*année*/
//						);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
//			Louer location = null;
//			try {
//				DaoBien daoBien = new DaoBien();
//				Bien bien = daoBien.findById(null);
//
//				DaoLocataire daoLocataire = new DaoLocataire();
//				Locataire locataire = daoLocataire.findById(null);
//
//				location = new Louer(locataire, bien, this.fil.getTextField_date_arrivee().getText(), null, /*
//																											 * nb de
//																											 * mois
//																											 */
//						Double.parseDouble(this.fil.getTextField_loyer().getText()),
//						Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
//						Double.parseDouble(this.fil.getTextField_caution().getText()), null, /* bail */
//						null, /* etat des lieux */
//						null, /* date de départ */
//						null, /* loyer paye */
//						this.fil.getTable_liste_locataires().getModel().getRowCount(), null, /* montant reel payé */
//						null, /* trimestre */
//						null/* année */
//				);
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
			break;
		case "Annuler":
			this.fil.dispose();
			break;
		}
	}

	private void ouvrirPDF(String label) {
		// Récupérer le chemin complet du fichier PDF à partir du texte de l'étiquette
		String cheminFichierPDF = label;

		// Vérifier si le fichier existe
		File fichierPDF = new File(cheminFichierPDF);

		if (fichierPDF.exists()) {
			// Ouvrez le fichier PDF
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(fichierPDF);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(fil, "Erreur lors de l'ouverture du fichier PDF : " + ex.getMessage(),
						"Erreur", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(fil, "Le fichier PDF n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}
