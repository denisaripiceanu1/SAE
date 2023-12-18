package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerAssurance;

public class GestionSuppressionAssurance implements ActionListener {

	private Fenetre_SupprimerAssurance supprimerAssurance;
	private String idBien;
	private DaoBien daoBien;
	private DaoAssurance daoAssurance;

	public GestionSuppressionAssurance(Fenetre_SupprimerAssurance supprimerAssurance) {
		this.supprimerAssurance = this.supprimerAssurance;
		this.daoAssurance = new DaoAssurance();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerAssurance.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Assurance assurance_supp = (Assurance) Sauvegarde.getItem("Assurance");
			try {
				Assurance assurance = this.daoAssurance.findById(assurance_supp.getNuméroPolice());
				this.daoAssurance.delete(assurance);
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
