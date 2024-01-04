package controleur.modification;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Entreprise;
import modele.Facture;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationFactureChargeLogement;

public class GestionModificationFacturesCharges implements ActionListener {

	private Fenetre_ModificationFactureChargeLogement modificationFacturesCharge;
	private DaoFacture daoFacture;
	private DaoBien daoBien;

	public GestionModificationFacturesCharges(Fenetre_ModificationFactureChargeLogement modificationCharge) {
		this.modificationFacturesCharge = modificationCharge;
		this.daoFacture = new DaoFacture();
		this.daoBien = new DaoBien();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource();

	    if (source instanceof JButton) {
	        // Handle JButton events
	        JButton btn = (JButton) source;
	        Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationFacturesCharge.getTopLevelAncestor();

	        switch (btn.getText()) {
	            case "Modifier":
	                // Handle "Modifier" button action
	                try {
	                    int imputable = 0;
	                    if (this.modificationFacturesCharge.getRdbtnOui().isSelected()) {
	                        imputable = 1;
	                    }

	                    Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
	                    Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

	                    Facture nouvelleCharge = new Facture(
	                            this.modificationFacturesCharge.getTextField_Numero().getText(),
	                            this.modificationFacturesCharge.getTextField_date_emission().getText(),
	                            this.modificationFacturesCharge.getTextField_date_paiement().getText(),
	                            this.modificationFacturesCharge.getComboBox_modePaiement().getSelectedItem().toString(),
	                            this.modificationFacturesCharge.getTextField_numeroDevis().getText(),
	                            this.modificationFacturesCharge.getComboBox_Designation().getSelectedItem().toString(),
	                            Double.parseDouble(this.modificationFacturesCharge.getTextField_accompteVerse().getText()),
	                            Double.parseDouble(this.modificationFacturesCharge.getTextField_montant().getText()),
	                            imputable, null, bienSauvegarde, entrepriseSauvegarde);

	                    this.daoFacture.update(nouvelleCharge);

	                    this.modificationFacturesCharge.dispose(); // Fermer la page après l'ajout

	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	                break;

	            case "Annuler":
	                // Handle "Annuler" button action
	                this.modificationFacturesCharge.dispose();
	                break;
	        }
	    } else if (source instanceof JComboBox) {
	        // Handle JComboBox events
	        JComboBox<?> comboBox = (JComboBox<?>) source;

	        // Add logic to handle events from JComboBox, if needed
	        System.out.println("JComboBox event: " + comboBox.getSelectedItem());
	    } else {
	        // Handle other unexpected event sources
	        System.out.println("Unexpected event source: " + source);
	    }
	}

}