package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;

public class GestionTableTravaux implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoFacture daoFacture;

	public GestionTableTravaux(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			int selectedRowTravaux = this.fenetreAccueil.getTableTravaux().getSelectedRow();

			if (selectedRowTravaux > -1) {
				JTable tableTravaux = this.fenetreAccueil.getTableTravaux();
				Facture travaux = null;
				try {
					travaux = this.daoFacture.findById(tableTravaux.getValueAt(selectedRowTravaux, 0).toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Sauvegarde.deleteItem("Facture");
				Sauvegarde.addItem("Facture", travaux);

			}
		}
	}
}
