package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Charge;
import modele.dao.DaoBien;
import modele.dao.DaoCharge;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationCharges;

public class GestionModificationCharges implements ActionListener {

	private Fenetre_ModificationCharges modificationCharge;
	private DaoCharge daoCharge;
	private DaoBien daoBien;
	private String idBien;

	public GestionModificationCharges(Fenetre_ModificationCharges modificationCharge) {
		this.modificationCharge = modificationCharge;
		this.daoCharge = new DaoCharge();
		this.daoBien = new DaoBien();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationCharge.getTopLevelAncestor();

		switch (btn.getText()) {

		case "Modifier":

			try {
				int deductibleValeur = 0; // Non déductible par défaut

				// choix de la radio button
				if (this.modificationCharge.getRdbtnAjouterChargeOui().isSelected()) {
					deductibleValeur = 1;
				} else if (this.modificationCharge.getRdbtnAjouterChargeNon().isSelected()) {
					deductibleValeur = 0;
				}

				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
				Bien bienCourant;

				bienCourant = this.daoBien.findById(bienSauvegarde.getIdBien());

				Charge nouvelleCharge = new Charge(this.modificationCharge.getTextField_nomCharge().getText(),
						Double.parseDouble(this.modificationCharge.getTextField_montantPrevisionnel().getText()),
						Double.parseDouble(this.modificationCharge.getTextField_montantReel().getText()),
						deductibleValeur, bienCourant);
				this.daoCharge.update(nouvelleCharge);

				this.modificationCharge.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Annuler":
			this.modificationCharge.dispose();
			break;
		}
	}
}
