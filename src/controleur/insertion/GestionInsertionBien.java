package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionBien implements ActionListener {
	
	private Fenetre_InsertionBien insertionBien;
	
	public GestionInsertionBien(Fenetre_InsertionBien insertionBien) {
		this.insertionBien = insertionBien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.insertionBien.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
		case "Ajouter un compteur":
			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
			fenetreCompteur.setVisible(true);
			fenetreCompteur.moveToFront();
			break;
		case "Ajouter":
			
			break;
		case "Annuler":
			this.insertionBien.dispose();
			break;
		}
	}

}
