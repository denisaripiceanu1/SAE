package controleur.insertion;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Impôt;
import modele.dao.DaoBien;
import modele.dao.DaoImpôt;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionImpot;

public class GestionInsertionImpot {

	private Fenetre_InsertionImpot fii;
	private DaoBien daoBien;
	private DaoImpôt daoImpot;

	public GestionInsertionImpot(Fenetre_InsertionImpot fii) {
		this.fii = fii;
		this.daoBien = new DaoBien();
		this.daoImpot = new DaoImpôt();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fii.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Ajouter":
			Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
			Impôt impot = null;
			try {

				impot = new Impôt(this.fii.getTextField_nom().getText(),
						Float.parseFloat(this.fii.getTextField_montant().getText()),
						this.fii.getTextField_annee().getText());

				this.daoImpot.create(impot);
				this.fii.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
				// Afficher un message d'erreur à l'utilisateur
				JOptionPane.showMessageDialog(null,
						"Erreur lors de l'ajout de l'assurance dans la base de données. Veuillez réessayer plus tard.",
						"Erreur d'ajout", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Annuler":
			this.fii.dispose();
			break;
		}
	}
}
