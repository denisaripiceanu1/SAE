package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerTravaux;

public class GestionSuppressionTravaux implements ActionListener {

	private Fenetre_SupprimerTravaux supprimerTravaux;
	private String idBien;
	private DaoFacture daoFacture;

	public GestionSuppressionTravaux(Fenetre_SupprimerTravaux supprimerTravaux) {
		this.supprimerTravaux = supprimerTravaux;
		this.daoFacture = new DaoFacture();
		this.idBien = null;
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerTravaux.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Facture travaux_supp = (Facture) Sauvegarde.getItem("Travaux");
			System.out.println(travaux_supp.getNumero());
			try {
				Facture travaux = this.daoFacture.findById(travaux_supp.getNumero());
				this.daoFacture.delete(travaux);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerTravaux.dispose();
			break;
		case "Annuler":
			this.supprimerTravaux.dispose();
			break;
		}
	}

}
