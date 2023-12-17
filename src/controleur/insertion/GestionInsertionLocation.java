package controleur.insertion;

import java.awt.event.ActionEvent;
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
			try {
				// Appeller importPDFCheminString une fois et stockez le résultat dans
				// selectedFilePath
				String bail = PDFImporter.getInstance().importPDFCheminString();

				// Définisser le texte de lblBien avec le nom du fichier
				fil.getLblBail().setText("Bail : " + new File(bail).getName());

				// Si aucune exception n'est levée, cela indique le succès
				// Affichez un message de réussite
				JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;
		case "Ajouter l'état des lieux":
			try {
				// Appeller importPDFCheminString une fois et stockez le résultat dans
				// selectedFilePath
				String etatLieux = PDFImporter.getInstance().importPDFCheminString();

				// Définisser le texte de lblNomEtatDesLieux avec le nom du fichier
				fil.getLblNomEtatDesLieux().setText("État des lieux : " + new File(etatLieux).getName());

				// Si aucune exception n'est levée, cela indique le succès
				// Affichez un message de réussite
				JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
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
//						null,/*bail*/
//						null,/*etat des lieux*/
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
}