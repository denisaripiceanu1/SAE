package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Quotite;
import modele.Quotter;
import modele.dao.DaoQuotite;
import modele.dao.DaoQuotter;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionQuotite;

public class GestionInsertionQuotite implements ActionListener {

	private Fenetre_InsertionQuotite fiq;
	private DaoQuotite daoQuotite;

	public GestionInsertionQuotite(Fenetre_InsertionQuotite fiq) {
		this.fiq = fiq;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fiq.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Ajouter":
			Quotite quotite = null;
			try {
				DaoQuotter daoQuotter = new DaoQuotter();
				Quotter pourcentage = daoQuotter.findById(this.fiq.getTextField_Pourcentage().getText());

				String typeQuotite = (String) this.fiq.getComboBox_typeDeCompteur().getSelectedItem();

				quotite = new Quotite(typeQuotite, pourcentage);

				this.daoQuotite.create(quotite);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.fiq.dispose();
			break;
		case "Annuler":
			this.fiq.dispose();
			break;
		}

	}

}
