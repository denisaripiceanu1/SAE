package controleur.insertion;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import modele.dao.DaoBien;
import modele.dao.DaoImpôt;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionImpot;

public class GestionInsertionImpot {

	private Fenetre_InsertionImpot fii;
	private DaoBien daoBien;
	private DaoImpôt daoImpot;

	public GestionInsertionImpot(Fenetre_InsertionImpot fii) {
		this.fii = fii;
		this.daoBien = new DaoBien();
		this.daoImpot = new DaoImpôt();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fii.getTopLevelAncestor();

		// Gérer les actions en fonction du bouton cliqué
		switch (btn.getText()) {
		case "Ajouter":
			// Fermer la fenêtre d'insertion après l'ajout
			this.fii.dispose();
			break;

		case "Annuler":
			// Annuler l'opération, fermer la fenêtre d'insertion
			this.fii.dispose();
			break;
		}
	}

}
