package controleur.insertion;

import java.awt.Desktop;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.Assurance;
import modele.Bien;

import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controleur.GestionPDF;
import controleur.outils.PDFImporter;
import controleur.outils.Sauvegarde;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener, MouseListener {

	private Fenetre_InsertionLocation fil;
	private DaoBien daoBien;
	private DaoImmeuble daoImmeuble;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;
	private String bail;
	private String etatLieux;

	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
		this.daoBien = new DaoBien();
		this.daoImmeuble = new DaoImmeuble();
		this.daoLocataire = new DaoLocataire();
		this.daoLouer = new DaoLouer();
		this.bail = " ";
		this.etatLieux = " ";
	}

	public void ecrireLigneTableLogements(int numeroLigne, Bien bien) {
		JTable tableLogements = this.fil.getTable_id_logements();
		DefaultTableModel modeleTable = (DefaultTableModel) tableLogements.getModel();

		modeleTable.setValueAt(bien.getIdBien(), numeroLigne, 0);

	}

	private void updateTableLogementForBien(String idLogement) throws SQLException {
		List<Bien> biens = this.daoBien.findBiensparImmeuble(idLogement);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fil.getTable_id_logements().getModel();
		modeleTable.setRowCount(biens.size());

		for (int i = 0; i < biens.size(); i++) {
			Bien b = biens.get(i);
			this.ecrireLigneTableLogements(i, b);
		}
	}

	private void filtreLogementByImmeuble() {
		JComboBox<String> comboBox_MesBiens = this.fil.getComboBox_bien();
		String idImmeubleSelectionne = (String) comboBox_MesBiens.getSelectedItem(); // Corrected line

		if (!idImmeubleSelectionne.equals("Biens")) {
			try {
				this.updateTableLogementForBien(idImmeubleSelectionne);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton btn = (JButton) source;

			Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor();
			switch (btn.getText()) {

			case "Ajouter un bail":
				try {
					// Appeler importPDFCheminString une fois et stocker le résultat dans
					// cheminOrigineBail
					String cheminOrigineBail = PDFImporter.getInstance().importPDFCheminString();
					this.bail = cheminOrigineBail;
					// Si le cheminOrigine n'est pas vide
					if (cheminOrigineBail != null && !cheminOrigineBail.isEmpty()) {
						// Afficher un message de réussite
						JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
								JOptionPane.INFORMATION_MESSAGE);

						// Mettre à jour le libellé pour permettre l'ouverture du fichier
						fil.getLblBail().setText(cheminOrigineBail);
					} else {
						// Afficher un message d'erreur si aucun fichier n'est sélectionné
						JOptionPane.showMessageDialog(fil, "Aucun fichier PDF sélectionné.", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NullPointerException ex) {
					// Handle the case where the user cancels the file selection
					JOptionPane.showMessageDialog(fil, "Annulation de l'insertion du fichier.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					// Handle other exceptions
					ex.printStackTrace();
				}
				break;

			case "Ajouter l'état des lieux":
				try {
					// Appeler importPDFCheminString une fois et stocker le résultat dans
					// cheminOrigine
					String cheminOrigineEtatLieux = PDFImporter.getInstance().importPDFCheminString();
					this.etatLieux = cheminOrigineEtatLieux;
					// Si le cheminOrigine n'est pas vide
					if (cheminOrigineEtatLieux != null && !cheminOrigineEtatLieux.isEmpty()) {
						// Afficher un message de réussite
						JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
								JOptionPane.INFORMATION_MESSAGE);

						// Mettre à jour le libellé pour permettre l'ouverture du fichier
						fil.getLblNomEtatDesLieux().setText(cheminOrigineEtatLieux);
					} else {
						// Afficher un message d'erreur si aucun fichier n'est sélectionné
						JOptionPane.showMessageDialog(fil, "Aucun fichier PDF sélectionné.", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NullPointerException ex) {
					// Handle the case where the user cancels the file selection
					JOptionPane.showMessageDialog(fil, "Annulation de l'insertion du fichier.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					// Handle other exceptions
					ex.printStackTrace();
				}
				break;

			case "Ajouter":
				Louer location = null;
				try {
					Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");

					Locataire nouveauLocataire = new Locataire(this.fil.getTextField_IdLocataire().getText(),
							this.fil.getTextField_Nom().getText(), this.fil.getTextField_Prenom().getText(),
							this.fil.getTextField_tel().getText(), this.fil.getTextField_e_mail().getText(),
							this.fil.getTextField_Date_de_naissance().getText());

					this.daoLocataire.create(nouveauLocataire);

					location = new Louer(nouveauLocataire, bienSauvegarde,
							this.fil.getTextField_date_arrivee().getText(), 
							0, /* nb de mois */
							Double.parseDouble(this.fil.getTextField_loyer().getText()),
							Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
							Double.parseDouble(this.fil.getTextField_caution().getText()), 
							this.bail, 
							this.etatLieux,
							null, /* date de départ */
							0, /* loyer paye */
							null, /* icc */
							0/* montant reel payé */
					);

					this.daoLouer.create(location);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.fil.dispose();
				break;
			case "Annuler":
				this.fil.dispose();
				break;
			}
		} else if (source instanceof JComboBox) {
			this.filtreLogementByImmeuble();
		}

	}

	public void ouvrirPDF(String label) {
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

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel source = (JLabel) e.getSource();

		if (source == fil.getLblNomEtatDesLieux() || source == fil.getLblBail()) {
			ouvrirPDF(source.getText());
		}
	}

	// PAS UTILISEES mais faut les laiser parce que la fenetre implements MouseListener
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
