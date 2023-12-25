package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.tools.Diagnostic;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Bien;
import modele.Echeance;
import modele.Immeuble;
import modele.Imposer;
import modele.Louer;
import modele.Quotter;
import modele.Diagnostics;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoDiagnostic;
import modele.dao.DaoEcheance;
import modele.dao.DaoImmeuble;
import modele.dao.DaoImposer;
import modele.dao.DaoLouer;
import modele.dao.DaoQuotter;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerBien;

public class GestionSuppressionBien implements ActionListener {

	private Fenetre_SupprimerBien supprimerBien;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;
	private DaoLouer daoLouer;
	private DaoQuotter daoQuotter;
	private DaoImposer daoImposer;
	private DaoDiagnostic daoDiagnostic;

	public GestionSuppressionBien(Fenetre_SupprimerBien supprimerBien) {
		this.supprimerBien = supprimerBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		this.daoLouer = new DaoLouer();
		this.daoQuotter = new DaoQuotter();
		this.daoImposer = new DaoImposer();
		this.daoDiagnostic = new DaoDiagnostic();
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
				
				List<Assurance> assurance_supp = this.daoAssurance.findByLogement(idBien.getImmeuble().getImmeuble());
				Assurance idAssurance = this.daoAssurance.findByLogementObject(idBien.getImmeuble().getImmeuble());
				
				List<Louer> louer_supp = this.daoLouer.findLocationByBien(idBien.getImmeuble().getImmeuble());
				
				List<Quotter> quotter_supp = this.daoQuotter.findQuotterByBien(idBien.getImmeuble().getImmeuble());
				
				List<Echeance> echance_supp;
				
				List<Imposer> imposer_supp = this.daoImposer.findImposerByBien(idBien.getImmeuble().getImmeuble());
				
				List<Diagnostics> diagnostic_supp = this.daoDiagnostic.findDiagnosticByBien(idBien.getImmeuble().getImmeuble());
				
				for(Diagnostics diagnostics : diagnostic_supp) {
					this.daoDiagnostic.delete(diagnostics);
				}
				
				for(Imposer imposer : imposer_supp) {
					this.daoImposer.delete(imposer);
				}
				
				for(Quotter quotter : quotter_supp) {
					this.daoQuotter.delete(quotter);
				}
				
				for(Louer louer : louer_supp) {
					this.daoLouer.delete(louer);
				}

				for(Assurance assurance : assurance_supp) {
					// on le met ici car les assurances change de id si on le met a l'exterieur alors il supprimera que 1 seul
					echance_supp = this.daoEcheance.findByAssuranceNumPoliceList(assurance.getNuméroPolice());
					for(Echeance echeance : echance_supp) {
						this.daoEcheance.delete(echeance);
					}
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
