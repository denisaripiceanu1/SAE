package controleur.insertion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionBien implements ActionListener {

	private Fenetre_InsertionBien insertionBien;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionInsertionBien(Fenetre_InsertionBien insertionBien) {
		this.insertionBien = insertionBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.insertionBien.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter un compteur":
			this.idBien = insertionBien.getTextField_IdImmeuble().getText();
			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
			// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
			// créer le compteur
			Immeuble immeubleTemporaire = new Immeuble(this.insertionBien.getTextField_IdImmeuble().getText(),
					this.insertionBien.getTextField_adresse().getText(),
					this.insertionBien.getTextField_codePostal().getText(),
					this.insertionBien.getTextField_ville().getText(),
					this.insertionBien.getTextField_periodeDeConstruction().getText(),
					Integer.parseInt(this.insertionBien.getTextField_nbLogement().getText()),
					this.insertionBien.getTextField_dateAcquisition().getText(),
					this.insertionBien.getComboBox_typeDeBien().getSelectedItem().toString());
			// J'ajoute l'immeuble dans la sauvegarde pour réutiliser
			Sauvegarde.deleteItem("Immeuble");
			Sauvegarde.addItem("Immeuble", immeubleTemporaire);
			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
			fenetreCompteur.setVisible(true);
			fenetreCompteur.moveToFront();
			break;
		case "Ajouter":
			try {

				Immeuble nouvelImmeuble = new Immeuble(this.insertionBien.getTextField_IdImmeuble().getText(),
						this.insertionBien.getTextField_adresse().getText(),
						this.insertionBien.getTextField_codePostal().getText(),
						this.insertionBien.getTextField_ville().getText(),
						this.insertionBien.getTextField_periodeDeConstruction().getText(),
						Integer.parseInt(this.insertionBien.getTextField_nbLogement().getText()),
						this.insertionBien.getTextField_dateAcquisition().getText(),
						this.insertionBien.getComboBox_typeDeBien().getSelectedItem().toString());

				this.daoImmeuble.create(nouvelImmeuble);

				if (Sauvegarde.onSave("Compteur")) {
					this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
					Sauvegarde.clearSave();
				}
				this.insertionBien.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "Annuler":
			this.insertionBien.dispose();
			break;
		}
	}

	public String getIdBien() {
		return idBien;
	}

}
