package controleur.insertion;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.PDFImporter;
import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.ICC;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoICC;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionICC;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener, MouseListener {

	// Attributs
	private Fenetre_InsertionLocation fil;
	private DaoBien daoBien;
	private DaoICC daoICC;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;
	private String bail;
	private String etatLieux;

	// Constructeur
	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
		this.daoBien = new DaoBien();
		this.daoICC = new DaoICC();
		this.daoLocataire = new DaoLocataire();
		this.daoLouer = new DaoLouer();
		this.bail = " ";
		this.etatLieux = " ";
	}

	// Gestion des actions
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton btn = (JButton) source;

			Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor();
			switch (btn.getText()) {
			case "Ajouter un bail":
				try {
					String cheminOrigineBail = PDFImporter.getInstance().importPDFCheminString();
					this.bail = cheminOrigineBail;

					if (cheminOrigineBail != null && !cheminOrigineBail.isEmpty()) {
						JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
								JOptionPane.INFORMATION_MESSAGE);

						fil.getLblBail().setText(cheminOrigineBail);
					} else {
						JOptionPane.showMessageDialog(fil, "Aucun fichier PDF sélectionné.", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(fil, "Annulation de l'insertion du fichier.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;

			case "Ajouter l'état des lieux":
				try {
					String cheminOrigineEtatLieux = PDFImporter.getInstance().importPDFCheminString();
					this.etatLieux = cheminOrigineEtatLieux;

					if (cheminOrigineEtatLieux != null && !cheminOrigineEtatLieux.isEmpty()) {
						JOptionPane.showMessageDialog(fil, "Le fichier a été bien ajouté.", "Succès",
								JOptionPane.INFORMATION_MESSAGE);

						fil.getLblNomEtatDesLieux().setText(cheminOrigineEtatLieux);
					} else {
						JOptionPane.showMessageDialog(fil, "Aucun fichier PDF sélectionné.", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(fil, "Annulation de l'insertion du fichier.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;

			case "Ajouter":
				Louer location = null;
				try {
					Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
					ICC icc = (ICC) Sauvegarde.getItem("ICC");
					Locataire nouveauLocataire = new Locataire(this.fil.getTextField_IdLocataire().getText(),
							this.fil.getTextField_Nom().getText(), this.fil.getTextField_Prenom().getText(),
							this.fil.getTextField_tel().getText(), this.fil.getTextField_e_mail().getText(),
							this.fil.getTextField_Date_de_naissance().getText());

					this.daoLocataire.create(nouveauLocataire);

					location = new Louer(nouveauLocataire, bienSauvegarde,
							this.fil.getTextField_date_arrivee().getText(), 0, // nb de mois
							Double.parseDouble(this.fil.getTextField_loyer().getText()),
							Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
							Double.parseDouble(this.fil.getTextField_caution().getText()), this.bail, this.etatLieux,
							null, // date de départ
							0, // loyer payé
							icc, 0 // montant réel payé
					);

					this.daoLouer.create(location);
				} catch (

				Exception e1) {
					e1.printStackTrace();
				}
				this.fil.dispose();
				break;

			case "Ajouter ICC":
				Fenetre_InsertionICC insertionICC = new Fenetre_InsertionICC();
				fenetre_Principale.getLayeredPane().add(insertionICC);
				insertionICC.setVisible(true);
				insertionICC.moveToFront();
				break;

			case "Charger ICC":
				try {
					this.chargerICC();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			case "Annuler":
				this.fil.dispose();
				break;
			}
		} else if (source instanceof JComboBox) {
			this.filtreLogementByImmeuble();
		}
	}

	// Gestion des clics de souris
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel source = (JLabel) e.getSource();

		if (source == fil.getLblNomEtatDesLieux() || source == fil.getLblBail()) {
			ouvrirPDF(source.getText());
		}
	}

	// Autres méthodes de l'interface MouseListener
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

	// Méthode pour écrire une ligne dans la table de logements
	public void ecrireLigneTableLogements(int numeroLigne, Bien bien) {
		JTable tableLogements = this.fil.getTable_id_logements();
		DefaultTableModel modeleTable = (DefaultTableModel) tableLogements.getModel();

		modeleTable.setValueAt(bien.getIdBien(), numeroLigne, 0);
		// Ajouter d'autres colonnes selon vos besoins
	}

	// Méthode pour mettre à jour la table de logements pour un bien spécifique
	private void updateTableLogementForBien(String idLogement) throws SQLException {
		List<Bien> biens = this.daoBien.findBiensparImmeuble(idLogement);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fil.getTable_id_logements().getModel();
		modeleTable.setRowCount(biens.size());

		for (int i = 0; i < biens.size(); i++) {
			Bien b = biens.get(i);
			this.ecrireLigneTableLogements(i, b);
		}
	}

	// Méthode pour filtrer les logements par immeuble
	private void filtreLogementByImmeuble() {
		JComboBox<String> comboBox_MesBiens = this.fil.getComboBox_bien();
		String idImmeubleSelectionne = (String) comboBox_MesBiens.getSelectedItem();

		if (!idImmeubleSelectionne.equals("Biens")) {
			try {
				this.updateTableLogementForBien(idImmeubleSelectionne);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	// Méthode pour ouvrir un fichier PDF
	public void ouvrirPDF(String label) {
		String cheminFichierPDF = label;
		File fichierPDF = new File(cheminFichierPDF);

		if (fichierPDF.exists()) {
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

	// Méthode pour écrire une ligne dans la table ICC
	public void ecrireLigneTableICC(int numeroLigne, ICC icc) throws SQLException {
		JTable tableImmeuble = this.fil.getTable_liste_ICC();
		DefaultTableModel modeleTable = (DefaultTableModel) tableImmeuble.getModel();

		modeleTable.setValueAt(icc.getAnnee(), numeroLigne, 0);
		modeleTable.setValueAt(icc.getTrimestre(), numeroLigne, 1);
		modeleTable.setValueAt(icc.getIndice(), numeroLigne, 2);
		// Ajouter d'autres colonnes selon vos besoins
	}

	// Méthode pour charger les ICC dans la table
	private void chargerICC() throws SQLException {
		List<ICC> iccs = this.daoICC.findAll();
		DefaultTableModel modeleTable = (DefaultTableModel) this.fil.getTable_liste_ICC().getModel();
		modeleTable.setRowCount(iccs.size());

		for (int i = 0; i < iccs.size(); i++) {
			ICC icc = iccs.get(i);
			this.ecrireLigneTableICC(i, icc);
		}
	}
}