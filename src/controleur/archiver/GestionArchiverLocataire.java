package controleur.archiver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoFacture;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverLocataire;

public class GestionArchiverLocataire implements ActionListener {

	private Fenetre_ArchiverLocataire gestionArchiverLocataire;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;
	private DaoFacture daoFacture;

	// Constructeur prenant en paramètre la fenêtre d'archivage d'un locataire
	public GestionArchiverLocataire(Fenetre_ArchiverLocataire gestionArchiverLocataire) {
		this.gestionArchiverLocataire = gestionArchiverLocataire;
		
		// Initialisation de l'accès à la base de données pour l'entité Locataire
		this.daoLocataire = new DaoLocataire();
		
		// Initialisation de l'accès à la base de données pour l'entité Louer
		this.daoLouer = new DaoLouer();
		
		// Initialisation de l'accès à la base de données pour l'entité Facture
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.gestionArchiverLocataire.getTopLevelAncestor();
		switch (btn.getText()) {
		// Suppression d'une location
		case "Archiver":
			// Récupération de la Location placée dans la sauvegarde
			Louer louer_supp = (Louer) Sauvegarde.getItem("Louer");
			try {
				Locataire locataire = this.daoLocataire.findById(louer_supp.getLocataire().getIdLocataire());
				List<Facture> facture = this.daoFacture.findFactureChargeByLogement(louer_supp.getBien().getIdBien());
				Louer louer = this.daoLouer.findById(louer_supp.getBien().getIdBien(),
						louer_supp.getLocataire().getIdLocataire(), louer_supp.getDateDebut());
				// Vérification du nombre de locations du locataire
				int nombreLocations = this.daoLouer.getNombreLocationsParLocataire(locataire.getIdLocataire());

				if (nombreLocations == 1) {
					for (Facture factures : facture) {
						// Suppression de la facture
						this.daoFacture.delete(factures);
						// Création de la même facture mais archivée
						this.daoFacture.createArchive(factures);
					}
					// Suppression de la Location
					this.daoLouer.delete(louer);
					// Création de la même Location mais archivée
					this.daoLouer.createArchiver(louer);
					// Suppression du locataire
					this.daoLocataire.delete(locataire);
					// Création du même locataire mais archivé
					this.daoLocataire.createArchive(locataire);
				} else {
					// Afficher une fenêtre d'erreur car le locataire a plus d'une location
					JOptionPane.showMessageDialog(null,
							"Impossible d'archiver le locataire. Il doit avoir une seule location.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.gestionArchiverLocataire.dispose();
			break;

		// Annulation de la suppression
		case "Annuler":
			// Fermeture de la fenêtre de suppression sans action
			this.gestionArchiverLocataire.dispose();
			break;
		}
	}
}
