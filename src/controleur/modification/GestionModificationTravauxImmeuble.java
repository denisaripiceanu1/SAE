package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Entreprise;
import modele.Facture;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationTravauxImmeuble;

public class GestionModificationTravauxImmeuble implements ActionListener {

	private Fenetre_ModificationTravauxImmeuble modificationTravauxImmeuble;
	private DaoFacture daoTravaux;
	private DaoEntreprise daoEntreprise;
	private Facture facture;
	private Entreprise entreprise;

	public GestionModificationTravauxImmeuble(Fenetre_ModificationTravauxImmeuble modificationTravauxImmeuble) {
		this.modificationTravauxImmeuble = modificationTravauxImmeuble;
		this.daoTravaux = new DaoFacture();
		this.daoEntreprise = new DaoEntreprise();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationTravauxImmeuble.getTopLevelAncestor();
		switch (btn.getText()) {
		case "Modifier":
			try {

				this.facture = this.daoTravaux
						.findById(this.modificationTravauxImmeuble.getTextField_Numero().getText());
				this.entreprise = this.daoEntreprise
						.findById(this.modificationTravauxImmeuble.getTextField_prestataire().getText());
				Facture nouvelFacture = new Facture(this.modificationTravauxImmeuble.getTextField_Numero().getText(),
						this.modificationTravauxImmeuble.getTextField_dateEmission().getText(),
						facture.getDatePaiement(), facture.getModePaiement(), facture.getNumeroDevis(),
						this.modificationTravauxImmeuble.getTextField_designation().getText(),
						facture.getAccompteVerse(),
						Double.parseDouble(this.modificationTravauxImmeuble.getTextField_montant().getText()),
						facture.getImputableLocataire(), facture.getImmeuble(), facture.getBien(), entreprise);

				this.daoTravaux.update(nouvelFacture);

				this.modificationTravauxImmeuble.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			break;
		case "Annuler":
			this.modificationTravauxImmeuble.dispose();
			break;
		}
	}

}
