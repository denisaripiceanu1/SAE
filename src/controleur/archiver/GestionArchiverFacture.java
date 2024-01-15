package controleur.archiver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverFacture;

public class GestionArchiverFacture implements ActionListener {

	private Fenetre_ArchiverFacture supprimerFature;
	private DaoFacture daoFacture;

	public GestionArchiverFacture(Fenetre_ArchiverFacture supprimerFature) {
		this.supprimerFature = supprimerFature;
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerFature.getTopLevelAncestor();
		Facture charge_supp = (Facture) Sauvegarde.getItem("Charge");

		switch (btn.getText()) {
		// Action lors du clic sur "Supprimer"
		case "Archiver":
			try {
				// Recherche de la facture à supprimer par son numéro
				Facture facture = this.daoFacture.findFactureChargeById(charge_supp.getNumero());
				this.daoFacture.delete(facture); // Suppression de la facture
				this.daoFacture.createArchive(facture);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.supprimerFature.dispose(); // Fermeture de la fenêtre de suppression
			break;

		// Action lors du clic sur "Annuler"
		case "Annuler":
			this.supprimerFature.dispose(); // Fermeture de la fenêtre de suppression sans action
			break;
		}
	}
}
