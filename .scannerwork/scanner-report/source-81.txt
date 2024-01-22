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

	// Constructeur prenant en paramètre la fenêtre d'archivage d'une facture
	public GestionArchiverFacture(Fenetre_ArchiverFacture supprimerFature) {
		this.supprimerFature = supprimerFature;
		
		// Initialisation de l'accès à la base de données pour l'entité Facture
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerFature.getTopLevelAncestor();
		Facture charge_supp = (Facture) Sauvegarde.getItem("Charge");

		switch (btn.getText()) {
		// Action lors du clic sur "Archiver"
		case "Archiver":
			try {
				// Recherche de la facture à supprimer par son numéro
				Facture facture = this.daoFacture.findFactureChargeById(charge_supp.getNumero());
				// Suppression de la facture
				this.daoFacture.delete(facture); 
				// Création de la même facture mais archivée
				this.daoFacture.createArchive(facture);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// Fermeture de la fenêtre d'archivage de la facture
			this.supprimerFature.dispose(); 
			break;

		// Action lors du clic sur "Annuler"
		case "Annuler":
			// Fermeture de la fenêtre de suppression sans action
			this.supprimerFature.dispose(); 
			break;
		}
	}
}
