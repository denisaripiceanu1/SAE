package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionTravaux;

public class GestionInsertionTravaux implements ActionListener{
	
	private Fenetre_InsertionTravaux fit;
	
	public GestionInsertionTravaux(Fenetre_InsertionTravaux fit) {
		this.fit = fit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fit.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
		case "Ajouter":
			
			break;
		case "Annuler":
			this.fit.dispose();
			break;
		}
	}
}