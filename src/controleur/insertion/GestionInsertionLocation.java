package controleur.insertion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.Bien;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionPDF;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener {

	private Fenetre_InsertionLocation fil;
	private DaoBien daoBien;
	private DaoImmeuble daoImmeuble;

	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
		this.daoBien = new DaoBien();
		this.daoImmeuble = new DaoImmeuble();
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

	public void ecrireLigneTableLogements(int numeroLigne, Bien bien) {
		JTable tableLogements = this.fil.getTable_liste_logements();
		DefaultTableModel modeleTable = (DefaultTableModel) tableLogements.getModel();

		modeleTable.setValueAt(bien.getIdBien(), numeroLigne, 0);

	}

	private void updateTableLogementForBien(String idLogement) throws SQLException {
		List<Bien> biens = this.daoBien.findBiensparImmeuble(idLogement);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fil.getTable_liste_logements().getModel();
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
				GestionPDF insertBail = new GestionPDF(this.fil);
				this.fil.getLayeredPane().add(insertBail);
				insertBail.setVisible(true);
				insertBail.moveToFront();
				break;

			case "Ajouter l'état des lieux":
				GestionPDF insertEtat = new GestionPDF(this.fil);
				this.fil.getLayeredPane().add(insertEtat);
				insertEtat.setVisible(true);
				insertEtat.moveToFront();
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

				break;
			case "Annuler":
				this.fil.dispose();
				break;
			}
		} else if (source instanceof JComboBox) {
			this.filtreLogementByImmeuble();

		}

	}

}
