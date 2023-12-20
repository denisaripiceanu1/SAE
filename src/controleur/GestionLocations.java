package controleur;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Facture;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionLocations implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private Fenetre_AffichageInfoLocataire fail;
	private DaoLouer daoLouer;
	private DaoFacture daoFacture;
	private DaoLocataire daoLocataire;
	private DaoBien daoBien;

	public GestionLocations(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoLouer = new DaoLouer();
		this.daoFacture = new DaoFacture();
		this.daoLocataire = new DaoLocataire();
		this.daoBien = new DaoBien();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = fenetreAccueil.getTableLocations().getSelectedRow();

			if (selectedRow > -1) {
				JTable tableLocations = fenetreAccueil.getTableLocations();
				Louer location = null;
				Locataire locataire = null;
				Bien bien = null;
				try {
					// On va extraire le locataire de la location pour pouvoir ensuite afficher
					// plusieurs inforamtions qui le concerne
					location = daoLouer.findById(tableLocations.getValueAt(selectedRow, 1).toString(),
							tableLocations.getValueAt(selectedRow, 0).toString());

					// On ajoute le locataire a la sauvegarde
					locataire = daoLocataire.findById(tableLocations.getValueAt(selectedRow, 0).toString());
					Sauvegarde.deleteItem("Locataire");
					Sauvegarde.addItem("Locataire", locataire);

					// On va extraire le bien de la location pour pouvoir ensuite ajouter une
					// facture pour ce bien
					bien = daoBien.findById(tableLocations.getValueAt(selectedRow, 1).toString());
					// On ajoute le bien a la sauvegarde
					Sauvegarde.deleteItem("Logement");
					Sauvegarde.addItem("Logement", locataire);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (location != null) {
					Facture derniereFactureLoyer = null;

					try {
						derniereFactureLoyer = daoFacture.findDerniereFactureLoyer(location.getBien());

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					JTextField loyer = fenetreAccueil.getTextField_loyer();
					loyer.setText(String.valueOf(location.getLoyerTTC()));

					JTextField dateEmission = fenetreAccueil.getTextField_dateEmission();
					JTextField dateEcheance = fenetreAccueil.getTextField_dateEcheance();

					// Vérification si la facture et sa date d'émission ne sont pas null
					if (derniereFactureLoyer != null) {
						dateEmission.setText(derniereFactureLoyer.getDateEmission());
						dateEcheance.setText(derniereFactureLoyer.getDatePaiement());
					} else {
						dateEmission.setText("N/A");
						dateEcheance.setText("N/A");
					}

					JTextField paye = fenetreAccueil.getTextField_paye();
					paye.setText(String.valueOf(location.getMontantReelPaye()));

					JTextField restantDu = fenetreAccueil.getTextField_restantDu();
					restantDu.setText(String.valueOf(location.getLoyerTTC() + location.getProvision_chargeMens_TTC()
							- location.getMontantReelPaye()));

					JTextField caution = fenetreAccueil.getTextField_caution();
					caution.setText(String.valueOf(location.getCautionTTC()));

					JTextField provision = fenetreAccueil.getTextField_provisionCharges();
					provision.setText(String.valueOf(location.getProvision_chargeMens_TTC()));

				}
			}
		}
	}
}
