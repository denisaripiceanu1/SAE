package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerAssurance;

public class GestionSuppressionAssurance implements ActionListener {

	private Fenetre_SupprimerAssurance supprimerAssurance;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionSuppressionAssurance(Fenetre_SupprimerAssurance supprimerAssurance) {
		this.supprimerAssurance = this.supprimerAssurance;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerAssurance.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":

			this.supprimerAssurance.dispose();
			break;
		case "Annuler":
			this.supprimerAssurance.dispose();
			break;
		}
	}

}
