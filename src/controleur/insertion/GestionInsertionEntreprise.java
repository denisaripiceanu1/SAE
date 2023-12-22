package controleur.insertion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Entreprise;

import modele.dao.DaoEntreprise;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionEntreprise;

public class GestionInsertionEntreprise implements ActionListener {

	private Fenetre_InsertionEntreprise fie;
	private DaoEntreprise daoEntreprise;

	public GestionInsertionEntreprise(Fenetre_InsertionEntreprise fie) {
		this.daoEntreprise = new DaoEntreprise();
		this.fie = fie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fie.getTopLevelAncestor(); // fenetre dans laquelle

		switch (btn.getText()) {
		case "Ajouter":
			Entreprise entreprise = null;
			try {

				entreprise = new Entreprise(this.fie.getTextField_SIRET().getText(),
						this.fie.getTextField_Nom().getText(), this.fie.getTextField_Adresse().getText(),
						this.fie.getTextField_CP().getText(), this.fie.getTextField_Ville().getText(),
						this.fie.getTextField_Mail().getText(), this.fie.getTextField_Telephone().getText(),
						this.fie.getTextField_IBAN().getText());

				this.daoEntreprise.create(entreprise);

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
