package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Quotite;
import modele.Quotter;
import modele.dao.DaoQuotite;
import modele.dao.DaoQuotter;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionICC;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionICC implements ActionListener {

	private Fenetre_InsertionICC fii;
	private DaoQuotite daoQuotite;

	public GestionInsertionICC(Fenetre_InsertionICC fii) {
		this.fii = fii;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fii.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			Quotite quotite = null;
			try {
				DaoQuotter daoQuotter = new DaoQuotter();
				Quotter pourcentage = daoQuotter.findById(this.fii.getTextField_Pourcentage().getText());

				String typeQuotite = (String) this.fii.getComboBox_typeDeCompteur().getSelectedItem();

				quotite = new Quotite(typeQuotite);

				this.daoQuotite.create(quotite);

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
