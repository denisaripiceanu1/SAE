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

public class GestionInsertionDiagnostic implements ActionListener {

	private Fenetre_InsertionDiagnostic fid;
	private DaoDiagnostic daoDiagnostic;

	public GestionInsertionDiagnostic(Fenetre_InsertionDiagnostic fid) {
		this.fid = fid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fid.getTopLevelAncestor(); // fenetre dans laquelle

		// on ouvre des internal
		// frame
		switch (btn.getText()) {
		case "Ajouter":
			Diagnostics diagnostic = null;
			Bien bienSauvegarde  = (Bien) Sauvegarde.getItem("Logement");
			try {
				
				diagnostic = new Diagnostics(this.fid.getTextField_Date_Validite().getText(),
						this.fid.getTextField_Type().getText(), bienSauvegarde);

				this.daoDiagnostic.create(diagnostic);
				
				this.fid.dispose();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			this.fid.dispose();
			break;

		case "Annuler":
			this.fid.dispose();
			break;
		}
	}
}
