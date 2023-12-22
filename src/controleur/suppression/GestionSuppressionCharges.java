package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Facture;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerCharges;

public class GestionSuppressionCharges implements ActionListener {

	private Fenetre_SupprimerCharges supprimerCharges;

	public GestionSuppressionCharges(Fenetre_SupprimerCharges supprimerCharges) {
		this.supprimerCharges = supprimerCharges;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerCharges.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Facture travaux_supp = (Facture) Sauvegarde.getItem("Facture");
//			try {
//				Facture travaux = this.supprimerCharges.findById(travaux_supp.getNumero());
//				this.supprimerCharges.delete(travaux);
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			this.supprimerCharges.dispose();
			break;
		case "Annuler":
			this.supprimerCharges.dispose();
			break;
		}
	}

}
