package controleur.archiver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverLocataire;

public class GestionArchiverLocataire implements ActionListener {

	private Fenetre_ArchiverLocataire gestionArchiverLocataire;
	private DaoLocataire daoLocataire;

	public GestionArchiverLocataire(Fenetre_ArchiverLocataire gestionArchiverLocataire) {
		this.gestionArchiverLocataire = gestionArchiverLocataire;
		this.daoLocataire = new DaoLocataire();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.gestionArchiverLocataire.getTopLevelAncestor();
		switch (btn.getText()) {
		// Suppression d'une location
		case "Archiver":
			Locataire locaitaire_supp = (Locataire) Sauvegarde.getItem("Louer");
			try {
				Locataire locataire = this.daoLocataire.findById(locaitaire_supp.getIdLocataire());
				this.daoLocataire.delete(locataire);
				this.daoLocataire.createArchive(locataire);
				this.dao
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.gestionArchiverLocataire.dispose();
			break;
		// Annulation de la suppression
		case "Annuler":
			this.gestionArchiverLocataire.dispose();
			break;
		}
	}
}
