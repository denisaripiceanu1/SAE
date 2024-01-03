package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Louer;
import modele.dao.DaoLouer;
import vue.modification.Fenetre_ModificationLocation;

public class GestionModificationLocation implements ActionListener {

	private Fenetre_ModificationLocation fml;
	private DaoLouer daoLouer;
	private Louer louerBD;

	public GestionModificationLocation(Fenetre_ModificationLocation fml) {
		this.fml = fml;
		this.daoLouer = new DaoLouer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		switch (btn.getText()) {
		case "Modifier":
			try {
				Louer louer = (Louer) Sauvegarde.getItem("Louer");
				louerBD = this.daoLouer.findById(louer.getBien().getIdBien(), louer.getLocataire().getIdLocataire());

				Louer louerM = new Louer(louerBD.getLocataire(), louerBD.getBien(),
						fml.getTextField_date_debut().getText(), louerBD.getNbMois(),
						Double.parseDouble(fml.getTextField_loyer_TCC().getText()),
						Double.parseDouble(fml.getTextField_provision_chargeMens_TTC().getText()),
						Double.parseDouble(fml.getTextField_caution_TTC().getText()), louerBD.getBail(),
						louerBD.getEtat_lieux(), fml.getTextField_date_depart().getText(),
						Integer.parseInt(fml.getTextField_loyer_paye().getText()), louerBD.getIcc(),
						Double.parseDouble(fml.getTextField_montant_reel_paye().getText()));

				this.daoLouer.update(louerM);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.fml.dispose();
			break;
		case "Annuler":
			this.fml.dispose();
			break;
		}
		// (Locataire locataire, Bien bien, String dateDebut, int nbMois, double
		// loyerTTC,
//		double provision_chargeMens_TTC, double cautionTTC, String bail, String etat_lieux, String dateDepart,
//		int loyerPaye, ICC icc, double montantReelPaye)
	}

}
