package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Echeance;
import modele.dao.DaoAssurance;
import modele.dao.DaoEcheance;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerAssurance;

public class GestionSuppressionAssurance implements ActionListener {

	private Fenetre_SupprimerAssurance supprimerAssurance;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;

	public GestionSuppressionAssurance(Fenetre_SupprimerAssurance supprimerAssurance) {
		this.supprimerAssurance = supprimerAssurance;
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerAssurance.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Assurance assurance_sauvegarde = (Assurance) Sauvegarde.getItem("Assurance");
			Echeance echeance_sauvegarde = (Echeance) Sauvegarde.getItem("Echeance");
			try {
				Assurance assurance_supp = this.daoAssurance.findById(assurance_sauvegarde.getNuméroPolice());
				Echeance echeance_supp = this.daoEcheance.findById(echeance_sauvegarde.getAssurance().getNuméroPolice(),
						echeance_sauvegarde.getDateEcheance());

				this.daoEcheance.delete(echeance_supp);
				this.daoAssurance.delete(assurance_supp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerAssurance.dispose();
			break;
		case "Annuler":
			this.supprimerAssurance.dispose();
			break;
		}
	}
}
