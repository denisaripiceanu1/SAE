package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import modele.dao.DaoLocataire;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionAffichageInfoLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire fail;
	private DaoLocataire daoLocataire;

	public GestionAffichageInfoLocataire(Fenetre_AffichageInfoLocataire fail) {
		this.fail = fail;
		this.daoLocataire = new DaoLocataire();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fail.getTopLevelAncestor();

		switch (btn.getText()) {
		case "Régularisation des charges ":
			this.fail.dispose();
			
			fenetre_Principale.getLayeredPane_RegularisationDesCharges();
			fenetre_Principale.getLayeredPane_RegularisationDesCharges().setVisible(true);
			break;

		case "Solde tout compte":
			break;
		}
	}

}
