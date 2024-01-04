package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Echeance;
import modele.dao.DaoAssurance;
import modele.dao.DaoEcheance;
import vue.Fenetre_Accueil;

public class GestionTableAssurance implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;

	public GestionTableAssurance(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			// Récupération de l'index de la ligne sélectionnée dans la table des assurances
			int selectedRowAssurance = this.fenetreAccueil.getTableAssurances().getSelectedRow();

			if (selectedRowAssurance > -1) {
				JTable tableAssurance = this.fenetreAccueil.getTableAssurances();
				Assurance assurance = null;
				Echeance echeance = null;
				try {
					// Récupération de l'objet Assurance associé à la ligne sélectionnée
					assurance = this.daoAssurance.findById(tableAssurance.getValueAt(selectedRowAssurance, 0).toString());
					
					// Récupération de l'objet Echeance associé à la ligne sélectionnée
					echeance = this.daoEcheance.findById(tableAssurance.getValueAt(selectedRowAssurance, 0).toString(),
							tableAssurance.getValueAt(selectedRowAssurance, 2).toString());

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				// Mise à jour de la sauvegarde avec les objets Assurance et Echeance
				Sauvegarde.deleteItem("Echeance");
				Sauvegarde.deleteItem("Assurance");
				Sauvegarde.addItem("Echeance", echeance);
				Sauvegarde.addItem("Assurance", assurance);

			}
		}
	}
}
