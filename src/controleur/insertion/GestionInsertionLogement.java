package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.Quotite;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoQuotite;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionLogement implements ActionListener {

	private Fenetre_InsertionLogement fil;
	private DaoBien daoBien;
	private DaoCompteur daoCompteur;
	private DaoQuotite daoQuotite;
	private Immeuble immeubleSauvegarde;

	public GestionInsertionLogement(Fenetre_InsertionLogement fil) {
		this.fil = fil;
		this.daoBien = new DaoBien();
		this.daoCompteur = new DaoCompteur();
		this.daoQuotite = new DaoQuotite();
		//On créer directement l'immeuble à partir de celui de la sauvegarde pour ne plus en dépendre
		this.immeubleSauvegarde = (Immeuble) Sauvegarde.getItem("Immeuble");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
		
		switch (btn.getText()) {
			// Action lors du clic sur "Ajouter une quotité"
			case "Ajouter une quotité":
				// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
				// créer la quotité
				Bien bienTemporaireQ = new Bien (this.fil.getTextField_IdLogement().getText(), 
						Double.parseDouble(this.fil.getTextField_SurfaceHabitable().getText()),
						Integer.parseInt(this.fil.getTextField_NbPièces().getText()),
						Integer.parseInt(this.fil.getTextField_NumEtage().getText()),
						this.fil.getTextField_DateAcquisition().getText(),
						this.fil.getComboBox_typeDeLogement().getSelectedItem().toString(),
						this.immeubleSauvegarde);	
				// J'ajoute  dans le logement la sauvegarde pour réutiliser
				Sauvegarde.deleteItem("Logement");
				Sauvegarde.addItem("Logement", bienTemporaireQ);;
				
				Fenetre_InsertionQuotite insertion_quotite = new Fenetre_InsertionQuotite();
				fenetre_Principale.getLayeredPane().add(insertion_quotite);
				insertion_quotite.setVisible(true);
				insertion_quotite.moveToFront();
				break;

			// Action lors du clic sur "Ajouter un compteur"
			case "Ajouter un compteur":
				// Je créer temporairement le bien pour pouvoir récupérer l'ID quand je vais
				// créer le compteur
				Bien bienTemporaire = new Bien (this.fil.getTextField_IdLogement().getText(), 
						Double.parseDouble(this.fil.getTextField_SurfaceHabitable().getText()),
						Integer.parseInt(this.fil.getTextField_NbPièces().getText()),
						Integer.parseInt(this.fil.getTextField_NumEtage().getText()),
						this.fil.getTextField_DateAcquisition().getText(),
						this.fil.getComboBox_typeDeLogement().getSelectedItem().toString(),
						this.immeubleSauvegarde);	
				// J'ajoute  dans le logement la sauvegarde pour réutiliser
				Sauvegarde.deleteItem("Logement");
				Sauvegarde.addItem("Logement", bienTemporaire);
				
				// On enleve l'immeuble de la sauvegarde pour éviter d'avoir l'id immeuble dans la création du compteur donc constraint check UU
				Sauvegarde.deleteItem("Immeuble");
				
				Fenetre_InsertionCompteur insertion_compteur = new Fenetre_InsertionCompteur();
				fenetre_Principale.getLayeredPane().add(insertion_compteur);
				insertion_compteur.setVisible(true);
				insertion_compteur.moveToFront();
				break;

			// Action lors du clic sur "Ajouter"
			case "Ajouter":
				Bien logement = null;
				try {
					// Récupération des informations du logement depuis l'interface graphique
					String typeLogement = this.fil.getComboBox_typeDeLogement().getSelectedItem().toString();
					logement = new Bien(
							this.fil.getTextField_IdLogement().getText(),
							Double.parseDouble(this.fil.getTextField_SurfaceHabitable().getText()),
							Integer.parseInt(this.fil.getTextField_NbPièces().getText()),
							Integer.parseInt(this.fil.getTextField_NumEtage().getText()),
							this.fil.getTextField_DateAcquisition().getText(),
							typeLogement,
							this.immeubleSauvegarde // Récupération de l'Immeuble associé au logement
					);
					
					// Enregistrement du logement dans la base de données
					this.daoBien.create(logement);
					
					// Potentiellement supprimer l'immeuble de la sauvegarde si besoin
					
					// Si il y a un compteur à ajouter
					if (Sauvegarde.onSave("Compteur")) {
						this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
						Sauvegarde.clearSave();
					}
					
					// Si il y a une quotité à ajouter
					if (Sauvegarde.onSave("Quotite")) {
						this.daoQuotite.create((Quotite) Sauvegarde.getItem("Quotite"));
						Sauvegarde.clearSave();
					}
					
					 // Afficher un message de réussite
                    JOptionPane.showMessageDialog(this.fil, "Ajouté avec succès !", "Succès",
                            JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Fermeture de la fenêtre d'insertion de logement après ajout
				this.fil.dispose();
				break;
				
			// Action lors du clic sur "Annuler"
			case "Annuler":
				// Fermeture de la fenêtre d'insertion de logement sans ajout
				this.fil.dispose();
				break;
		}
	}
}
