package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionPaiementLogement;

public class GestionInsertionPaiementLogement implements ActionListener{
	
	private Fenetre_InsertionPaiementLogement fipl;
	
	public GestionInsertionPaiementLogement(Fenetre_InsertionPaiementLogement fit) {
		this.fipl = fit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fipl.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
			case "Ajouter":
				
				break;
			case "Annuler":
				this.fipl.dispose();
				break;
			}
	}
}