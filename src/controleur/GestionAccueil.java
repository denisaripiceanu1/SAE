package controleur;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionDiagnostic;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionTravaux;

public class GestionAccueil implements ActionListener {
	
	private Fenetre_Accueil fenetreAccueil;
	
	public GestionAccueil(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
	}
	
	public void rendreVisible(JLayeredPane visible) {
		this.fenetreAccueil.getLayeredPane_Accueil().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesBiens().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesTravaux().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesChargesLocatives().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesLocations().setVisible(false);
		this.fenetreAccueil.getLayeredPane_MesAssurances().setVisible(false);
		this.fenetreAccueil.getLayeredPane_RegularisationDesCharges().setVisible(false);
		//this.fenetreAccueil.getLayeredPane_SoldeDeToutCompte().setVisible(false);
		//this.fenetreAccueil.getLayeredPane_MesDocuments().setVisible(false);

		visible.setVisible(true);
		this.fenetreAccueil.getContentPane().add(visible, BorderLayout.CENTER);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch (btn.getName()) { // a partir du nom des boutons
			//NAVIGATION ENTRE LES LAYEREDPANE
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
			//LAYERED MES BIENS
			///////////////////
			case "btnMesBiens_Charger":
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
			case "btnMesBiens_AjouterDiagnostic": //A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE LIGNE DU TABLEAU
				Fenetre_InsertionDiagnostic diagnostic_bien = new Fenetre_InsertionDiagnostic();
				this.fenetreAccueil.getLayeredPane().add(diagnostic_bien);
				diagnostic_bien.setVisible(true);
				diagnostic_bien.moveToFront();
				break;
			case "btnMesBiens_AjouterDesTravaux": //A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE LIGNE DU TABLEAU
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
			case "btnMesBiens_AjouterDiagnostic_Logements": //A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE LIGNE DU TABLEAU
				Fenetre_InsertionDiagnostic diagnostic_logement = new Fenetre_InsertionDiagnostic();
				this.fenetreAccueil.getLayeredPane().add(diagnostic_logement);
				diagnostic_logement.setVisible(true);
				diagnostic_logement.moveToFront();
				break;
			case "btnMesBiens_AjouterDesTravaux_Logements": //A MODIFIER POUR QUE L'OUVERTURE SOIT FAITES APRES LA SELECTION D'UNE LIGNE DU TABLEAU
				Fenetre_InsertionTravaux travaux_logement = new Fenetre_InsertionTravaux();
				this.fenetreAccueil.getLayeredPane().add(travaux_logement);
				travaux_logement.setVisible(true);
				travaux_logement.moveToFront();
				break;
			
			//LAYERED MES LOCATIONS
			//LAYERED MES TRAVAUX
			//LAYERED MES CHARGES LOCATIVES
			//LAYERED MES ASSURANCES
			case "btn_MesAssurances_Inserer":
				Fenetre_InsertionAssurance insertion_assurance = new Fenetre_InsertionAssurance();
				this.fenetreAccueil.getLayeredPane().add(insertion_assurance);
				insertion_assurance.setVisible(true);
				insertion_assurance.moveToFront();
				break;
			//LAYERED REGULARISATION DES CHARGES
			//LAYERED SOLDE TOUT COMPTE
			//LAYERED MES DOCUMENTS
	
		}
	}

}
