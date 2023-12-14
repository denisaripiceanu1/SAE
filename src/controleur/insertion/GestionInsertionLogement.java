package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionCompteur;
import vue.insertion.Fenetre_InsertionLogement;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionLogement implements ActionListener {

	private Fenetre_InsertionLogement fil;
	private DaoBien daoBien;

	public GestionInsertionLogement(Fenetre_InsertionLogement fil) {
		this.fil = fil;
		this.daoBien = new DaoBien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter une quotité":
			Fenetre_InsertionQuotite insertion_quotite = new Fenetre_InsertionQuotite();
			fenetre_Principale.getLayeredPane().add(insertion_quotite);
			insertion_quotite.setVisible(true);
			insertion_quotite.moveToFront();
			break;

		case "Ajouter un compteur":
			Fenetre_InsertionCompteur insertion_compteur = new Fenetre_InsertionCompteur();
			fenetre_Principale.getLayeredPane().add(insertion_compteur);
			insertion_compteur.setVisible(true);
			insertion_compteur.moveToFront();
			break;

		case "Ajouter":
			Bien logement = null;
			try {
				String typeLogement = this.fil.getComboBox_typeDeLogement().getSelectedItem().toString();

				logement = new Bien(this.fil.getTextField_IdLogement().getText(),
						Double.parseDouble(this.fil.getTextField_SurfaceHabitable().getText()),
						Integer.parseInt(this.fil.getTextField_NbPièces().getText()),
						Integer.parseInt(this.fil.getTextField_NumEtage().getText()),
						this.fil.getTextField_DateAcquisition().getText(), typeLogement, (Immeuble) Sauvegarde.getItem("Immeuble"));
				
				this.daoBien.create(logement);
				//Potentiellement supprimer l'immeuble de la sauvegarde

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.fil.dispose();
			break;
		case "Annuler":
			this.fil.dispose();
			break;
		}
	}
}
