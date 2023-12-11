package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCharges;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionCharges implements ActionListener {
	
	private Fenetre_InsertionCharges fic;

	public GestionInsertionCharges(Fenetre_InsertionCharges fic) {
		this.fic = fic;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fic.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
		case "Ajouter":
			
			break;
		case "Annuler":
			this.fic.dispose();
			break;
		}
	}

}
