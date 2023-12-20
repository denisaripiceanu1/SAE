package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationTravauxImmeuble;

public class GestionModificationTravauxImmeuble implements ActionListener {

	private Fenetre_ModificationTravauxImmeuble modificationTravauxImmeuble;
	private DaoFacture daoTravaux;

	public GestionModificationTravauxImmeuble(Fenetre_ModificationTravauxImmeuble modificationTravauxImmeuble) {
		this.modificationTravauxImmeuble = modificationTravauxImmeuble;
		this.daoTravaux = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationTravauxImmeuble.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Modifier":
			try {
//				Facture nouvelImmeuble = new Facture(
//						this.modificationTravauxImmeuble.getTextField_IdImmeuble().getText(),
//						this.modificationTravauxImmeuble.getTextField_adresse().getText(),
//						this.modificationTravauxImmeuble.getTextField_codePostal().getText(),
//						this.modificationTravauxImmeuble.getTextField_ville().getText(),
//						this.modificationTravauxImmeuble.getTextField_periodeDeConstruction().getText(),
//						this.modificationTravauxImmeuble.getComboBox_typeDeBien().getSelectedItem().toString());

				// this.daoTravaux.update(nouvelImmeuble);

				this.modificationTravauxImmeuble.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "Annuler":
			this.modificationTravauxImmeuble.dispose();
			break;
		}
	}

}
