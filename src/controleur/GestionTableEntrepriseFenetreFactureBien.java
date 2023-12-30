package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.insertion.Fenetre_InsertionPaiementBien;

public class GestionTableEntrepriseFenetreFactureBien implements ListSelectionListener {

	private Fenetre_InsertionPaiementBien fipb;
	private DaoEntreprise daoEntreprise;

	public GestionTableEntrepriseFenetreFactureBien(Fenetre_InsertionPaiementBien fipb) {
		this.fipb = fipb;
		this.daoEntreprise = new DaoEntreprise();
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			int selectedRowEntreprise = this.fipb.getTable_entreprise().getSelectedRow();

			if (selectedRowEntreprise > -1) {
				JTable tableEntreprise = this.fipb.getTable_entreprise();
				Entreprise entreprise = null;
				try {
					entreprise = this.daoEntreprise.findById(tableEntreprise.getValueAt(selectedRowEntreprise, 0).toString(),
							tableEntreprise.getValueAt(selectedRowEntreprise, 1).toString());
					
				    System.out.println("entrepriseSauvegarde depuis le tableau: " + entreprise);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Sauvegarde.deleteItem("Entreprise");
				Sauvegarde.addItem("Entreprise", entreprise);
			}
		}
	}
}

