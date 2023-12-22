package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Facture;
import modele.Immeuble;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionPaiementLogement;

public class GestionInsertionPaiementLogement implements ActionListener{
	
	private Fenetre_InsertionPaiementLogement fipl;
	private DaoFacture daoFacture;
	
	public GestionInsertionPaiementLogement(Fenetre_InsertionPaiementLogement fit) {
		this.fipl = fit;
		this.daoFacture = new DaoFacture();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fipl.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
			case "Ajouter":
				
				try {
					int imputable = 0;
					if(this.fipl.getRdbtnOui().isSelected()) {
						imputable = 1;
					}
					
					Facture facture = new Facture(
							this.fipl.getTextField_Numero().getText(),
							this.fipl.getTextField_date_emission().getText(),
							this.fipl.getTextField_date_paiement().getText(),
							this.fipl.getComboBox_modePaiement().getSelectedItem().toString(),
							this.fipl.getTextField_numeroDevis().getText(),
							this.fipl.getComboBox_Designation().getSelectedItem().toString(),
							Double.parseDouble(this.fipl.getTextField_accompteVerse().getText()),
							Double.parseDouble(this.fipl.getTextField_montant().getText()),
							imputable,
							null /*Immeuble null*/,
							(Bien) Sauvegarde.getItem("Logement"),
							null); // INSERER UNE ENTREPRISE
					
					this.daoFacture.create(facture);
					
					this.fipl.dispose();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				break;
			case "Annuler":
				this.fipl.dispose();
				break;
			}
		// Ajoutez ceci à votre gestionnaire d'événements actionPerformed

		switch (this.fipl.getComboBox_Designation().getSelectedItem().toString()) {
	    case "Loyer":
	        // Afficher les composants liés à l'entreprise
	        this.fipl.getBtn_ajouter_entreprise().setVisible(true);
	        this.fipl.getBtn_charger_entreprise().setVisible(true);
	        this.fipl.getScrollPane_table_entreprise().setVisible(true);
	        this.fipl.getTable_entreprise().setVisible(true);
	        this.fipl.getLbl_Entreprise().setVisible(true);
	        break;
	    default:
	        // Masquer les composants liés à l'entreprise pour les autres options
	    	this.fipl.getBtn_ajouter_entreprise().setVisible(false);
	        this.fipl.getBtn_charger_entreprise().setVisible(false);
	        this.fipl.getScrollPane_table_entreprise().setVisible(false);
	        this.fipl.getTable_entreprise().setVisible(false);
	        this.fipl.getLbl_Entreprise().setVisible(false);
	        break;
	}

		}

	}
}