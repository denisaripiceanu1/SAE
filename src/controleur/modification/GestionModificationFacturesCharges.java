package controleur.modification;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationFactureChargeLogement;

public class GestionModificationFacturesCharges implements ActionListener {

	private Fenetre_ModificationFactureChargeLogement modificationFacturesCharge;
	private DaoFacture daoFacture;
	private DaoBien daoBien;

	public GestionModificationFacturesCharges(Fenetre_ModificationFactureChargeLogement modificationCharge) {
		this.modificationFacturesCharge = modificationCharge;
		this.daoFacture = new DaoFacture();
		this.daoBien = new DaoBien();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationFacturesCharge.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Modifier":
			try {
				int imputable = 0;
				if (this.modificationFacturesCharge.getRdbtnOui().isSelected()) {
					imputable = 1;
				}

				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
				Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

				Facture nouvelleCharge = new Facture(this.modificationFacturesCharge.getTextField_Numero().getText(),
						this.modificationFacturesCharge.getTextField_date_emission().getText(),
						this.modificationFacturesCharge.getTextField_date_paiement().getText(),
						this.modificationFacturesCharge.getComboBox_modePaiement().getSelectedItem().toString(),
						this.modificationFacturesCharge.getTextField_numeroDevis().getText(),
						this.modificationFacturesCharge.getComboBox_Designation().getSelectedItem().toString(),
						Double.parseDouble(this.modificationFacturesCharge.getTextField_accompteVerse().getText()),
						Double.parseDouble(this.modificationFacturesCharge.getTextField_montant().getText()), imputable,
						null, bienSauvegarde, entrepriseSauvegarde);

				this.daoFacture.update(nouvelleCharge);

				this.modificationFacturesCharge.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;

		case "Annuler":
			// Vérifier si l'élément "Logement" est présent dans la sauvegarde
			if (Sauvegarde.onSave("Logement") == true) {
				// Si oui, fermer la fenêtre de modification
				this.modificationFacturesCharge.dispose();
			} else {
				// Si non, afficher un message d'avertissement ou prendre une autre action
				System.out.println("Aucun élément 'Logement' trouvé dans la sauvegarde.");
			}
			break;
		}
	}
}