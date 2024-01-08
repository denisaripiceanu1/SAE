package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Facture;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;

public class GestionTableTravaux implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoFacture daoFacture;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;

	public GestionTableTravaux(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoFacture = new DaoFacture();
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			// Vérifie si la sélection dans la table des travaux a changé
			int selectedRowTravaux = this.fenetreAccueil.getTableTravaux().getSelectedRow();

			if (selectedRowTravaux > -1) {
				// Si une ligne est sélectionnée
				JTable tableTravaux = this.fenetreAccueil.getTableTravaux();
				Facture travaux = null;
				Bien bien = null;
				Immeuble immeuble = null;
				try {
					// Récupération de l'objet Facture associé à la ligne sélectionnée
					travaux = this.daoFacture.findById(tableTravaux.getValueAt(selectedRowTravaux, 0).toString());

					bien = this.daoBien.findById(tableTravaux.getValueAt(selectedRowTravaux, 1).toString());

					immeuble = this.daoImmeuble.findById(tableTravaux.getValueAt(selectedRowTravaux, 1).toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// Mise à jour de la sauvegarde avec l'objet Facture sélectionné
				Sauvegarde.deleteItem("Facture");
				Sauvegarde.addItem("Facture", travaux);
				if (bien != null) {
					Sauvegarde.deleteItem("Logement");
					Sauvegarde.addItem("Logement", bien);
				} else {
					Sauvegarde.deleteItem("Immeuble");
					Sauvegarde.addItem("Immeuble", immeuble);
				}
			}
		}
	}
}
