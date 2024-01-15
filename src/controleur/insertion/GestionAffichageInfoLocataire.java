package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
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

		// Total charges reelles
		double chargesReellesBien = daoLouer.totalChargesRéelles(location);
		modeleTable.setValueAt(chargesReellesBien, numeroLigne, 2);

		// Travaux imputables
		double travauxImputables = daoLouer.travauxImputables(location);
		modeleTable.setValueAt(travauxImputables, numeroLigne, 6);

		// Total des provisions sur charges
		double totalProvisions = daoLouer.totalProvisions(location);
		modeleTable.setValueAt(totalProvisions, numeroLigne, 0);

		// Caution
		modeleTable.setValueAt(location.getCautionTTC(), numeroLigne, 4);

		// Reste
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
			this.fail.dispose();
			fenetre_Principale.getGestionAccueil()
					.rendreVisible(fenetre_Principale.getLayeredPane_RegularisationDesCharges());
			Locataire locataire_save = (Locataire) Sauvegarde.getItem("Locataire");
			String idLocataire = locataire_save.getIdLocataire();
			fenetre_Principale.getGestionAccueil().filtreRegularisationChargesDepuisInfoLocataire(idLocataire);
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

}