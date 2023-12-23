package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerFactureCharge;

public class GestionSuppressionFactureCharge implements ActionListener {

	private Fenetre_SupprimerFactureCharge supprimerCharges;
	private DaoFacture daoFacture;

	public GestionSuppressionFactureCharge(Fenetre_SupprimerFactureCharge supprimerCharges) {
		this.supprimerCharges = supprimerCharges;
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerCharges.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Facture travaux_supp = (Facture) Sauvegarde.getItem("Facture");
			try {
				Facture travaux = this.daoFacture.findById(travaux_supp.getNumero());
				this.daoFacture.delete(travaux);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerCharges.dispose();
			break;
		case "Annuler":
			this.supprimerCharges.dispose();
			break;
		}
	}

}
