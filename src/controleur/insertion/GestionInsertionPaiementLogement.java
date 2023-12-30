package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionEntreprise;
import vue.insertion.Fenetre_InsertionPaiementLogement;

public class GestionInsertionPaiementLogement implements ActionListener {

	private Fenetre_InsertionPaiementLogement fipl;
	private DaoFacture daoFacture;
	private DaoEntreprise daoEntreprise;

	public GestionInsertionPaiementLogement(Fenetre_InsertionPaiementLogement fit) {
		this.fipl = fit;
		this.daoFacture = new DaoFacture();
		this.daoEntreprise = new DaoEntreprise();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton bouton = (JButton) source;
			Fenetre_Accueil fenetrePrincipale = (Fenetre_Accueil) this.fipl.getTopLevelAncestor();

			// Gestion des actions en fonction du bouton cliqué
			switch (bouton.getText()) {
			case "Ajouter":
				Facture facture = null;
				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
				Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

				int imputable = 0;
				if (this.fipl.getRdbtnOui().isSelected()) {
					imputable = 1;
				}
				// Si la désignation de la facture est "Loyer", on insère null pour l'entreprise
				// car celui qui génère la facture c'est le propriétaire du bien
				String selectedDesignation = this.fipl.getComboBox_Designation().getSelectedItem().toString();

				if ("Loyer".equals(selectedDesignation)) {
					try {
						// Création d'un objet Facture à partir des données saisies dans la fenêtre
						facture = new Facture(this.fipl.getTextField_Numero().getText(),
								this.fipl.getTextField_date_emission().getText(),
								this.fipl.getTextField_date_paiement().getText(),
								this.fipl.getComboBox_modePaiement().getSelectedItem().toString(),
								this.fipl.getTextField_numeroDevis().getText(),
								this.fipl.getComboBox_Designation().getSelectedItem().toString(),
								Double.parseDouble(this.fipl.getTextField_accompteVerse().getText()),
								Double.parseDouble(this.fipl.getTextField_montant().getText()), imputable, null,
								bienSauvegarde, null);
						// Enregistrement de la facture dans la base de données
						this.daoFacture.create(facture);
					} catch (Exception e1) {
						e1.printStackTrace();
						System.err.println("Erreur lors de l'ajout de la facture : " + e1.getMessage());
					}
					// Sinon, on crée une facture avec l'entreprise sauvegardée, qu'on a
					// sélectionnée auparavant
				} else {
					try {
						// Création d'un objet Facture à partir des données saisies dans la fenêtre
						facture = new Facture(this.fipl.getTextField_Numero().getText(),
								this.fipl.getTextField_date_emission().getText(),
								this.fipl.getTextField_date_paiement().getText(),
								this.fipl.getComboBox_modePaiement().getSelectedItem().toString(),
								this.fipl.getTextField_numeroDevis().getText(),
								this.fipl.getComboBox_Designation().getSelectedItem().toString(),
								Double.parseDouble(this.fipl.getTextField_accompteVerse().getText()),
								Double.parseDouble(this.fipl.getTextField_montant().getText()), imputable, null,
								bienSauvegarde, entrepriseSauvegarde);
						// Enregistrement de la facture dans la base de données
						this.daoFacture.create(facture);
					} catch (Exception e1) {
						e1.printStackTrace();
						System.err.println("Erreur lors de l'ajout de la facture : " + e1.getMessage());
					}
				}

				this.fipl.dispose(); // Fermeture de la fenêtre d'insertion
				break;

			case "Annuler":
				this.fipl.dispose(); // Fermeture de la fenêtre d'insertion en cas d'annulation
				break;

			case "Charger":
				try {
					this.chargerEntreprise();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			case "Insérer":
				Fenetre_InsertionEntreprise insertionEntreprise = new Fenetre_InsertionEntreprise();
				fenetrePrincipale.getLayeredPane().add(insertionEntreprise);
				insertionEntreprise.setVisible(true);
				insertionEntreprise.moveToFront();
				break;
			}

			// Méthode appelée lorsque l'état de l'élément du JComboBox change
			updateEntrepriseComponents();

		} else if (source instanceof JComboBox) {
			// Traitement spécifique pour le JComboBox
			JComboBox<?> comboBox = (JComboBox<?>) source;
			// Reste du code pour le JComboBox
			updateEntrepriseComponents();
		}
	}

	// Méthode pour mettre à jour les composants liés à l'entreprise en fonction de
	// la désignation
	private void updateEntrepriseComponents() {
		Object selectedObject = this.fipl.getComboBox_Designation().getSelectedItem();

		if (selectedObject != null) {
			String selectedDesignation = selectedObject.toString();

			switch (selectedDesignation) {
			case "Loyer":
				// Masquer les composants liés à l'entreprise pour les autres options
				this.fipl.getBtn_ajouter_entreprise().setVisible(false);
				this.fipl.getBtn_charger_entreprise().setVisible(false);
				this.fipl.getScrollPane_table_entreprise().setVisible(false);
				this.fipl.getTable_entreprise().setVisible(false);
				this.fipl.getLbl_Entreprise().setVisible(false);
				break;
			// Afficher les composants liés à l'entreprise pour d'autres options
			default:
				this.fipl.getBtn_ajouter_entreprise().setVisible(true);
				this.fipl.getBtn_charger_entreprise().setVisible(true);
				this.fipl.getScrollPane_table_entreprise().setVisible(true);
				this.fipl.getTable_entreprise().setVisible(true);
				this.fipl.getLbl_Entreprise().setVisible(true);
				break;
			}
		}
	}

	// Table Entreprise
	public void ecrireLigneTableEntreprise(int numeroLigne, Entreprise e) throws SQLException {
		JTable tableEntreprise = this.fipl.getTable_entreprise();
		DefaultTableModel modeleTable = (DefaultTableModel) tableEntreprise.getModel();

		modeleTable.setValueAt(e.getSiret(), numeroLigne, 0);
		modeleTable.setValueAt(e.getNom(), numeroLigne, 1);
	}

	private void chargerEntreprise() throws SQLException {
		List<Entreprise> entreprises = this.daoEntreprise.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fipl.getTable_entreprise().getModel();

		modeleTable.setRowCount(entreprises.size());

		for (int i = 0; i < entreprises.size(); i++) {
			Entreprise e = entreprises.get(i);
			this.ecrireLigneTableEntreprise(i, e);
		}
	}
}
