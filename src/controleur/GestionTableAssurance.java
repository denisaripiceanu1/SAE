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

			int selectedRowAssurance = this.fenetreAccueil.getTableAssurances().getSelectedRow();

			if (selectedRowAssurance > -1) {
				JTable tableAssurance = this.fenetreAccueil.getTableAssurances();
				Assurance assurance = null;
				Echeance echeance = null;
				try {
					assurance = this.daoAssurance
							.findById(tableAssurance.getValueAt(selectedRowAssurance, 0).toString());
					echeance = this.daoEcheance.findById(tableAssurance.getValueAt(selectedRowAssurance, 0).toString(),
							tableAssurance.getValueAt(selectedRowAssurance, 2).toString());

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Sauvegarde.deleteItem("Echeance");
				Sauvegarde.deleteItem("Assurance");
				Sauvegarde.addItem("Echeance", echeance);
				Sauvegarde.addItem("Assurance", assurance);

			}
		}
	}
}
