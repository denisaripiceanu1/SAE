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
                String idBien = immeuble_supp.getImmeuble();
                List<Bien> bienListe = this.daoBien.findBiensparImmeuble(idBien);
                for (Bien bien : bienListe) {
                    List<Assurance> assurances = this.daoAssurance.findByLogement(bien.getIdBien()); // assurance marche 
                    List<Diagnostics> diagnostics = this.daoDiagnostic.findDiagnosticByBien(bien.getIdBien());
                    for (Assurance assurance : assurances) {
                        this.daoAssurance.delete(assurance);
                    }
                    for (Diagnostics diagnostic : diagnostics) {
                        this.daoDiagnostic.delete(diagnostic);
                    }
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
