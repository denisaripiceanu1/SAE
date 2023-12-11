package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionLogement implements ActionListener {

	private Fenetre_InsertionLogement fil;

	public GestionInsertionLogement(Fenetre_InsertionLogement fil) {
		this.fil = fil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter une quotité":
			Fenetre_InsertionQuotite insertion_quotite = new Fenetre_InsertionQuotite();
			fenetre_Principale.getLayeredPane().add(insertion_quotite);
			insertion_quotite.setVisible(true);
			insertion_quotite.moveToFront();
			break;

		case "Ajouter un compteur":
			Fenetre_InsertionCompteur insertion_compteur = new Fenetre_InsertionCompteur();
			fenetre_Principale.getLayeredPane().add(insertion_compteur);
			insertion_compteur.setVisible(true);
			insertion_compteur.moveToFront();
			break;

		case "Ajouter":
			// Ajout d'un logement
			break;
		case "Annuler":
			this.fil.dispose();
			break;
		}
	}
}
