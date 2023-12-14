package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.modification.Fenetre_ModificationBien;

public class GestionModificationBien implements ActionListener {

	private Fenetre_InsertionBien insertionBien;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;
	private DaoBien daoBien;

	public GestionModificationBien(Fenetre_ModificationBien modificationBien) {
		this.insertionBien = this.insertionBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		this.daoBien = new DaoBien();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.insertionBien.getTopLevelAncestor(); // fenetre dans
																											// laquelle
																											// on ouvre
																											// des
																											// internal
																											// frame
		switch (btn.getText()) {
		case "Ajouter un compteur":
			this.idBien = this.insertionBien.getTextField_IdImmeuble().getText();
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
		case "Modifier":
			Immeuble immeubleActuel = (Immeuble) Sauvegarde.getItem("Immeuble");
				immeubleActuel.getTextField_IdImmeuble()
				
			break;
		case "Annuler":
			this.insertionBien.dispose();
			break;
		}
	}

	public String getIdBien() {
		return this.idBien;
	}

}
