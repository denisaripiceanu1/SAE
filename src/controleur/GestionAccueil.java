package controleur;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Immeuble;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCharges;
import vue.insertion.Fenetre_InsertionDiagnostic;
import vue.insertion.Fenetre_InsertionLocation;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionTravaux;

public class GestionAccueil implements ActionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoImmeuble daoImmeuble;

	public GestionAccueil(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoImmeuble = new DaoImmeuble();
	}

	public void rendreVisible(JLayeredPane visible) {
		this.fenetreAccueil.getLayeredPane_Accueil().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesBiens().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesTravaux().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesChargesLocatives().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesLocations().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesAssurances().setVisible(false);
		this.fenetreAccueil.getLayeredPane_RegularisationDesCharges().setVisible(false);
		// this.fenetreAccueil.getLayeredPane_SoldeDeToutCompte().setVisible(false);
		// this.fenetreAccueil.getLayeredPane_MesDocuments().setVisible(false);

		visible.setVisible(true);
		this.fenetreAccueil.getContentPane().add(visible, BorderLayout.CENTER);
	}

	public void ecrireLigneTable(int numeroLigne, Immeuble immeuble) {
		JTable tableImmeuble = fenetreAccueil.getTableBiens();
		DefaultTableModel modeleTable = (DefaultTableModel) tableImmeuble.getModel();

		modeleTable.setValueAt(immeuble.getImmeuble(), numeroLigne, 0);
		modeleTable.setValueAt(immeuble.getAdresse() + "\n" + immeuble.getCp() + " " + immeuble.getVille(), numeroLigne,
				1);
		modeleTable.setValueAt(immeuble.getNbLogement(), numeroLigne, 2);
	}

	private void chargerBiens() throws SQLException {

		List<Immeuble> immeubles = daoImmeuble.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) fenetreAccueil.getTableBiens().getModel();

		modeleTable.setRowCount(immeubles.size());

		for (int i = 0; i < immeubles.size(); i++) {
			Immeuble immeuble = immeubles.get(i);
			ecrireLigneTable(i, immeuble);
		}
	}

	public static void viderTable(JTable table) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		int rowCount = modeleTable.getRowCount();
		int columnCount = modeleTable.getColumnCount();

		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < columnCount; col++) {
				modeleTable.setValueAt(null, row, col);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch (btn.getName()) { // a partir du nom des boutons

		// NAVIGATION ENTRE LES LAYEREDPANE
		case "btnAccueil":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_Accueil());
			break;
		case "btnMesBiens":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesBiens());
			break;
		case "btnMesLocations":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesLocations());
			break;
		case "btnMesTravaux":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesTravaux());
			break;
		case "btnMesChargesLocatives":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesChargesLocatives());
			break;
		case "btnMesAssurances":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesAssurances());
			break;
		case "btnRegularisationDesCharges":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_RegularisationDesCharges());
			break;
		case "btnSoldeDeToutCompte":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_SoldeDeToutCompte());
			break;
		case "btnMesDocuments":
			this.rendreVisible(this.fenetreAccueil.getLayeredPane_MesDocuments());
			break;
		///////////////////
		// LAYERED MES BIENS
		///////////////////
		case "btnMesBiens_Charger":
			try {
				chargerBiens();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "btnMesBiens_Supprimer":
			break;
		case "btnMesBiens_Modifier":
			break;

		case "btnMesBiens_AjouterBien":
			Fenetre_InsertionBien insertion_bien = new Fenetre_InsertionBien();
			this.fenetreAccueil.getLayeredPane().add(insertion_bien);
			insertion_bien.setVisible(true);
			insertion_bien.moveToFront();
			break;
		case "btnMesBiens_AjouterDiagnostic": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE
												// LIGNE DU TABLEAU
			Fenetre_InsertionDiagnostic diagnostic_bien = new Fenetre_InsertionDiagnostic();
			this.fenetreAccueil.getLayeredPane().add(diagnostic_bien);
			diagnostic_bien.setVisible(true);
			diagnostic_bien.moveToFront();
			break;
		case "btnMesBiens_AjouterDesTravaux": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE
												// LIGNE DU TABLEAU
			Fenetre_InsertionTravaux travaux_bien = new Fenetre_InsertionTravaux();
			this.fenetreAccueil.getLayeredPane().add(travaux_bien);
			travaux_bien.setVisible(true);
			travaux_bien.moveToFront();
			break;

		case "btnMesBiens_AjouterLogement":
			Fenetre_InsertionLogement insertion_logement = new Fenetre_InsertionLogement();
			this.fenetreAccueil.getLayeredPane().add(insertion_logement);
			insertion_logement.setVisible(true);
			insertion_logement.moveToFront();
			break;
		case "btnMesBiens_AjouterDiagnostic_Logements": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA
														// SELECTION D'UNE LIGNE DU TABLEAU
			Fenetre_InsertionDiagnostic diagnostic_logement = new Fenetre_InsertionDiagnostic();
			this.fenetreAccueil.getLayeredPane().add(diagnostic_logement);
			diagnostic_logement.setVisible(true);
			diagnostic_logement.moveToFront();
			break;
		case "btnMesBiens_AjouterDesTravaux_Logements": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA
														// SELECTION D'UNE LIGNE DU TABLEAU
			Fenetre_InsertionTravaux travaux_logement = new Fenetre_InsertionTravaux();
			this.fenetreAccueil.getLayeredPane().add(travaux_logement);
			travaux_logement.setVisible(true);
			travaux_logement.moveToFront();
			break;
		///////////////////////
		// LAYERED MES LOCATIONS
		///////////////////////
		case "btn_MesLocations_Charger":
			break;
		case "btn_MesLocations_Modifier":
			break;
		case "btn_MesLocations_Inserer":
			Fenetre_InsertionLocation location = new Fenetre_InsertionLocation();
			this.fenetreAccueil.getLayeredPane().add(location);
			location.setVisible(true);
			location.moveToFront();
			break;
		case "btn_MesLocations_Supprimer":
			break;

		case "btn_mesLocations_InfoLocataire": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE
												// LIGNE DU TABLEAU
			Fenetre_AffichageInfoLocataire infos_locataire = new Fenetre_AffichageInfoLocataire();
			this.fenetreAccueil.getLayeredPane().add(infos_locataire);
			infos_locataire.setVisible(true);
			infos_locataire.moveToFront();
			break;
		/////////////////////
		// LAYERED MES TRAVAUX
		/////////////////////
		case "btn_Travaux_Modifier":
			break;
		case "btn_Travaux_Supprimer":
			break;

		case "tglbtn_Travaux_immeubles":
			// Permet de trier le tableau de travaux en n'affichant que ceux concernants les
			// immeubles
			break;
		case "tglbtn_Travaux_logements":
			// Permet de trier le tableau de travaux en n'affichant que ceux concernants les
			// logements
			break;
		///////////////////////////////
		// LAYERED MES CHARGES LOCATIVES
		///////////////////////////////
		case "btn_MesChargesLocatives_Charger":
			break;
		case "btn_MesChargesLocatives_Modifier":
			break;
		case "btn_MesChargesLocatives_Inserer":
			Fenetre_InsertionCharges charges = new Fenetre_InsertionCharges();
			this.fenetreAccueil.getLayeredPane().add(charges);
			charges.setVisible(true);
			charges.moveToFront();
			break;
		case "btn_MesChargesLocatives_Supprimer":
			break;

		// Coder la cas de la selection d'un id logement
		// parmi la liste présente dans le JComboBox "comboBox_MesChargesLocatives"

		////////////////////////
		// LAYERED MES ASSURANCES
		////////////////////////
		case "btn_MesAssurances_Charger":
			break;
		case "btn_MesAssurances_Modifier":
			break;
		case "btn_MesAssurances_Inserer":
			Fenetre_InsertionAssurance insertion_assurance = new Fenetre_InsertionAssurance();
			this.fenetreAccueil.getLayeredPane().add(insertion_assurance);
			insertion_assurance.setVisible(true);
			insertion_assurance.moveToFront();
			break;
		case "btn_MesAssurances_Supprimer":
			break;

		// Coder la cas de la selection d'un id logement
		// parmi la liste présente dans le JComboBox "comboBox_MesAssurances"

		////////////////////////////////////
		// LAYERED REGULARISATION DES CHARGES
		////////////////////////////////////

		// Coder la cas de la selection d'un locataire
		// parmi la liste présente dans le JComboBox "comboBox_Regularisation"

		///////////////////////////
		// LAYERED SOLDE TOUT COMPTE
		///////////////////////////

		///////////////////////
		// LAYERED MES DOCUMENTS
		///////////////////////

		}
	}

}
