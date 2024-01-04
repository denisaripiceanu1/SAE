package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Facture;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;

public class GestionTableCharges implements ListSelectionListener {

	// Référence à la fenêtre d'accueil
	private Fenetre_Accueil fenetreAccueil;

	// Accès à la couche d'accès aux données pour l'entité Facture
	private DaoFacture daoFacture;
	private DaoBien daoBien;

	// Constructeur prenant en paramètre la fenêtre d'accueil
	public GestionTableCharges(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		// Initialisation de l'accès à la base de données pour l'entité Facture et Bien
		this.daoFacture = new DaoFacture();
		this.daoBien = new DaoBien();
		// Initialisation de la sauvegarde
		Sauvegarde.initializeSave();
	}

	// Méthode appelée lorsqu'une sélection est modifiée dans la table des charges
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Vérifie si l'événement de sélection a été finalisé
		if (!e.getValueIsAdjusting()) {
			// Récupère l'indice de la ligne sélectionnée dans la table des charges
			// locatives
			int selectedRowCharge = this.fenetreAccueil.getTableChargesLocatives().getSelectedRow();

			// Vérifie si une ligne est effectivement sélectionnée
			if (selectedRowCharge > -1) {
				// Récupère la référence à la table des charges locatives
				JTable tableFacturesCharges = this.fenetreAccueil.getTableChargesLocatives();
				// Initialise une référence à l'objet Facture
				Facture facture = null;
				Bien bien = null;

				try {
					// Utilise les entiers 1 et 0 pour "deductible"
					int deductible = "Oui"
							.equalsIgnoreCase(tableFacturesCharges.getValueAt(selectedRowCharge, 2).toString()) ? 1 : 0;

					// Récupère l'objet Facture à partir des données de la ligne sélectionnée dans
					// la table
					facture = this.daoFacture.findById(tableFacturesCharges.getValueAt(selectedRowCharge, 1).toString() // numéro
																														// de
																														// facture
					);

					// Récupère l'objet Bien à partir des données de la ligne sélectionnée dans la
					// table
					bien = this.daoBien.findById(tableFacturesCharges.getValueAt(selectedRowCharge, 0).toString() // Id_Bien
					);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				// Supprimer l'élément CHARGE précédemment sauvegardé et sauvegarder le nouvel
				// élément
				Sauvegarde.deleteItem("Charge");
				Sauvegarde.addItem("Charge", facture);
				// Supprimer l'élément LOGEMENT précédemment sauvegardé et sauvegarder le nouvel
				// élément
				Sauvegarde.deleteItem("Logement");
				Sauvegarde.addItem("Logement", bien);
			}
		}
	}

}
