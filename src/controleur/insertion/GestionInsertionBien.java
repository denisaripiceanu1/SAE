package controleur.insertion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionBien implements ActionListener {
	
	private Fenetre_InsertionBien insertionBien;
	private DaoImmeuble daoImmeuble;
	private String idBien;
	
	public GestionInsertionBien(Fenetre_InsertionBien insertionBien) {
		this.insertionBien = insertionBien;
		this.daoImmeuble = new DaoImmeuble();
		this.idBien = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.insertionBien.getTopLevelAncestor(); //fenetre dans laquelle on ouvre des internal frame
		switch (btn.getText()) {
		case "Ajouter un compteur":
			this.idBien = insertionBien.getTextField_IdImmeuble().getText();
			Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur(this,(GestionInsertionLogement) null);
			fenetre_Principale.getLayeredPane().add(fenetreCompteur);
			fenetreCompteur.setVisible(true);
			fenetreCompteur.moveToFront();
			break;
		case "Ajouter":	
			try {
				Immeuble immeuble = new Immeuble(
						this.insertionBien.getTextField_IdImmeuble().getText(),
						this.insertionBien.getTextField_adresse().getText(), 
						this.insertionBien.getTextField_codePostal().getText(), 
						this.insertionBien.getTextField_ville().getText(), 
						this.insertionBien.getTextField_periodeDeConstruction().getText(), 
						Integer.parseInt(this.insertionBien.getTextField_nbLogement().getText()),
						this.insertionBien.getTextField_dateAcquisition().getText(),
						this.insertionBien.getComboBox_typeDeBien().getSelectedItem().toString()
				);
				
				this.daoImmeuble.create(immeuble);
//				Boite.deleteItem("Bien");
//				Boite.addItem("Bien", bien);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			break;
		case "Annuler":
			this.insertionBien.dispose();
			break;
		}
	}

	public String getIdBien() {
		return idBien;
	}	

}
