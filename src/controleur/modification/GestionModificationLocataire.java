package controleur.modification;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionModificationLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire modificationLocataire;
	private DaoLocataire daoLocataire;

	public GestionModificationLocataire(Fenetre_AffichageInfoLocataire modificationLocataire) {
		this.modificationLocataire = modificationLocataire;
		this.daoLocataire = new DaoLocataire();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationLocataire.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Modifier":

			try {
				Locataire nouvelLocataire = new Locataire(this.modificationLocataire.getTextField_Id().getText(),
						this.modificationLocataire.getTextField_Nom().getText(),
						this.modificationLocataire.getTextField_Prenom().getText(),
						this.modificationLocataire.getTextField_Telephone().getText(),
						this.modificationLocataire.getTextField_Mail().getText(),
						this.modificationLocataire.getTextField_DateN().getText());

				this.daoLocataire.update(nouvelLocataire);

				
				this.modificationLocataire.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "Annuler":
			this.modificationLocataire.dispose();
			break;
		}
	}

	
}
