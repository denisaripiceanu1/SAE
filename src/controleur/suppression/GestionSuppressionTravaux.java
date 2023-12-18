package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerTravaux;

public class GestionSuppressionTravaux implements ActionListener {

	private Fenetre_SupprimerTravaux supprimerTravaux;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionSuppressionTravaux(Fenetre_SupprimerTravaux supprimerTravaux) {
		this.supprimerTravaux = this.supprimerTravaux;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerTravaux.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":

			this.supprimerTravaux.dispose();
			break;
		case "Annuler":
			this.supprimerTravaux.dispose();
			break;
		}
	}

}
