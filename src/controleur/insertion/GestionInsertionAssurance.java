package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;

public class GestionInsertionAssurance implements ActionListener {

	private Fenetre_InsertionAssurance fia;

	public GestionInsertionAssurance(Fenetre_InsertionAssurance fia) {
		this.fia = fia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fia.getTopLevelAncestor();
		switch (btn.getText()) {

		case "Ajouter":

			break;
		case "Annuler":
			this.fia.dispose();
			break;
		}
	}

}
