package controleur;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Bien;
import modele.Echeance;
import modele.Entreprise;
import modele.Facture;
import modele.Immeuble;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoEcheance;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionDiagnostic;
import vue.insertion.Fenetre_InsertionLocation;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionPaiementBien;
import vue.insertion.Fenetre_InsertionPaiementLogement;
import vue.modification.Fenetre_ModificationBien;
import vue.modification.Fenetre_ModificationLogement;
import vue.suppression.Fenetre_SupprimerAssurance;
import vue.suppression.Fenetre_SupprimerBien;
import vue.suppression.Fenetre_SupprimerFactureCharge;
import vue.suppression.Fenetre_SupprimerTravaux;

public class GestionAccueil implements ActionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoImmeuble daoImmeuble;
	private DaoLouer daoLouer;
	private DaoBien daoBien;
	private DaoAssurance daoAssurance;
	private DaoEcheance daoEcheance;
	private DaoEntreprise daoEntreprise;
	private DaoFacture daoFacture;
	private DaoLocataire daoLocataire;

	public GestionAccueil(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		this.daoLouer = new DaoLouer();
		this.daoAssurance = new DaoAssurance();
		this.daoEcheance = new DaoEcheance();
		this.daoEntreprise = new DaoEntreprise();
		this.daoFacture = new DaoFacture();
		this.daoLocataire = new DaoLocataire();
	}

	// ENLEVER LES PAGES DE COMMENTAIRES QUAND ELLES SERONT DECOMMENTER DANS LA PAGE
	// ACCUEIL
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

	///////////////////////////////////////////////////////////////////
	// LAYERED MES BIENS
	///////////////////////////////////////////////////////////////////

	// ------------------- TABLE BIENS ------------------- //

	public void ecrireLigneTableBiens(int numeroLigne, Immeuble immeuble) throws SQLException {
		JTable tableImmeuble = this.fenetreAccueil.getTableBiens();
		DefaultTableModel modeleTable = (DefaultTableModel) tableImmeuble.getModel();

		modeleTable.setValueAt(immeuble.getImmeuble(), numeroLigne, 0);
		modeleTable.setValueAt(immeuble.getAdresse() + "\n" + immeuble.getCp() + " " + immeuble.getVille(), numeroLigne,
				1);
		
		int nb = this.daoImmeuble.getNombreLogementsDansImmeuble(immeuble.getImmeuble());
		modeleTable.setValueAt(nb, numeroLigne, 2);//rajouter une méthode count pour le nb logement
	}

	private void chargerBiens() throws SQLException {

		List<Immeuble> immeubles = this.daoImmeuble.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableBiens().getModel();

		modeleTable.setRowCount(immeubles.size());

		for (int i = 0; i < immeubles.size(); i++) {
			Immeuble immeuble = immeubles.get(i);
			this.ecrireLigneTableBiens(i, immeuble);
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// LAYERED MES
	// LOCATIONS////////////////////////////////////////////////////////////////

	// ------------------- TABLE LOCATIONS ------------------- //

	public void ecrireLigneTableLocations(int numeroLigne, Louer location, Bien bien) {
		JTable tableLocations = this.fenetreAccueil.getTableLocations();
		DefaultTableModel modeleTable = (DefaultTableModel) tableLocations.getModel();

		modeleTable.setValueAt(location.getLocataire(), numeroLigne, 0);
		modeleTable.setValueAt(location.getBien(), numeroLigne, 1);
		modeleTable.setValueAt(bien.getType_bien(), numeroLigne, 2);
	}

	private void chargerLocations() throws SQLException {
		List<Bien> biens = this.daoBien.findAll();
		List<Louer> locations = new ArrayList<>();

		for (Bien b : biens) {
			locations.addAll(this.daoLouer.findLocationByBien(b.getIdBien())); // Ajouter toutes les locations du bien Ã
																				// la liste
		}

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableLocations().getModel();
		modeleTable.setRowCount(locations.size());

		for (int i = 0; i < locations.size(); i++) {
			Louer location = locations.get(i);
			Bien bien = location.getBien();
			this.ecrireLigneTableLocations(i, location, bien);
		}
	}

	//////////////////////////////////////////////////////////////////////////
	// LAYERED MES
	// TRAVAUX////////////////////////////////////////////////////////////////

	// ------------------- TABLE TRAVAUX pour un IMMEUBLE ------------------- //

	private void chargerTravauxImmeubles() throws SQLException {
		List<Facture> factures = this.daoFacture.findFactureTravaux();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableTravaux().getModel();
		modeleTable.setRowCount(0); // Efface toutes les lignes existantes

		for (int i = 0; i < factures.size(); i++) {
			Facture f = factures.get(i);
			if (f != null && f.getImmeuble() != null) {
				Entreprise entreprise = this.daoEntreprise.findById(f.getEntreprise().getSiret());
				modeleTable.addRow(new Object[] { f.getNumero(), f.getImmeuble().getImmeuble(), f.getDesignation(),
						f.getDateEmission(), f.getMontant(), f.getAccompteVerse(), entreprise.getNom(),
						entreprise.getAdresse() + " " + entreprise.getCp() + " " + entreprise.getVille() });
			}
		}
	}

	// ------------------- TABLE TRAVAUX pour un LOGEMENT ------------------- //

	private void chargerTravauxLogements() throws SQLException {
		List<Facture> factures = this.daoFacture.findFactureTravaux();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableTravaux().getModel();
		modeleTable.setRowCount(0); // Efface toutes les lignes existantes

		for (int i = 0; i < factures.size(); i++) {
			Facture f = factures.get(i);
			if (f != null && f.getBien() != null) {
				Entreprise entreprise = this.daoEntreprise.findById(f.getEntreprise().getSiret());
				modeleTable.addRow(new Object[] {f.getNumero(), f.getBien().getIdBien(), f.getDesignation(), f.getDateEmission(),
						f.getMontant(), f.getAccompteVerse(), entreprise.getNom(),
						entreprise.getAdresse() + " " + entreprise.getCp() + " " + entreprise.getVille() });
			}
		}
	}

	///////////////////////////////////////////////////////////////////
	// LAYERED MES CHARGES LOCATIVES
	// ////////////////////////////////////////////////////////////////

	// ------------------- TABLE CHARGES pour un LOGEMENT ------------------- //
	
	public void ecrireLigneTableChargesLocatives(int numeroLigne, Facture charge) {
		JTable tableChargesLocatives = this.fenetreAccueil.getTableChargesLocatives();
		DefaultTableModel modeleTable = (DefaultTableModel) tableChargesLocatives.getModel();

		modeleTable.setValueAt(charge.getNumero(), numeroLigne, 0);
		modeleTable.setValueAt(charge.getDesignation(), numeroLigne, 1);
		modeleTable.setValueAt(charge.getDateEmission(), numeroLigne, 2);
		modeleTable.setValueAt(charge.getDatePaiement(), numeroLigne, 3);
		if (charge.getImputableLocataire() == 1) {
			modeleTable.setValueAt("Oui", numeroLigne, 4);
		} else {
			modeleTable.setValueAt("Non", numeroLigne, 4);
		}

		modeleTable.setValueAt(charge.getMontant(), numeroLigne, 5);
		modeleTable.setValueAt(charge.getAccompteVerse(), numeroLigne, 6);
		modeleTable.setValueAt(charge.getMontant() - charge.getAccompteVerse(), numeroLigne, 7);
	}
	
	
	private void chargerChargesLogement() throws SQLException {
		List<Facture> factures = this.daoFacture.findFactureCharge();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableChargesLocatives().getModel();
		modeleTable.setRowCount(0); // Efface toutes les lignes existantes

		for (int i = 0; i < factures.size(); i++) {
			Facture f = factures.get(i);
			if (f != null && f.getBien() != null) {
				modeleTable.addRow(new Object[] { f.getBien().getIdBien(), f.getNumero(), f.getDesignation(),
						f.getDateEmission(), f.getDatePaiement(), f.getImputableLocataire(), f.getMontant(),
						f.getAccompteVerse(), f.getMontant() - f.getAccompteVerse(), });
			}
		}
	}

	private void updateTableChargesForLogement(String idLogement) throws SQLException {
		List<Facture> factures = this.daoFacture.findFactureChargeByLogement(idLogement);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableChargesLocatives().getModel();
		modeleTable.setRowCount(factures.size());

		for (int i = 0; i < factures.size(); i++) {
			Facture f = factures.get(i);
			this.ecrireLigneTableChargesLocatives(i, f);
		}
	}
	
	//---------------------------------------------------------//
	// Méthode pour filtrer les Charges par Id Logement
	private void filtreChargesByLogement() {
		JComboBox<String> comboBox_MesCharges = this.fenetreAccueil.getComboBox_MesChargesLocatives();
		String idLogementSelectionne = comboBox_MesCharges.getSelectedItem().toString();

		// Si l'ID selectionne est different de "ID du logement", filtrez la table
		// des charges
		if (!idLogementSelectionne.equals("ID du logement")) {
			try {
				this.updateTableChargesForLogement(idLogementSelectionne);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	

	///////////////////////////////////////////////////////////////////
	// LAYERED MES ASSURANCES
	// ////////////////////////////////////////////////////////////////

	// ------------------- TABLE ASSURANCES ------------------- //

	public void ecrireLigneTableAssurances(int numeroLigne, Assurance assurance, Entreprise entreprise,
			Echeance echeance) {
		JTable tableAssurances = this.fenetreAccueil.getTableAssurances();
		DefaultTableModel modeleTable = (DefaultTableModel) tableAssurances.getModel();

		modeleTable.setValueAt(assurance.getNuméroPolice(), numeroLigne, 0);
		modeleTable.setValueAt(assurance.getMontant(), numeroLigne, 1);
		modeleTable.setValueAt(echeance.getDateEcheance(), numeroLigne, 2);
		if (entreprise != null) {
			modeleTable.setValueAt(entreprise.getNom(), numeroLigne, 3);
			modeleTable.setValueAt(entreprise.getAdresse() + " " + entreprise.getCp() + " " + entreprise.getVille(),
					numeroLigne, 4);
			modeleTable.setValueAt(entreprise.getTelephone(), numeroLigne, 5);
		} else {
			// Si l'entreprise est null
			modeleTable.setValueAt("N/A", numeroLigne, 3);
			modeleTable.setValueAt("N/A", numeroLigne, 4);
			modeleTable.setValueAt("N/A", numeroLigne, 5);
		}
	}

	private void chargerAssurances() throws SQLException {
		List<Assurance> assurances = this.daoAssurance.findAll();

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableAssurances().getModel();
		modeleTable.setRowCount(assurances.size());

		for (int i = 0; i < assurances.size(); i++) {
			Assurance a = assurances.get(i);
			Entreprise entreprise = this.daoEntreprise.findById(a.getEntreprise().getSiret());
			Echeance echeance = this.daoEcheance.findById(a.getNuméroPolice());

			this.ecrireLigneTableAssurances(i, a, entreprise, echeance);
		}
	}

	private void updateTableAssurancesForLogement(String idLogement) throws SQLException {
		List<Assurance> assurancesLogement = this.daoAssurance.findByLogement(idLogement);

		DefaultTableModel modeleTable = (DefaultTableModel) this.fenetreAccueil.getTableAssurances().getModel();
		modeleTable.setRowCount(assurancesLogement.size());

		for (int i = 0; i < assurancesLogement.size(); i++) {
			Assurance assurance = assurancesLogement.get(i);
			Entreprise entreprise = this.daoEntreprise.findById(assurance.getEntreprise().getSiret());
			Echeance echeance = this.daoEcheance.findById(assurance.getNuméroPolice());

			this.ecrireLigneTableAssurances(i, assurance, entreprise, echeance);
		}
	}

	//---------------------------------------------------------------//
	// Methode pour filtrer les Asurances par Id Logement
	private void filtreAssuranceByLogement() {
		JComboBox<String> comboBox_MesAssurances = this.fenetreAccueil.getComboBox_MesAssurances();
		String idLogementSelectionne = comboBox_MesAssurances.getSelectedItem().toString();

		// Si l'ID selectionne est diffÃ©rent de "ID du logement", filtrez la table
		// des assurances
		if (!idLogementSelectionne.equals("ID du logement")) {
			try {
				this.updateTableAssurancesForLogement(idLogementSelectionne);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//NAVIGATION
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton btn = (JButton) source;
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
					this.chargerBiens();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			case "btnMesBiens_Supprimer":
				if (Sauvegarde.onSave("Immeuble") == true) {
					Immeuble immeubleSauvegarde = (Immeuble) Sauvegarde.getItem("Immeuble");
					Fenetre_SupprimerBien supp_bien = new Fenetre_SupprimerBien();
					this.fenetreAccueil.getLayeredPane().add(supp_bien);
					supp_bien.setVisible(true);
					supp_bien.moveToFront();
				} else {
					JOptionPane.showMessageDialog(this.fenetreAccueil, "Veuillez sÃ©lectionner un bien pour supprimer",
							"Erreur", JOptionPane.ERROR_MESSAGE);
				}

				break;

			case "btnMesBiens_Modifier":
				//////// POUR UN LOGEMENT --> BIEN (dans notre BDD) ///////////
				if (Sauvegarde.onSave("Logement") == true) {
					Fenetre_ModificationLogement modif_logement = new Fenetre_ModificationLogement();
					this.fenetreAccueil.getLayeredPane().add(modif_logement);
					modif_logement.setVisible(true);
					modif_logement.moveToFront();

					// On recupÃ¨re le logement de la sauvegarde
					Bien logementSauvegarde = (Bien) Sauvegarde.getItem("Logement");
					Bien logementCourant;

					try {
						logementCourant = this.daoBien.findById(logementSauvegarde.getIdBien());
						modif_logement.getTextField_IdLogement().setText(logementCourant.getIdBien());
						modif_logement.getTextField_SurfaceHabitable()
								.setText(Double.toString(logementCourant.getSurfaceHabitable()));
						modif_logement.getTextField_NbPièces().setText(Integer.toString(logementCourant.getNbPieces()));
						modif_logement.getTextField_DateAcquisition().setText(logementCourant.getDateAcquisition());
						modif_logement.getTextField_NumEtage().setText(Integer.toString(logementCourant.getNumEtage()));
						modif_logement.getComboBox_typeDeLogement().setSelectedItem(logementCourant.getType_bien());
						// voir comment potentiellement recuperer le compteur et les autres trucs
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					//////// POUR MODIFIER UN IMMEUBLE///////////
					// Premier test si il n'y a aucun immeuble sélectionné alors erreur
					if (Sauvegarde.onSave("Immeuble") == false) {
						JOptionPane.showMessageDialog(this.fenetreAccueil,
								"Veuillez sÃ©lectionner un bien pour modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						// On ouvre la fenÃªtre
						Fenetre_ModificationBien modif_bien = new Fenetre_ModificationBien();
						this.fenetreAccueil.getLayeredPane().add(modif_bien);
						modif_bien.setVisible(true);
						modif_bien.moveToFront();
						// permet de recuperer les infos sur l'immeuble courant pour les afficher
						// On récupère l'immeuble de la sauvegarde
						Immeuble immeubleSauvegarde = (Immeuble) Sauvegarde.getItem("Immeuble");
						Immeuble immeubleCourant;
						try {
							// A partir de l'ID de l'immeuble dans la sauvegarde on utilise la BD pour
							// récuperer l'immeuble le plus récent correspondant
							immeubleCourant = this.daoImmeuble.findById(immeubleSauvegarde.getImmeuble());
							// afficher les infos dans la page
							modif_bien.getTextField_IdImmeuble().setText(immeubleCourant.getImmeuble());
							modif_bien.getTextField_adresse().setText(immeubleCourant.getAdresse());
							modif_bien.getTextField_codePostal().setText(immeubleCourant.getCp());
							modif_bien.getTextField_ville().setText(immeubleCourant.getVille());
							modif_bien.getTextField_periodeDeConstruction()
									.setText(immeubleCourant.getPeriodeConstruction());
							modif_bien.getComboBox_typeDeBien().setSelectedItem(immeubleCourant.getType_immeuble());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				break;

			case "btnMesBiens_AjouterBien":
				Fenetre_InsertionBien insertion_bien = new Fenetre_InsertionBien();
				this.fenetreAccueil.getLayeredPane().add(insertion_bien);
				insertion_bien.setVisible(true);
				insertion_bien.moveToFront();
				break;
			case "btnMesBiens_AjouterPaiements": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE
													// LIGNE DU TABLEAU
				Fenetre_InsertionPaiementBien paiement_bien = new Fenetre_InsertionPaiementBien();
				this.fenetreAccueil.getLayeredPane().add(paiement_bien);
				paiement_bien.setVisible(true);
				paiement_bien.moveToFront();
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
			case "btnMesBiens_AjouterPaiements_Logements": // A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA
															// SELECTION D'UNE LIGNE DU TABLEAU
				Fenetre_InsertionPaiementLogement paiement_logement = new Fenetre_InsertionPaiementLogement();
				this.fenetreAccueil.getLayeredPane().add(paiement_logement);
				paiement_logement.setVisible(true);
				paiement_logement.moveToFront();
				break;

			///////////////////////
			// LAYERED MES LOCATIONS
			///////////////////////
			case "btn_MesLocations_Charger":
				try {
					this.chargerLocations();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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

			case "btn_mesLocations_InfoLocataire":
				if (Sauvegarde.onSave("Locataire") == true) {
					Fenetre_AffichageInfoLocataire infos_locataire = new Fenetre_AffichageInfoLocataire();
					this.fenetreAccueil.getLayeredPane().add(infos_locataire);
					infos_locataire.setVisible(true);
					infos_locataire.moveToFront();

					// On recupere le locataire de la sauvegarde
					Locataire locataireSauvgarde = (Locataire) Sauvegarde.getItem("Locataire");
					Locataire locataireCourant;

					try {
						locataireCourant = this.daoLocataire.findById(locataireSauvgarde.getIdLocataire());
						infos_locataire.getTextField_Id().setText(locataireCourant.getIdLocataire());
						infos_locataire.getTextField_Nom().setText(locataireCourant.getNom());
						infos_locataire.getTextField_Prenom().setText(locataireCourant.getPrenom());
						infos_locataire.getTextField_Telephone().setText(locataireCourant.getTelephone());
						infos_locataire.getTextField_Mail().setText(locataireCourant.getMail());
						infos_locataire.getTextField_DateN().setText(locataireCourant.getDateNaissance());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				break;
			/////////////////////
			// LAYERED MES TRAVAUX
			/////////////////////
			case "btn_Travaux_Modifier":
				break;
			case "btn_Travaux_Supprimer":
				Fenetre_SupprimerTravaux supp_travaux = new Fenetre_SupprimerTravaux();
				this.fenetreAccueil.getLayeredPane().add(supp_travaux);
				supp_travaux.setVisible(true);
				supp_travaux.moveToFront();
				break;

			///////////////////////////////
			// LAYERED MES CHARGES LOCATIVES
			///////////////////////////////
			case "btn_MesChargesLocatives_Modifier":
//			    if (Sauvegarde.onSave("Charge") && Sauvegarde.onSave("Logement")) {
//			        Fenetre_ModificationCharges modif_charge = new Fenetre_ModificationCharges();
//			        this.fenetreAccueil.getLayeredPane().add(modif_charge);
//			        modif_charge.setVisible(true);
//			        modif_charge.moveToFront();
//
//			        // On recupÃ¨re la charge de la sauvegarde
//			        Facture chargeSauvegarde = (Facture) Sauvegarde.getItem("Facture");
//
//			        // On recupÃ¨re le logement de la sauvegarde
//			        Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
//			        
//			        try {
//			            Bien bienCourant = this.daoBien.findById(bienSauvegarde.getIdBien());
//
//			            int deductibleValeur = 0; // Non dÃ©ductible par dÃ©faut
//
//			            // choix de la radio button
//			            if (modif_charge.getRdbtnAjouterChargeOui().isSelected()) {
//			                deductibleValeur = 1;
//			            } else if (modif_charge.getRdbtnAjouterChargeNon().isSelected()) {
//			                deductibleValeur = 0;
//			            }
//
//			            modif_charge.getTextField_nomCharge().setText(chargeSauvegarde.getNom());
//			            modif_charge.getTextField_montantPrevisionnel().setText(Double.toString(chargeSauvegarde.getMontantPrevisionnel()));
//			            modif_charge.getTextField_montantReel().setText(Double.toString(chargeSauvegarde.getMontantReel()));
//
//			            // Mise Ã  jour des boutons radio
//			            if (chargeSauvegarde.getImputableLocataire() == 1) {
//			                modif_charge.getRdbtnAjouterChargeNon().setSelected(true);
//			            } else {
//			                modif_charge.getRdbtnAjouterChargeOui().setSelected(true);
//			            }
//
//			        } catch (SQLException e1) {
//			            // GÃ©rer l'exception de maniÃ¨re appropriÃ©e (affichage d'un message Ã  l'utilisateur, etc.)
//			            e1.printStackTrace();
//			        }
//			    }
				break;

			case "btn_MesChargesLocatives_Supprimer":
				if (Sauvegarde.onSave("Charge") == true) {
					Facture chargeSauvegarde = (Facture) Sauvegarde.getItem("Facture");
					Fenetre_SupprimerFactureCharge supp_charge = new Fenetre_SupprimerFactureCharge();
					this.fenetreAccueil.getLayeredPane().add(supp_charge);
					supp_charge.setVisible(true);
					supp_charge.moveToFront();
				} else {
					JOptionPane.showMessageDialog(this.fenetreAccueil,
							"Veuillez sÃ©lectionner une charge pour supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				break;

			////////////////////////
			// LAYERED MES ASSURANCES
			////////////////////////
			case "btn_MesAssurances_Charger":
				try {
					this.chargerAssurances();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				Fenetre_SupprimerAssurance supp_assurance = new Fenetre_SupprimerAssurance();
				this.fenetreAccueil.getLayeredPane().add(supp_assurance);
				supp_assurance.setVisible(true);
				supp_assurance.moveToFront();
				break;

			// Coder la cas de la selection d'un id logement
			// parmi la liste prÃ©sente dans le JComboBox "comboBox_MesAssurances"

			////////////////////////////////////
			// LAYERED REGULARISATION DES CHARGES
			////////////////////////////////////

			// Coder la cas de la selection d'un locataire
			// parmi la liste prÃ©sente dans le JComboBox "comboBox_Regularisation"

			///////////////////////////
			// LAYERED SOLDE TOUT COMPTE
			///////////////////////////

			///////////////////////
			// LAYERED MES DOCUMENTS
			///////////////////////

			}
		} else if (source instanceof JToggleButton) {
			JToggleButton btnToggle = (JToggleButton) source;
			switch (btnToggle.getName()) {

			// ------------- MES TRAVAUX -------------//
			case "tglbtn_Travaux_immeubles":
				// Permet de trier le tableau de travaux en n'affichant que ceux concernants les
				// immeubles
				try {
					this.chargerTravauxImmeubles();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "tglbtn_Travaux_logements":
				// Permet de trier le tableau de travaux en n'affichant que ceux concernants les
				// logements
				try {
					this.chargerTravauxLogements();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			// ------------- MES CHARGES -------------//

			case "tglbtn_FactureCharge_biens":
				// Permet de trier le tableau de charges en n'affichant que ceux concernants les
				// immeubles
				try {
					this.chargerChargesLogement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			}

		}
		this.filtreAssuranceByLogement();
		this.filtreChargesByLogement();
	}
}