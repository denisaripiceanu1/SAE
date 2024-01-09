package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationLogement;

public class GestionModificationLogement implements ActionListener {

	private Fenetre_ModificationLogement modificationLogement;
	private DaoBien daoBien;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionModificationLogement(Fenetre_ModificationLogement modificationLogement) {
		this.modificationLogement = modificationLogement;
		this.daoBien = new DaoBien();
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationLogement.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter un compteur":
//			this.idBien = this.modificationLogement.getTextField_IdImmeuble().getText();
//			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
//			// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
//			// créer le compteur
//			Immeuble immeubleTemporaire = new Immeuble(this.modificationLogement.getTextField_IdImmeuble().getText(),
//					this.modificationLogement.getTextField_adresse().getText(),
//					this.modificationLogement.getTextField_codePostal().getText(),
//					this.modificationLogement.getTextField_ville().getText(),
//					this.modificationLogement.getTextField_periodeDeConstruction().getText(),
//					Integer.parseInt(this.modificationLogement.getTextField_nbLogement().getText()),
//					this.modificationLogement.getTextField_dateAcquisition().getText(),
//					this.modificationLogement.getComboBox_typeDeBien().getSelectedItem().toString());
//			// J'ajoute l'immeuble dans la sauvegarde pour réutiliser
//			Sauvegarde.deleteItem("Immeuble");
//			Sauvegarde.addItem("Immeuble", immeubleTemporaire);
//			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
//			fenetreCompteur.setVisible(true);
//			fenetreCompteur.moveToFront();
			break;
		case "Modifier":
			Bien logement = null;
			try {
				String typeLogement = this.modificationLogement.getComboBox_typeDeLogement().getSelectedItem()
						.toString();
				
				
				// Format actuel de la chaîne
				SimpleDateFormat formatActuel = new SimpleDateFormat("dd-MM-yyyy");

				// On change le format pour qu'il corresponde à celui de la BD
				SimpleDateFormat formatBD = new SimpleDateFormat("yyyy-MM-dd");

			    String dateAcquisitionStr = this.modificationLogement.getTextField_DateAcquisition().getText();
			    java.util.Date parsedDate = formatActuel.parse(dateAcquisitionStr);
			    String dateAcquisition = formatBD.format(parsedDate);

				logement = new Bien(this.modificationLogement.getTextField_IdLogement().getText(),
						Double.parseDouble(this.modificationLogement.getTextField_SurfaceHabitable().getText()),
						Integer.parseInt(this.modificationLogement.getTextField_NbPièces().getText()), 
						Integer.parseInt(this.modificationLogement.getTextField_NumEtage().getText()),
						dateAcquisition , typeLogement,
						(Immeuble) Sauvegarde.getItem("Immeuble"));
//
//				// Si il y a un compteur à ajouter
//				if (Sauvegarde.onSave("Compteur")) {
//					this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
//					Sauvegarde.clearSave();
//				}

				this.daoBien.update(logement);
				this.modificationLogement.dispose();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Annuler":
			this.modificationLogement.dispose();
			break;
		}
	}

	public String getIdBien() {
		return this.idBien;
	}

}
