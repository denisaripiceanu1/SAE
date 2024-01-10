package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Immeuble;
import modele.dao.DaoCompteur;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageCompteursBien;
import vue.insertion.Fenetre_InsertionEntreprise;
import vue.insertion.Fenetre_InsertionPaiementBien;

public class GestionAffichageCompteurs implements ActionListener {
	
	private Fenetre_AffichageCompteursBien facb;
	private DaoCompteur daoCompteur;

	// Constructeur prenant en paramètre la fenêtre d'affichage des compteurs
	public GestionAffichageCompteurs(Fenetre_AffichageCompteursBien fenetre_AffichageCompteursBiens) {
		this.facb = fenetre_AffichageCompteursBiens;
		// Initialisation de l'accès à la base de données pour l'entité Entreprise
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.facb.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter un relevé":
			Facture facture = null;
			Immeuble immeubleSauvegarde = (Immeuble) Sauvegarde.getItem("Immeuble");
			Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

			int imputable = 0;
			if (this.facb.getRdbtnOui().isSelected()) {
				imputable = 1;
			}

			try {
				// Création d'un objet Facture à partir des données saisies dans la fenêtre
				facture = new Facture(this.facb.getTextField_Numero().getText(),
						this.facb.getTextField_date_emission().getText(),
						this.facb.getTextField_date_paiement().getText(),
						this.facb.getComboBox_modePaiement().getSelectedItem().toString(),
						this.facb.getTextField_numeroDevis().getText(),
						this.facb.getComboBox_Designation().getSelectedItem().toString(),
						Double.parseDouble(this.facb.getTextField_accompteVerse().getText()),
						Double.parseDouble(this.facb.getTextField_montant().getText()), imputable, immeubleSauvegarde,
						null, entrepriseSauvegarde);
				// Enregistrement de la facture dans la base de données
				this.daoFacture.create(facture);
			} catch (Exception e1) {
				e1.printStackTrace();
				System.err.println("Erreur lors de l'ajout de la facture : " + e1.getMessage());
			}

			this.facb.dispose(); // Fermeture de la fenêtre d'insertion
			break;

		case "Annuler":
			this.facb.dispose();
			break;
		}
	}

	// Méthode pour écrire une ligne d'entreprise dans la table d'entreprise
	public void ecrireLigneTableCompteurs(int numeroLigne, Entreprise e) throws SQLException {
		JTable tableEntreprise = this.fipb.getTable_entreprise();
		DefaultTableModel modeleTable = (DefaultTableModel) tableEntreprise.getModel();

		modeleTable.setValueAt(e.getSiret(), numeroLigne, 0);
		modeleTable.setValueAt(e.getNom(), numeroLigne, 1);
	}

	// Méthode pour charger les entreprises dans la table d'entreprise
	public void chargerCompteurs() throws SQLException {
		List<Entreprise> entreprises = this.daoEntreprise.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fipb.getTable_entreprise().getModel();

		modeleTable.setRowCount(entreprises.size());

		for (int i = 0; i < entreprises.size(); i++) {
			Entreprise e = entreprises.get(i);
			this.ecrireLigneTableEntreprise(i, e);
		}
	}

}
