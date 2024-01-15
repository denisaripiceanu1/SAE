package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.Locataire;
import modele.Louer;
import modele.Releve;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import modele.dao.DaoReleve;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverLocation;
import vue.insertion.Fenetre_AffichageInfoLocataire;
import vue.insertion.Fenetre_AffichageReleveCompteursBien;
import vue.insertion.Fenetre_InsertionReleve;

public class GestionAffichageReleveCompteurBien implements ActionListener {

	private Fenetre_AffichageReleveCompteursBien farcb;
	private DaoReleve daoReleve;

	public GestionAffichageReleveCompteurBien(Fenetre_AffichageReleveCompteursBien arcb) {
		this.farcb = arcb;
		this.daoReleve = new DaoReleve();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.farcb.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal																					// frame
		switch (btn.getText()) {
		case "Annuler":
			this.farcb.dispose();
			break;
		}
	}
	
	// Méthode pour écrire une ligne de compteur dans la table des compteurs
		public void ecrireLigneTableReleveCompteurs(int numeroLigne, Releve e) throws SQLException {
			JTable tableReleveCompteur = this.farcb.getTable_releve_compteur_bien();
			DefaultTableModel modeleTable = (DefaultTableModel) tableReleveCompteur.getModel();

			modeleTable.setValueAt(e.getDate_releve(), numeroLigne, 0);
			modeleTable.setValueAt(e.getIndexComp(), numeroLigne, 1);
		}

		// Méthode pour charger les compteurs dans la table des compteurs
		public void chargerReleveCompteurs() throws SQLException {
			// On récupère l'immeuble de la sauvegarde pour utiliser son ID 
			Compteur compteurSauvegarde = (Compteur) Sauvegarde.getItem("Compteur");
			
			List<Releve> releve = this.daoReleve.findReleveByCompteur(compteurSauvegarde.getIdCompteur());

			DefaultTableModel modeleTable = (DefaultTableModel) this.farcb.getTable_releve_compteur_bien().getModel();

			modeleTable.setRowCount(releve.size());

			for (int i = 0; i < releve.size(); i++) {
				Releve e = releve.get(i);
				this.ecrireLigneTableReleveCompteurs(i, e);
			}
		}


}