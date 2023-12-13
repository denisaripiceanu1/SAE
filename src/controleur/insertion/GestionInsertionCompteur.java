package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionCompteur implements ActionListener {

	private Fenetre_InsertionCompteur fic;
	private DaoCompteur daoCompteur;
	
	public GestionInsertionCompteur(Fenetre_InsertionCompteur fic) {
		this.fic = fic;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fic.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			try {
				
				Compteur compteur = new Compteur(
						this.fic.getTextField_IdCompteur().getText(),
						this.fic.getComboBox_typeDeCompteur().getSelectedItem().toString(),
						(Bien) Sauvegarde.getItem("Bien"),
						(Immeuble) Sauvegarde.getItem("Immeuble")
				);
				Sauvegarde.deleteItem("Compteur");
				Sauvegarde.addItem("Compteur", compteur);
//				Boite.deleteItem("Bien");
//				Boite.addItem("Bien", bien);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			break;
		case "Annuler":
			this.fic.dispose();
			break;
		}

	}
}
