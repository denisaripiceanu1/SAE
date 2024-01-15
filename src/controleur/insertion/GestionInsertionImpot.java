package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Imposer;
import modele.Impôt;
import modele.dao.DaoBien;
import modele.dao.DaoImposer;
import modele.dao.DaoImpôt;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionImpot;

public class GestionInsertionImpot implements ActionListener {

	private Fenetre_InsertionImpot fii;
	private DaoBien daoBien;
	private DaoImpôt daoImpot;
	private DaoImposer daoImposer;

	public GestionInsertionImpot(Fenetre_InsertionImpot fii) {
		this.fii = fii;
		this.daoBien = new DaoBien();
		this.daoImpot = new DaoImpôt();
		this.daoImposer = new DaoImposer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fii.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Ajouter":
			Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
			Impôt impot = null;
			Imposer imposer = null;
			try {

				impot = new Impôt(this.fii.getTextField_nom().getText(),
						Double.parseDouble(this.fii.getTextField_montant().getText()),
						this.fii.getTextField_annee().getText());

				// Ajouter le nouvel impot dans la base de données
				int idImpotSequence = this.daoImpot.createAvecSequence(impot);

				// Attribue l'id de la séquence à l'impot
				impot.setIdImpot(idImpotSequence);

				imposer = new Imposer(bienSauvegarde, impot);
				this.daoImposer.create(imposer);

				this.fii.dispose();

				JOptionPane.showMessageDialog(null, "Impôt ajouté avec succès !", "Succès", JOptionPane.YES_OPTION);

			} catch (Exception e1) {
				e1.printStackTrace();
				// Afficher un message d'erreur à l'utilisateur
				JOptionPane.showMessageDialog(null,
						"Erreur lors de l'ajout de l'impôt dans la base de données. Veuillez réessayer plus tard.",
						"Erreur d'ajout", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Annuler":
			this.fii.dispose();
			break;
		}
	}
}
