package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.modification.Fenetre_ModificationBien;
import vue.modification.Fenetre_ModificationCharges;

public class GestionModificationCharges implements ActionListener {

	private Fenetre_ModificationCharges modificationCharge;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionModificationCharges(Fenetre_ModificationCharges modificationCharge) {
		this.modificationCharge = modificationCharge;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationCharge.getTopLevelAncestor(); 
		
		switch (btn.getText()) {
		case "Ajouter un compteur":
			this.idBien = this.modificationCharge.getTextField_IdImmeuble().getText();
			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
			// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
			// créer le compteur
			Immeuble immeubleTemporaire = new Immeuble(this.modificationCharge.getTextField_IdImmeuble().getText(),
					this.modificationCharge.getTextField_adresse().getText(),
					this.modificationCharge.getTextField_codePostal().getText(),
					this.modificationCharge.getTextField_ville().getText(),
					this.modificationCharge.getTextField_periodeDeConstruction().getText(),
					Integer.parseInt(this.modificationCharge.getTextField_nbLogement().getText()),
					this.modificationCharge.getTextField_dateAcquisition().getText(),
					this.modificationCharge.getComboBox_typeDeBien().getSelectedItem().toString());
			// J'ajoute l'immeuble dans la sauvegarde pour réutiliser
			Sauvegarde.deleteItem("Immeuble");
			Sauvegarde.addItem("Immeuble", immeubleTemporaire);
			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
			fenetreCompteur.setVisible(true);
			fenetreCompteur.moveToFront();
			break;
		case "Modifier":

			try {

				Immeuble nouvelImmeuble = new Immeuble(this.modificationCharge.getTextField_IdImmeuble().getText(),
						this.modificationCharge.getTextField_adresse().getText(),
						this.modificationCharge.getTextField_codePostal().getText(),
						this.modificationCharge.getTextField_ville().getText(),
						this.modificationCharge.getTextField_periodeDeConstruction().getText(),
						Integer.parseInt(this.modificationCharge.getTextField_nbLogement().getText()),
						this.modificationCharge.getTextField_dateAcquisition().getText(),
						this.modificationCharge.getComboBox_typeDeBien().getSelectedItem().toString());

				this.daoImmeuble.update(nouvelImmeuble);

				// Si il y a un compteur à ajouter
				if (Sauvegarde.onSave("Compteur")) {
					this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
					Sauvegarde.clearSave();
				}

				this.modificationCharge.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "Annuler":
			this.modificationCharge.dispose();
			break;
		}
	}

	public String getIdBien() {
		return this.idBien;
	}

}
