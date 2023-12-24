package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Bien;
import modele.Echeance;
import modele.Immeuble;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoEcheance;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerBien;

public class GestionSuppressionBien implements ActionListener {

	private Fenetre_SupprimerBien supprimerBien;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;

	public GestionSuppressionBien(Fenetre_SupprimerBien supprimerBien) {
		this.supprimerBien = supprimerBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerBien.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Immeuble immeuble_supp = (Immeuble) Sauvegarde.getItem("Immeuble"); // bien 
			try {
				List<Bien> bien_supp = this.daoBien.findBiensparImmeuble(immeuble_supp.getImmeuble());
				Bien idBien = this.daoBien.findBienByImmeubleObject(immeuble_supp.getImmeuble());
				
				List<Assurance> assurance_supp = this.daoAssurance.findByLogement(idBien.getIdBien());
				Assurance idAssurance = this.daoAssurance.findByLogementObject(idBien.getIdBien());
				
				List<Echeance> echance_supp = this.daoEcheance.findByAssuranceNumPoliceList(idAssurance.getNuméroPolice());
				for(Echeance echeance : echance_supp) {
					this.daoEcheance.delete(echeance);
				}
				for(Assurance assurance : assurance_supp) {
					this.daoAssurance.delete(assurance);
				}
				for(Bien bien : bien_supp) {
					this.daoBien.delete(bien);
				}
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
