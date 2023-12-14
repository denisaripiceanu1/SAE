package controleur.modification;

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
import vue.modification.Fenetre_ModificationBien;

public class GestionModificationBien implements ActionListener {

	private Fenetre_ModificationBien modificationBien;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionModificationBien(Fenetre_ModificationBien modificationBien) {
		this.modificationBien = modificationBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationBien.getTopLevelAncestor(); // fenetre dans
																											// laquelle
																											// on ouvre
																											// des
																											// internal
																											// frame
		switch (btn.getText()) {
		case "Ajouter un compteur":
			this.idBien = this.modificationBien.getTextField_IdImmeuble().getText();
			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
			// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
			// créer le compteur
			Immeuble immeubleTemporaire = new Immeuble(this.modificationBien.getTextField_IdImmeuble().getText(),
					this.modificationBien.getTextField_adresse().getText(),
					this.modificationBien.getTextField_codePostal().getText(),
					this.modificationBien.getTextField_ville().getText(),
					this.modificationBien.getTextField_periodeDeConstruction().getText(),
					Integer.parseInt(this.modificationBien.getTextField_nbLogement().getText()),
					this.modificationBien.getTextField_dateAcquisition().getText(),
					this.modificationBien.getComboBox_typeDeBien().getSelectedItem().toString());
			// J'ajoute l'immeuble dans la sauvegarde pour réutiliser
			Sauvegarde.deleteItem("Immeuble");
			Sauvegarde.addItem("Immeuble", immeubleTemporaire);
			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
			fenetreCompteur.setVisible(true);
			fenetreCompteur.moveToFront();
			break;
		case "Modifier":
			
			try {
				
				Immeuble nouvelImmeuble = new Immeuble(
						this.modificationBien.getTextField_IdImmeuble().getText(),
						this.modificationBien.getTextField_adresse().getText(), 
						this.modificationBien.getTextField_codePostal().getText(), 
						this.modificationBien.getTextField_ville().getText(), 
						this.modificationBien.getTextField_periodeDeConstruction().getText(), 
						Integer.parseInt(this.modificationBien.getTextField_nbLogement().getText()),
						this.modificationBien.getTextField_dateAcquisition().getText(),
						this.modificationBien.getComboBox_typeDeBien().getSelectedItem().toString()
				);
				
				this.daoImmeuble.update(nouvelImmeuble);
				
				//Si il y a un compteur à ajouter
				if(Sauvegarde.onSave("Compteur")) {
					this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
					Sauvegarde.clearSave();
				}
				
				this.modificationBien.dispose(); //Fermer la page après l'ajout
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
			break;
		case "Annuler":
			this.modificationBien.dispose();
			break;
		}
	}

	public String getIdBien() {
		return this.idBien;
	}

}
