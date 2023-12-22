package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.Diagnostics;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoDiagnostic;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionDiagnostic;
import vue.insertion.Fenetre_InsertionEntreprise;

public class GestionInsertionEntreprise implements ActionListener {

	private Fenetre_InsertionEntreprise fie;
	private DaoDiagnostic daoDiagnostic;

	public GestionInsertionEntreprise(Fenetre_InsertionEntreprise fie) {
		this.fie = fie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fie.getTopLevelAncestor(); // fenetre dans laquelle

		// on ouvre des internal
		// frame
		switch (btn.getText()) {
		case "Ajouter":
			Diagnostics diagnostic = null;
			Bien bienSauvegarde  = (Bien) Sauvegarde.getItem("Logement");
			try {
				
				diagnostic = new Diagnostics(this.fie.getTextField_Date_Validite().getText(),
						this.fie.getTextField_Type().getText(), bienSauvegarde);

				this.daoDiagnostic.create(diagnostic);
				
				this.fie.dispose();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			this.fie.dispose();
			break;

		case "Annuler":
			this.fie.dispose();
			break;
		}
	}
}
