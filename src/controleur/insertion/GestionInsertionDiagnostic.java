package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionDiagnostic;

public class GestionInsertionDiagnostic implements ActionListener{
	
	private Fenetre_InsertionDiagnostic fid;

	public GestionInsertionDiagnostic(Fenetre_InsertionDiagnostic fid) {
		this.fid = fid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fid.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
		case "Ajouter":
			
			break;
		case "Annuler":
			this.fid.dispose();
			break;
		}
	}
}
