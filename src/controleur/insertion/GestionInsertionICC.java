package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.ICC;
import modele.Quotter;
import modele.dao.DaoICC;
import modele.dao.DaoQuotter;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionICC;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionICC implements ActionListener {

	private Fenetre_InsertionICC fii;
	private DaoICC daoICC;

	public GestionInsertionICC(Fenetre_InsertionICC fii) {
		this.fii = fii;
		this.daoICC = new DaoICC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fii.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			ICC icc = null;
			try {
				icc = new ICC(this.fii.getTextField_Annee().getText(), this.fii.getTextField_Trimestre().getText(),
						Double.parseDouble(this.fii.getTextField_indice().getText()));

				this.daoICC.create(icc);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.fii.dispose();
			break;
		case "Annuler":
			this.fii.dispose();
			break;
		}

	}

}
