package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Facture;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;

public class GestionTableCharges implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoFacture daoFacture;

	public GestionTableCharges(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoFacture = new DaoFacture();
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			int selectedRowCharge = this.fenetreAccueil.getTableChargesLocatives().getSelectedRow();

			if (selectedRowCharge > -1) {
				JTable tableFacturesCharges = this.fenetreAccueil.getTableChargesLocatives();
				Facture facture = null;
				try {
					// Correction : Utilisez les entiers 1 et 0 pour deductible
					int deductible = "Oui"
							.equalsIgnoreCase(tableFacturesCharges.getValueAt(selectedRowCharge, 2).toString()) ? 1 : 0;

					facture = this.daoFacture.findById(tableFacturesCharges.getValueAt(selectedRowCharge, 0).toString() // numero
					);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Sauvegarde.deleteItem("Facture");
				Sauvegarde.addItem("Facture", facture);
			}
		}
	}

}
