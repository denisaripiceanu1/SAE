package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionColocataire;

public class GestionInsertionColocataire implements ActionListener {

	private Fenetre_InsertionColocataire fic;
	private DaoLocataire daoCoLocataire;

	public GestionInsertionColocataire(Fenetre_InsertionColocataire fic) {
		this.fic = fic;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fic.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter":
			Locataire colocataire = null;
			try {
				colocataire = new Locataire(this.fic.getTextField_IdLocataire().getText(),
						this.fic.getTextField_Nom().getText(), this.fic.getTextField_Prenom().getText(),
						this.fic.getTextField_Tel().getText(), this.fic.getTextField_email().getText(),
						this.fic.getTextField_Date_de_naissance().getText());

				this.daoCoLocataire.create(colocataire);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.fic.dispose();
			break;
		case "Annuler":
			this.fic.dispose();
			break;
		}
	}

}
