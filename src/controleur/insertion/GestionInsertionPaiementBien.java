package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionPaiementBien;
import vue.insertion.Fenetre_InsertionPaiementLogement;

public class GestionInsertionPaiementBien implements ActionListener{
	
	private Fenetre_InsertionPaiementBien fipb;
	
	public GestionInsertionPaiementBien(Fenetre_InsertionPaiementBien fenetre_InsertionPaiementBien) {
		this.fipb = fenetre_InsertionPaiementBien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fipb.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
			case "Ajouter":
				
				break;
			case "Annuler":
				this.fipb.dispose();
				break;
			}
	}
}