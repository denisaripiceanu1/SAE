package controleur.modification;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import controleur.outils.Sauvegarde;
import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.modification.Fenetre_ModificationEntreprise;

public class GestionModificationEntreprise implements ActionListener {

	private Fenetre_ModificationEntreprise modificationEntreprise;
	private DaoEntreprise daoEntreprise;

	public GestionModificationEntreprise(Fenetre_ModificationEntreprise modificationEntreprise) {
		this.modificationEntreprise = modificationEntreprise;
		this.daoEntreprise = new DaoEntreprise();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		switch (btn.getText()) {
		case "Modifier":
			// Appel de la méthode pour effectuer la modification du locataire
			try {
				Entreprise entreprise = new Entreprise(
						this.modificationEntreprise.getTextField_SIRET().getText(),
						this.modificationEntreprise.getTextField_Nom().getText(),
						this.modificationEntreprise.getTextField_Adresse().getText(),
						this.modificationEntreprise.getTextField_CP().getText(),
						this.modificationEntreprise.getTextField_Ville().getText(),
						this.modificationEntreprise.getTextField_Mail().getText(),
						this.modificationEntreprise.getTextField_Telephone().getText(),
						this.modificationEntreprise.getTextField_IBAN().getText());
				
				// Appel de la méthode de mise à jour dans la base de données
				this.daoEntreprise.update(entreprise);

				// Fermeture de la fenêtre de modification après la mise à jour
				this.modificationEntreprise.dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "Annuler":
			// Fermeture de la fenêtre de modification
			this.modificationEntreprise.dispose();
			break;
		}
	}

}
