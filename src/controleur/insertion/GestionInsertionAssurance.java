package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Assurance;
import modele.Entreprise;
import modele.Immeuble;
import modele.dao.DaoAssurance;
import modele.dao.DaoEntreprise;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;

public class GestionInsertionAssurance implements ActionListener {

	private Fenetre_InsertionAssurance fia;
	private DaoAssurance daoAssurance;

	public GestionInsertionAssurance(Fenetre_InsertionAssurance fia) {
		this.fia = fia;
		this.daoAssurance = new DaoAssurance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fia.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			Assurance assurance = null;
			try {
				DaoImmeuble daoImmeuble = new DaoImmeuble();
				DaoEntreprise daoEntreprise = new DaoEntreprise();
				Immeuble immeuble = daoImmeuble.findById(this.fia.getTextField_IDImmeuble().getText());
				Entreprise entreprise = daoEntreprise.findById(this.fia.getTextField_SIRET().getText());

				assurance = new Assurance(this.fia.getTextField_numPolice().getText(),
						Float.parseFloat(this.fia.getTextField_montant().getText()), immeuble, entreprise);

				this.daoAssurance.create(assurance);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.fia.dispose();
			break;
		case "Annuler":
			this.fia.dispose();
			break;
		}
	}

}
