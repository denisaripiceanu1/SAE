package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
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
		this.daoQuotite = new DaoQuotite();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fiq.getTopLevelAncestor();
		switch (btn.getText()) {
			// Action lors du clic sur "Ajouter"
			case "Ajouter":
				Quotite quotite = null;
				try {
					// Récupération du pourcentage depuis la base de données
					DaoQuotter daoQuotter = new DaoQuotter();
					Quotter pourcentage = daoQuotter.findById(this.fiq.getTextField_Pourcentage().getText());

					// Récupération du type de quotité depuis l'interface graphique
					String typeQuotite = (String) this.fiq.getComboBox_typeDeCompteur().getSelectedItem();

					// Création de l'objet Quotite
					quotite = new Quotite(typeQuotite);

					// Ajout dans la sauvegarde pour le créer dans la page voulue
					Sauvegarde.deleteItem("Quotite");
					Sauvegarde.addItem("Quotite", quotite);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Fermeture de la fenêtre d'insertion de quotité après ajout
				this.fiq.dispose();
				break;
				
			// Action lors du clic sur "Annuler"
			case "Annuler":
				// Fermeture de la fenêtre d'insertion de quotité sans ajout
				this.fiq.dispose();
				break;
		}
	}
}
