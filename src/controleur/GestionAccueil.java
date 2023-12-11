package controleur;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;

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
		case "btn_Accueil_AjouterBien":
			Fenetre_InsertionBien insertion_bien = new Fenetre_InsertionBien();
			this.fenetreAccueil.getLayeredPane().add(insertion_bien);
			insertion_bien.setVisible(true);
			insertion_bien.moveToFront();
			break;
		case "btn_MesAssurances_Inserer":
			Fenetre_InsertionAssurance insertion_assurance = new Fenetre_InsertionAssurance();
			this.fenetreAccueil.getLayeredPane().add(insertion_assurance);
			insertion_assurance.setVisible(true);
			insertion_assurance.moveToFront();
			break;

		}
	}

}
