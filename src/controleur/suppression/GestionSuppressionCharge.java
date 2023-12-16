package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Bien;
import modele.Charge;
import modele.dao.DaoBien;
import modele.dao.DaoCharge;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerBien;
import vue.suppression.Fenetre_SupprimerCharge;

public class GestionSuppressionCharge implements ActionListener {

	private Fenetre_SupprimerCharge supprimerCharge;
	private DaoBien daoBien;
	private DaoCharge daoCharge;
	private String idBien;

	public GestionSuppressionCharge(Fenetre_SupprimerCharge supprimerCharge) {
		this.supprimerCharge = supprimerCharge;
		this.daoBien = new DaoBien();
		this.daoCharge = new DaoCharge();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerCharge.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Charge charge_supp = (Charge) Sauvegarde.getItem("Charge");
			try {
				Bien bien_supp = this.daoBien.findById(charge_supp.getBien().getIdBien());
				//supprimer le bien, puis la charge
				this.daoBien.delete(bien_supp);
				this.daoCharge.delete(charge_supp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerCharge.dispose();
			break;
		case "Annuler":
			this.supprimerCharge.dispose();
			break;
		}
	}

}
