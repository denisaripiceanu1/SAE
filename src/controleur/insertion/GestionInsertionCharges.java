package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Bien;
import modele.Charge;
import modele.dao.DaoBien;
import modele.dao.DaoCharge;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCharges;

public class GestionInsertionCharges implements ActionListener {

	private Fenetre_InsertionCharges fic;
	private DaoCharge daoCharge;

	public GestionInsertionCharges(Fenetre_InsertionCharges fic) {
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
			Charge charge = null;
			try {
				DaoBien daoBien = new DaoBien();
				Bien bien = daoBien.findById(null);

				int deductibleValeur = 0; // Non déductible par défaut

				// choix de la radio button
				if (this.fic.getRdbtnAjouterChargeOui().isSelected()) {
					deductibleValeur = 1;
				} else if (this.fic.getRdbtnAjouterChargeNon().isSelected()) {
					deductibleValeur = 0;
				}

				charge = new Charge(this.fic.getTextField_nomCharge().getText(),
						Double.parseDouble(this.fic.getTextField_montantReel().getText()),
						Double.parseDouble(this.fic.getTextField_montantPrevisionnel().getText()), deductibleValeur,
						bien);

				this.daoCharge.create(charge);

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
