package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Assurance;
import modele.Bien;
import modele.Echeance;
import modele.Entreprise;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionAffichageInfoLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire fail;
	private DaoLocataire daoLocataire;
	private DaoLouer daoLouer;
	private DaoBien daoBien;

	public GestionAffichageInfoLocataire(Fenetre_AffichageInfoLocataire fail) {
		this.fail = fail;
		this.daoLocataire = new DaoLocataire();
		this.daoLouer = new DaoLouer();
		this.daoBien = new DaoBien();
	}

	public void ecrireLigneTableSoldeToutCompte(int numeroLigne, Louer location, /* Facture facture, */ Bien bien)
			throws SQLException {
		JTable tableSoldeToutCompte = this.fail.getTable_soldeToutCompte();
		DefaultTableModel modeleTable = (DefaultTableModel) tableSoldeToutCompte.getModel();

		// Total des provisions sur charges
		double totalProvisions = daoLouer.totalProvisions(location);
		modeleTable.setValueAt(totalProvisions, numeroLigne, 0);

		// Total charges reelles
		double chargesReellesBien = daoLouer.totalChargesRéelles(location);
		modeleTable.setValueAt(chargesReellesBien, numeroLigne, 1);

		// Caution
		modeleTable.setValueAt(location.getCautionTTC(), numeroLigne, 2);

		// Travaux imputables
		double travauxImputables = daoLouer.travauxImputables(location);
		modeleTable.setValueAt(travauxImputables, numeroLigne, 3);

		// Reste
		double soldeToutCompte = daoLouer.soldeToutCompte(location);
		modeleTable.setValueAt(soldeToutCompte, numeroLigne, 4);

	}

	private void chargerSoldeToutCompte() throws SQLException {
		List<Louer> locations = this.daoLouer.findAll();
		DefaultTableModel modeleTable = (DefaultTableModel) this.fail.getTable_soldeToutCompte().getModel();
		modeleTable.setRowCount(1);

		for (int i = 0; i < 2; i++) {
			Louer l = locations.get(i);
			Bien b = this.daoBien.findById(l.getBien().getIdBien());																					// les 10 premiers pour enlever
																					// "HH:MM"
			this.ecrireLigneTableSoldeToutCompte(i, l, b);
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
			try {
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
