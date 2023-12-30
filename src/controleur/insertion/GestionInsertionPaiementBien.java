package controleur.insertion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.Immeuble;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionEntreprise;
import vue.insertion.Fenetre_InsertionPaiementBien;

public class GestionInsertionPaiementBien implements ActionListener {

	private Fenetre_InsertionPaiementBien fipb;
	private DaoFacture daoFacture;
	private DaoEntreprise daoEntreprise;

	public GestionInsertionPaiementBien(Fenetre_InsertionPaiementBien fenetre_InsertionPaiementBien) {
		this.fipb = fenetre_InsertionPaiementBien;
		this.daoFacture = new DaoFacture();
		this.daoEntreprise = new DaoEntreprise();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fipb.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter":
			Facture facture = null;
			Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
			Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");
			System.out.println("entrepriseSauvegarde: " + entrepriseSauvegarde);
			System.out.println("Facture avant création: " + facture);

			int imputable = 0;
			if (this.fipb.getRdbtnOui().isSelected()) {
				imputable = 1;
			}

			try {
				// Création d'un objet Facture à partir des données saisies dans la fenêtre
				facture = new Facture(this.fipb.getTextField_Numero().getText(),
						this.fipb.getTextField_date_emission().getText(),
						this.fipb.getTextField_date_paiement().getText(),
						this.fipb.getComboBox_modePaiement().getSelectedItem().toString(),
						this.fipb.getTextField_numeroDevis().getText(),
						this.fipb.getComboBox_Designation().getSelectedItem().toString(),
						Double.parseDouble(this.fipb.getTextField_accompteVerse().getText()),
						Double.parseDouble(this.fipb.getTextField_montant().getText()), imputable, null, bienSauvegarde,
						entrepriseSauvegarde);
				// Enregistrement de la facture dans la base de données
				this.daoFacture.create(facture);
			} catch (Exception e1) {
				e1.printStackTrace();
				System.err.println("Erreur lors de l'ajout de la facture : " + e1.getMessage());
			}

			break;
		case "Annuler":
			this.fipb.dispose();
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
			fenetre_Principale.getLayeredPane().add(insertionEntreprise);
			insertionEntreprise.setVisible(true);
			insertionEntreprise.moveToFront();
			break;

		}
	}

	// Table Entreprise
	public void ecrireLigneTableEntreprise(int numeroLigne, Entreprise e) throws SQLException {
		JTable tableEntreprise = this.fipb.getTable_entreprise();
		DefaultTableModel modeleTable = (DefaultTableModel) tableEntreprise.getModel();

		modeleTable.setValueAt(e.getSiret(), numeroLigne, 0);
		modeleTable.setValueAt(e.getNom(), numeroLigne, 1);
	}

	private void chargerEntreprise() throws SQLException {
		List<Entreprise> entreprises = this.daoEntreprise.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fipb.getTable_entreprise().getModel();

		modeleTable.setRowCount(entreprises.size());

		for (int i = 0; i < entreprises.size(); i++) {
			Entreprise e = entreprises.get(i);
			this.ecrireLigneTableEntreprise(i, e);
		}
	}
}