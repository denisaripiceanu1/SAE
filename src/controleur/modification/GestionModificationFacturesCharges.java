package controleur.modification;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Facture;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationFactureChargeBien;

public class GestionModificationFacturesCharges implements ActionListener {

	private Fenetre_ModificationFactureChargeBien modificationFacturesCharge;
	private DaoFacture daoFacture;
	private DaoBien daoBien;

	public GestionModificationFacturesCharges(Fenetre_ModificationFactureChargeBien modificationCharge) {
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
//			try {
//				int deductibleValeur = 0; // Non déductible par défaut
//
//				// choix de la radio button
//				if (this.modificationFacturesCharge.getRdbtnAjouterChargeOui().isSelected()) {
//					deductibleValeur = 1;
//				} else if (this.modificationFacturesCharge.getRdbtnAjouterChargeNon().isSelected()) {
//					deductibleValeur = 0;
//				}
//
//				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
//				Bien bienCourant;
//
//				Facture sauvegardeCharge = (Facture) Sauvegarde.getItem("Facture");
//				
//				bienCourant = this.daoBien.findById(bienSauvegarde.getIdBien());
//
//				Facture nouvelleCharge = new Facture(sauvegardeCharge.getNumero(), this.modificationFacturesCharge.getTextField_nomCharge().getText(),
//						Double.parseDouble(this.modificationFacturesCharge.getTextField_montantPrevisionnel().getText()),
//						Double.parseDouble(this.modificationFacturesCharge.getTextField_montantReel().getText()),
//						deductibleValeur, bienCourant);
//				this.daoFacture.update(nouvelleCharge);
//
//				this.modificationFacturesCharge.dispose(); // Fermer la page après l'ajout
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
			break;
		case "Annuler":
            // Vérifier si l'élément "Logement" est présent dans la sauvegarde
            if (Sauvegarde.onSave("Logement")==true) {
                // Si oui, fermer la fenêtre de modification
                this.modificationFacturesCharge.dispose();
            } else {
                // Si non, afficher un message d'avertissement ou prendre une autre action
                System.out.println("Aucun élément 'Logement' trouvé dans la sauvegarde.");
            }
            break;
    }
}}