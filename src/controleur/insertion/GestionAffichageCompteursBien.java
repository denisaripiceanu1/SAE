package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoCompteur;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageCompteursBien;
import vue.insertion.Fenetre_InsertionEntreprise;
import vue.insertion.Fenetre_InsertionPaiementBien;
import vue.insertion.Fenetre_InsertionPaiementLogement;
import vue.insertion.Fenetre_InsertionReleve;

public class GestionAffichageCompteursBien implements ActionListener {
	
	private Fenetre_AffichageCompteursBien facb;
	private DaoCompteur daoCompteur;

	// Constructeur prenant en paramètre la fenêtre d'affichage des compteurs
	public GestionAffichageCompteursBien(Fenetre_AffichageCompteursBien fenetre_AffichageCompteursBiens) {
		this.facb = fenetre_AffichageCompteursBiens;
		// Initialisation de l'accès à la base de données pour l'entité Compteur
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.facb.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter un relevé":
			if (Sauvegarde.onSave("Compteur") == true) {
				Fenetre_InsertionReleve insertion_releve = new Fenetre_InsertionReleve();
				fenetre_Principale.getLayeredPane().add(insertion_releve);
				insertion_releve.setVisible(true);
				insertion_releve.moveToFront();
			} else {
				JOptionPane.showMessageDialog(fenetre_Principale, "Veuillez sélectionner un compteur !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		case "Annuler":
			this.facb.dispose();
			break;
		}
	}

	// Méthode pour écrire une ligne de compteur dans la table des compteurs
	public void ecrireLigneTableCompteurs(int numeroLigne, Compteur e) throws SQLException {
		JTable tableCompteur = this.facb.getTable_compteurs();
		DefaultTableModel modeleTable = (DefaultTableModel) tableCompteur.getModel();

		modeleTable.setValueAt(e.getIdCompteur(), numeroLigne, 0);
		modeleTable.setValueAt(e.getTypeComp(), numeroLigne, 1);
		modeleTable.setValueAt(e.getPrix_abonnement(), numeroLigne, 2);
	}

	// Méthode pour charger les compteurs dans la table des compteurs
	public void chargerCompteurs() throws SQLException {
		// On récupère l'immeuble de la sauvegarde pour utiliser son ID 
		Immeuble immeubleSauvegarde = (Immeuble) Sauvegarde.getItem("Immeuble");
		
		List<Compteur> compteurs = this.daoCompteur.findByIdImmeubleListe(immeubleSauvegarde.getImmeuble());

		DefaultTableModel modeleTable = (DefaultTableModel) this.facb.getTable_compteurs().getModel();

		modeleTable.setRowCount(compteurs.size());

		for (int i = 0; i < compteurs.size(); i++) {
			Compteur e = compteurs.get(i);
			this.ecrireLigneTableCompteurs(i, e);
		}
	}

}
