package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.archiver.Fenetre_ArchiverLocataire;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionAffichageInfoLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire fail;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;
	private DaoBien daoBien;
	private Louer location;

	public GestionAffichageInfoLocataire(Fenetre_AffichageInfoLocataire fail) {
		this.fail = fail;
		this.daoLocataire = new DaoLocataire();
		this.daoLouer = new DaoLouer();
		this.daoBien = new DaoBien();
		this.location = (Louer) Sauvegarde.getItem("Louer");

	}

	public void ecrireLigneTableSoldeToutCompte(int numeroLigne, Louer location, /* Facture facture, */ Bien bien)
			throws SQLException {
		JTable tableSoldeToutCompte = this.fail.getTable_soldeToutCompte();
		DefaultTableModel modeleTable = (DefaultTableModel) tableSoldeToutCompte.getModel();

		// charges reelles
		double chargesReellesBien = daoLouer.totalChargesRéelles(location);
		// ordures menageres
		double orduresMenageres = this.daoLouer.totalOrduresMenageres(location);

		modeleTable.setValueAt(chargesReellesBien + orduresMenageres, numeroLigne, 2);

		// Travaux imputables
		double travauxImputables = daoLouer.travauxImputables(location);
		modeleTable.setValueAt(travauxImputables, numeroLigne, 6);

		// Total des provisions sur charges
		double totalProvisions = daoLouer.totalProvisions(location);
		modeleTable.setValueAt(totalProvisions, numeroLigne, 0);

		// Caution
		modeleTable.setValueAt(location.getCautionTTC(), numeroLigne, 4);

		// Reste
		// double soldeToutCompte = daoLouer.soldeToutCompte(location);
		double soldeToutCompte = daoLouer.soldeToutCompte(location);

		modeleTable.setValueAt(soldeToutCompte, numeroLigne, 8);

		modeleTable.setValueAt("-", numeroLigne, 1);
		modeleTable.setValueAt("+", numeroLigne, 3);
		modeleTable.setValueAt("-", numeroLigne, 5);
		modeleTable.setValueAt("=", numeroLigne, 7);
	}

	private void chargerSoldeToutCompte() throws SQLException {
		List<Louer> locations = this.daoLouer.findLocationByBien(location.getBien().getIdBien());
		DefaultTableModel modeleTable = (DefaultTableModel) this.fail.getTable_soldeToutCompte().getModel();
		modeleTable.setRowCount(1);

		for (int i = 0; i < locations.size(); i++) {
			Louer l = locations.get(i);
			Bien b = this.daoBien.findById(l.getBien().getIdBien()); // les 10 premiers pour enlever
			// "HH:MM"
			this.ecrireLigneTableSoldeToutCompte(i, l, b);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fail.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Régularisation des charges":
			Locataire locataire_save = (Locataire) Sauvegarde.getItem("Locataire");
			String idLocataire = locataire_save.getIdLocataire();
			try {
				this.updateTableRegularisationsForLocataire(idLocataire);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;

		case "Solde tout compte":
			try {
				if (Sauvegarde.onSave("Louer") == true) {
					Louer locSauvegarde = (Louer) Sauvegarde.getItem("Louer");
					Fenetre_ArchiverLocataire archiver_locataire = new Fenetre_ArchiverLocataire();
					this.fail.getLayeredPane().add(archiver_locataire);
					archiver_locataire.setVisible(true);
					archiver_locataire.moveToFront();
				} else {
					JOptionPane.showMessageDialog(this.fail, "Veuillez sélectionner une location !", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
				this.chargerSoldeToutCompte();
			} catch (SQLException e1) {
				// Afficher un message d'erreur à l'utilisateur
				e1.printStackTrace();
				// Affichage d'une boîte de dialogue avec le message d'erreur
				JOptionPane.showMessageDialog(null,
						"Erreur lors du chargement des soldes de tout compte. Veuillez réessayer plus tard.",
						"Erreur de chargement", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
	}

	////////////////////////////////////////////
	////////////// REGULARISATION //////////////
	////////////////////////////////////////////

	public void ecrireLigneTableRegularisation(int numeroLigne, Louer location) throws SQLException {
		JTable tableRegularisation = this.fail.getTableRegularisation();
		DefaultTableModel modeleTable = (DefaultTableModel) tableRegularisation.getModel();
		// Periode du
		modeleTable.setValueAt(location.getBien().getIdBien(), numeroLigne, 0);
		modeleTable.setValueAt(location.getDateDebut(), numeroLigne, 1);
		// au
		if (location.getDateDerniereRegularisation() != null) {
			modeleTable.setValueAt(location.getDateDerniereRegularisation(), numeroLigne, 2);
		} else {
			modeleTable.setValueAt("N/A", numeroLigne, 2);
		}
		// Charges reelles
		double chargesReellesBien = this.daoLouer.totalChargesRéelles(location);
		modeleTable.setValueAt(chargesReellesBien, numeroLigne, 3);
		// Ordures menageres
		double orduresMenageres = this.daoLouer.totalOrduresMenageres(location);
		modeleTable.setValueAt(orduresMenageres, numeroLigne, 4);
		// TOTAL charges
		double totalCharges = chargesReellesBien + orduresMenageres;
		modeleTable.setValueAt(totalCharges, numeroLigne, 5);
		// Restant du Loyers
		double restantDuLoyers = this.daoLouer.restantDuLoyers(location);
		modeleTable.setValueAt(restantDuLoyers, numeroLigne, 6);
		// Total des provisions sur charges
		double totalProvisions = this.daoLouer.totalProvisions(location);
		modeleTable.setValueAt(totalProvisions, numeroLigne, 7);
		// TOTAL
		double regularisationCharges = this.daoLouer.regularisationCharges(location);
		modeleTable.setValueAt(regularisationCharges, numeroLigne, 8);

	}

	private void updateTableRegularisationsForLocataire(String idLocataire) throws SQLException {
		Bien bien = (Bien) Sauvegarde.getItem("Logement");
		Louer location = this.daoLouer.findById(bien.getIdBien(), idLocataire);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fail.getTableRegularisation().getModel();
		modeleTable.setRowCount(1); // Toujours une seule ligne puisque il s'agit d'un locataire et de son bien pour
									// une location
		this.ecrireLigneTableRegularisation(0, location); // Ecrit la ligne

	}

}