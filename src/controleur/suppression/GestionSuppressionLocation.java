package controleur.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Louer;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;
import vue.suppression.Fenetre_SupprimerLocation;

public class GestionSuppressionLocation implements ActionListener {

	private Fenetre_SupprimerLocation supprimerLocation;
	private DaoLouer daoLouer;

	public GestionSuppressionLocation(Fenetre_SupprimerLocation supprimerLocation) {
		this.supprimerLocation = supprimerLocation;
		this.daoLouer = new DaoLouer();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.supprimerLocation.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Supprimer":
			Louer louer_supp = (Louer) Sauvegarde.getItem("Louer"); // bien
			try {
				Louer louer = this.daoLouer.findById(louer_supp.getBien().getIdBien(),
						louer_supp.getLocataire().getIdLocataire(), louer_supp.getDateDebut());
				this.daoLouer.deleteVrai(louer);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.supprimerLocation.dispose();
			break;
		case "Annuler":
			this.supprimerLocation.dispose();
			break;
		}
	}

}
