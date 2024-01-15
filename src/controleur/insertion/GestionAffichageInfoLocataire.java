package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bien;
import modele.Louer;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionAffichageInfoLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire fail;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;

	public GestionAffichageInfoLocataire(Fenetre_AffichageInfoLocataire fail) {
		this.fail = fail;
		this.daoLocataire = new DaoLocataire();
		this.daoLouer = new DaoLouer();
	}

	public void ecrireLigneTableRegularisation(int numeroLigne, Louer location, /* Facture facture, */ Bien bien)
			throws SQLException {
		JTable tableRegularisation = this.fenetreAccueil.getTableRegularisation();
		DefaultTableModel modeleTable = (DefaultTableModel) tableRegularisation.getModel();

		modeleTable.setValueAt(location.getDateDebut(), numeroLigne, 0);
		if (location.getDateDerniereRegularisation() != null) {
			modeleTable.setValueAt(location.getDateDerniereRegularisation(), numeroLigne, 1);
		} else {
			modeleTable.setValueAt("N/A", numeroLigne, 1);
		}
		// Total charges reelles
		double chargesReellesBien = daoLouer.totalChargesRéelles(location);
		modeleTable.setValueAt(chargesReellesBien, numeroLigne, 2);
		// Charges garages
		double chargesGarage = daoLouer.totalChargesGarages(location);
		if (chargesGarage != 0) {
			modeleTable.setValueAt(chargesGarage, numeroLigne, 3);
		}else {
			modeleTable.setValueAt("N/A", numeroLigne, 3);
		}
		// Total des provisions sur charges
		double totalProvisions = daoLouer.totalProvisions(location);
		modeleTable.setValueAt(totalProvisions, numeroLigne, 4);
		// TOTAL
		double regularisationCharges = daoLouer.regularisationCharges(location);
		modeleTable.setValueAt(regularisationCharges, numeroLigne, 5);

	}

	private void updateTableRegularisationsForLocataire(String idLocataire) throws SQLException {
		List<Louer> locations = this.daoLouer.findByLocataire(idLocataire);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableRegularisation().getModel();
		modeleTable.setRowCount(locations.size());

		for (int i = 0; i < locations.size(); i++) {
			Louer l = locations.get(i);
			Bien bien = this.daoBien.findById(l.getBien().getIdBien());

			this.ecrireLigneTableRegularisation(i, l, bien);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fail.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Régularisation des charges ":
			this.fail.dispose();
			
			fenetre_Principale.getLayeredPane_RegularisationDesCharges();
			fenetre_Principale.getLayeredPane_RegularisationDesCharges().setVisible(true);
			break;

		case "Solde tout compte":
			break;
		}
	}

}
