package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Bien;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionCompteur implements ActionListener {

	private Fenetre_InsertionCompteur fic;
	private GestionInsertionBien gib;
	private GestionInsertionLogement gil;
	private DaoCompteur daoCompteur;
	
	public GestionInsertionCompteur(Fenetre_InsertionCompteur fic , GestionInsertionBien gib, GestionInsertionLogement gil) {
		this.fic = fic;
		this.gib = gib;
		this.gil = gil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fic.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			try {
				
				DaoImmeuble daoImmeuble = new DaoImmeuble();
				Immeuble immeuble = daoImmeuble.findById(this.gib.getIdBien()); //Le bien est l'immeuble dans la BD
				DaoBien daoBien = new DaoBien();
				Bien bien = daoBien.findById(null); //Le logement est un bien dans la BD
				
				Compteur compteur = new Compteur(
						this.fic.getTextField_IdCompteur().getText(),
						this.fic.getComboBox_typeDeCompteur().getSelectedItem().toString(),
						bien,
						immeuble
				);
				this.daoCompteur.create(compteur);
//				Boite.deleteItem("Bien");
//				Boite.addItem("Bien", bien);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			break;
		case "Annuler":
			this.fic.dispose();
			break;
		}

	}
}
