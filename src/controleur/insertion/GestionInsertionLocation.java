package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import modele.Bien;
import modele.Locataire;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoLocataire;
import controleur.outils.InsertionPDF;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionInsertionLocation implements ActionListener {

	private Fenetre_InsertionLocation fil;

	public GestionInsertionLocation(Fenetre_InsertionLocation fil) {
		this.fil = fil;
//		// Ajoutez un gestionnaire d'événements à lblNomEtatDesLieux
//		this.fil.getLblNomEtatDesLieux().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ouvrirPDF(fil.getLblNomEtatDesLieux().getText());
//			}
//		});
//
//		// Ajoutez un gestionnaire d'événements à lblNomBail
//		this.fil.getLblBail().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ouvrirPDF(fil.getLblBail().getText());
//			}
//		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fil.getTopLevelAncestor();
		switch (btn.getText()) {
		
		case "Ajouter un bail":
			InsertionPDF insertBail = new InsertionPDF();
			this.fil.getLayeredPane().add(insertBail);
			insertBail.setVisible(true);
			insertBail.moveToFront();
			break;

		case "Ajouter l'état des lieux":
			InsertionPDF insertEtat = new InsertionPDF();
			this.fil.getLayeredPane().add(insertEtat);
			insertEtat.setVisible(true);
			insertEtat.moveToFront();
			break;

		case "Ajouter":
			Louer location = null;
			try {
				DaoBien daoBien = new DaoBien();
				Bien bien = daoBien.findById(null);

				DaoLocataire daoLocataire = new DaoLocataire();
				Locataire locataire = daoLocataire.findById(null);

//				location = new Louer (
//						locataire,
//						bien,
//						this.fil.getTextField_date_arrivee().getText(),
//						null,/*nb de mois*/
//						Double.parseDouble(this.fil.getTextField_loyer().getText()),
//						Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
//						Double.parseDouble(this.fil.getTextField_caution().getText()),
//						bail,/*bail*/
//						etatLieux,/*etat des lieux*/
//						null,/*date de départ*/
//						null, /* loyer paye*/
//						this.fil.getTable_liste_locataires().getModel().getRowCount(),
//						null,/*montant reel payé*/
//						null,/*trimestre*/
//						null/*année*/
//						);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
//			Louer location = null;
//			try {
//				DaoBien daoBien = new DaoBien();
//				Bien bien = daoBien.findById(null);
//
//				DaoLocataire daoLocataire = new DaoLocataire();
//				Locataire locataire = daoLocataire.findById(null);
//
//				location = new Louer(locataire, bien, this.fil.getTextField_date_arrivee().getText(), null, /*
//																											 * nb de
//																											 * mois
//																											 */
//						Double.parseDouble(this.fil.getTextField_loyer().getText()),
//						Double.parseDouble(this.fil.getTextField_provision_sur_charges().getText()),
//						Double.parseDouble(this.fil.getTextField_caution().getText()), null, /* bail */
//						null, /* etat des lieux */
//						null, /* date de départ */
//						null, /* loyer paye */
//						this.fil.getTable_liste_locataires().getModel().getRowCount(), null, /* montant reel payé */
//						null, /* trimestre */
//						null/* année */
//				);
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
			break;
		case "Annuler":
			this.fil.dispose();
			break;
		}
	}

}
