package controleur.archiver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Louer;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverLocation;

public class GestionArchiverLocation implements ActionListener {

	private Fenetre_ArchiverLocation archiverLocation;
	private DaoLouer daoLouer;

	public GestionArchiverLocation(Fenetre_ArchiverLocation archiverLocation) {
		this.archiverLocation = archiverLocation;
		this.daoLouer = new DaoLouer();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.archiverLocation.getTopLevelAncestor();
		switch (btn.getText()) {
		// Suppression d'une location
		case "Archiver":
			Louer louer_supp = (Louer) Sauvegarde.getItem("Louer");
			try {
				Louer louer = this.daoLouer.findById(louer_supp.getBien().getIdBien(),
						louer_supp.getLocataire().getIdLocataire(), louer_supp.getDateDebut());
				this.daoLouer.deleteVrai(louer);
				this.daoLouer.createArchiver(louer);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.archiverLocation.dispose();
			break;
		// Annulation de la suppression
		case "Annuler":
			this.archiverLocation.dispose();
			break;
		}
	}
}
