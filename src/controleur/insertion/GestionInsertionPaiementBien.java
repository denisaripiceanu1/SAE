package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.Entreprise;
import modele.Facture;
import modele.Immeuble;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionPaiementBien;
import vue.insertion.Fenetre_InsertionPaiementLogement;

public class GestionInsertionPaiementBien implements ActionListener{
	
	private Fenetre_InsertionPaiementBien fipb;
	private DaoFacture daoFacture;
	
	public GestionInsertionPaiementBien(Fenetre_InsertionPaiementBien fenetre_InsertionPaiementBien) {
		this.fipb = fenetre_InsertionPaiementBien;
		this.daoFacture = new DaoFacture();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fipb.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
			case "Ajouter":
				try {
					
					int imputable = 0;
					if(this.fipb.getRdbtnOui().isSelected()) {
						imputable = 1;
					}
					
					Facture facture = new Facture(
							this.fipb.getTextField_Numero().getText(),
							this.fipb.getTextField_date_emission().getText(),
							this.fipb.getTextField_date_paiement().getText(),
							this.fipb.getComboBox_modePaiement().getSelectedItem().toString(),
							this.fipb.getTextField_numeroDevis().getText(),
							this.fipb.getComboBox_Designation().getSelectedItem().toString(),
							Double.parseDouble(this.fipb.getTextField_accompteVerse().getText()),
							Double.parseDouble(this.fipb.getTextField_montant().getText()),
							imputable,
							(Immeuble) Sauvegarde.getItem("Immeuble"),
							null /*Bien null*/,
							null); // INSERER UNE ENTREPRISE
					
					this.daoFacture.create(facture);
					
					this.fipb.dispose();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case "Annuler":
				this.fipb.dispose();
				break;
			}
	}
}