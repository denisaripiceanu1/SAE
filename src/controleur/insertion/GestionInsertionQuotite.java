package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionQuotite implements ActionListener{

	private Fenetre_InsertionQuotite fiq;

	public GestionInsertionQuotite(Fenetre_InsertionQuotite fiq) {
		this.fiq = fiq;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fiq.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":

			break;
		case "Annuler":
			this.fiq.dispose();
			break;
		}

	}

}
