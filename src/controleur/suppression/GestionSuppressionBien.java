package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerBien;

public class GestionSuppressionBien implements ActionListener {

	private Fenetre_SupprimerBien supprimerBien;
	private DaoImmeuble daoImmeuble;
	private DaoCompteur daoCompteur;
	private String idBien;

	public GestionSuppressionBien(Fenetre_SupprimerBien supprimerBien) {
		this.supprimerBien = supprimerBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoCompteur = new DaoCompteur();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerBien.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Immeuble immeuble_supp = (Immeuble) Sauvegarde.getItem("Immeuble");
			try {
				Compteur compteur_supp = this.daoCompteur.findByIdImmeuble(immeuble_supp.getImmeuble());
				//supprimer le compteur de l'immeuble, puis l'immeuble
				this.daoCompteur.delete(compteur_supp);
				this.daoImmeuble.delete(immeuble_supp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerBien.dispose();
			break;
		case "Annuler":
			this.supprimerBien.dispose();
			break;
		}
	}

}
