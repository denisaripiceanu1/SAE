package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Bien;
import modele.Compteur;
import modele.Diagnostics;
import modele.Facture;
import modele.Immeuble;
import modele.Imposer;
import modele.Louer;
import modele.Quotter;
import modele.Releve;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoDiagnostic;
import modele.dao.DaoEcheance;
import modele.dao.DaoFacture;
import modele.dao.DaoImmeuble;
import modele.dao.DaoImposer;
import modele.dao.DaoLouer;
import modele.dao.DaoQuotter;
import modele.dao.DaoReleve;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerBien;

public class GestionSuppressionBien implements ActionListener {

	private Fenetre_SupprimerBien supprimerBien;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;
	private DaoFacture daoFacture;
	private DaoLouer daoLouer;
	private DaoQuotter daoQuotter;
	private DaoImposer daoImposer;
	private DaoCompteur daoCompteur;
	private DaoDiagnostic daoDiagnostic;
	private DaoReleve daoReleve;

	public GestionSuppressionBien(Fenetre_SupprimerBien supprimerBien) {
		this.supprimerBien = supprimerBien;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		this.daoLouer = new DaoLouer();
		this.daoFacture = new DaoFacture();
		this.daoQuotter = new DaoQuotter();
		this.daoImposer = new DaoImposer();
		this.daoCompteur = new DaoCompteur();
		this.daoReleve = new DaoReleve();
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
				List<Compteur> compteurListeImmeuble = this.daoCompteur.findByIdImmeubleListe(idBien);
				List<Facture> factureListeImmeuble = this.daoFacture.findFactureImmeuble(idBien); // marche
				List<Releve> releves; // marche
				if (compteurListeImmeuble != null && !compteurListeImmeuble.isEmpty()) {
					for (Compteur compteur : compteurListeImmeuble) {
						releves = this.daoReleve.findReleveByCompteur(compteur.getIdCompteur());
						for (Releve releve : releves) {
							this.daoReleve.delete(releve);
						}
						this.daoCompteur.delete(compteur);
					}
				}
				if (factureListeImmeuble != null && !factureListeImmeuble.isEmpty()) {
					for (Facture facture : factureListeImmeuble) {
						this.daoFacture.delete(facture);
					}
				}
				for (Bien bien : bienListe) {
					List<Assurance> assurances = this.daoAssurance.findByLogement(bien.getIdBien()); // assurance marche
					List<Diagnostics> diagnostics = this.daoDiagnostic.findDiagnosticByBien(bien.getIdBien()); // marche
																												// pas
					List<Louer> louers = this.daoLouer.findLocationByBien(bien.getIdBien()); // marche
					List<Compteur> compteurListeBien = this.daoCompteur.findByIdBienListe(bien.getIdBien()); // marche
					List<Quotter> quotters = this.daoQuotter.findQuotterByBien(bien.getIdBien()); // marche
					List<Facture> factureListeBien = this.daoFacture.findFactureByBien(bien.getIdBien()); // marche
					List<Imposer> imposers = this.daoImposer.findImposerByBien(bien.getIdBien());
					for (Assurance assurance : assurances) {
						this.daoAssurance.delete(assurance);
					}
					for (Diagnostics diagnostic : diagnostics) {
						this.daoDiagnostic.delete(diagnostic);
					}
					for (Louer louer : louers) {
						this.daoLouer.delete(louer);
					}
					if (compteurListeBien != null && !compteurListeBien.isEmpty()) {
						for (Compteur compteur : compteurListeBien) {
							releves = this.daoReleve.findReleveByCompteur(compteur.getIdCompteur());
							for (Releve releve : releves) {
								this.daoReleve.delete(releve);
							}
							this.daoCompteur.delete(compteur);
						}
					}
					if (factureListeBien != null && !factureListeBien.isEmpty()) {
						for (Facture facture : factureListeBien) {
							this.daoFacture.delete(facture);
						}
					}
					for (Quotter quotter : quotters) {
						this.daoQuotter.delete(quotter);
					}
					for (Imposer imposer : imposers) {
						this.daoImposer.delete(imposer);
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
