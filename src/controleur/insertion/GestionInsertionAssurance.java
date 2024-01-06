package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Entreprise;
import modele.Bien;
import modele.Echeance;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoEntreprise;
import modele.dao.DaoEcheance;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionEntreprise;
import vue.modification.Fenetre_ModificationEntreprise;

public class GestionInsertionAssurance implements ActionListener {

	private Fenetre_InsertionAssurance modificationAssurance;
	private DaoAssurance daoAssurance;
	private DaoBien daoBien;
	private DaoEntreprise daoEntreprise;
	private DaoEcheance daoEcheance;

	public GestionInsertionAssurance(Fenetre_InsertionAssurance fia) {
		this.modificationAssurance = fia;
		this.daoAssurance = new DaoAssurance();
		this.daoBien = new DaoBien();
		this.daoEntreprise = new DaoEntreprise();
		this.daoEcheance = new DaoEcheance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationAssurance.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			// Création d'un objet Assurance
			Assurance assurance = null;
			Echeance echeance = null;
			try {
				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
				Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

				// Recherche du Bien par son identifiant
				Bien bien = daoBien.findById(bienSauvegarde.getIdBien());

				// Création de l'objet Assurance avec les données de la fenêtre d'insertion
				assurance = new Assurance(this.modificationAssurance.getTextField_numPolice().getText(),
						Float.parseFloat(this.modificationAssurance.getTextField_montant().getText()), bien,
						entrepriseSauvegarde);

				// Création de l'objet Echeance avec les données de la fenêtre d'insertion
				echeance = new Echeance(assurance, this.modificationAssurance.getTextField_dateEcheance().getText());

				// Appel de la méthode DAO pour l'ajout de l'assurance dans la base de données
				this.daoAssurance.create(assurance);
				this.daoEcheance.create(echeance);
				// Fermeture de la fenêtre d'insertion après l'ajout
				this.modificationAssurance.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;

		case "Annuler":
			// Annulation de l'opération, fermeture de la fenêtre d'insertion
			this.modificationAssurance.dispose();
			break;

		case "Charger":
			try {
				this.chargerEntreprise();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;

		case "Insérer":
			// Ouverture de la fenêtre d'insertion d'entreprise
			Fenetre_InsertionEntreprise insertionEntreprise = new Fenetre_InsertionEntreprise();
			fenetre_Principale.getLayeredPane().add(insertionEntreprise);
			insertionEntreprise.setVisible(true);
			insertionEntreprise.moveToFront();
			break;

		case "Modifier":
			if (Sauvegarde.onSave("Entreprise") == true) {
				Fenetre_ModificationEntreprise modificationEntreprise = new Fenetre_ModificationEntreprise();
				fenetre_Principale.getLayeredPane().add(modificationEntreprise);
				modificationEntreprise.setVisible(true);
				modificationEntreprise.moveToFront();

				// On recupere l'entreprise de la sauvegarde
				Entreprise entrepriseSauvgarde = (Entreprise) Sauvegarde.getItem("Entreprise");
				Entreprise entrepriseCourante;

				try {
					entrepriseCourante = this.daoEntreprise.findById(entrepriseSauvgarde.getSiret());
					modificationEntreprise.getTextField_SIRET().setText(entrepriseCourante.getSiret());
					modificationEntreprise.getTextField_Nom().setText(entrepriseCourante.getNom());
					modificationEntreprise.getTextField_Adresse().setText(entrepriseCourante.getAdresse());
					modificationEntreprise.getTextField_CP().setText(entrepriseCourante.getCp());
					modificationEntreprise.getTextField_Ville().setText(entrepriseCourante.getVille());
					modificationEntreprise.getTextField_Mail().setText(entrepriseCourante.getMail());
					modificationEntreprise.getTextField_Mail().setText(entrepriseCourante.getMail());
					modificationEntreprise.getTextField_Telephone().setText(entrepriseCourante.getTelephone());
					modificationEntreprise.getTextField_IBAN().setText(entrepriseCourante.getIban());

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			}
		}

	}

	// Méthode pour écrire une ligne d'entreprise dans la table d'entreprise
	public void ecrireLigneTableEntreprise(int numeroLigne, Entreprise e) throws SQLException {
		JTable tableEntreprise = this.modificationAssurance.getTable_entreprise();
		DefaultTableModel modeleTable = (DefaultTableModel) tableEntreprise.getModel();

		modeleTable.setValueAt(e.getSiret(), numeroLigne, 0);
		modeleTable.setValueAt(e.getNom(), numeroLigne, 1);
	}

	// Méthode pour charger les entreprises dans la table d'entreprise
	private void chargerEntreprise() throws SQLException {
		List<Entreprise> entreprises = this.daoEntreprise.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.modificationAssurance.getTable_entreprise().getModel();

		modeleTable.setRowCount(entreprises.size());

		for (int i = 0; i < entreprises.size(); i++) {
			Entreprise e = entreprises.get(i);
			this.ecrireLigneTableEntreprise(i, e);
		}
	}
}
