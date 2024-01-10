package controleur.insertion;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.dao.DaoCompteur;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageCompteursBien;

public class GestionTableAffichageCompteurs implements ListSelectionListener {
	
	private Fenetre_AffichageCompteursBien fenetreAffichageCompteursBiens;
	private DaoCompteur daoCompteur;

	public GestionTableAffichageCompteurs(Fenetre_AffichageCompteursBien fenetreAffichageCompteursBiens) {
		this.fenetreAffichageCompteursBiens = fenetreAffichageCompteursBiens;
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			// Vérifie si la sélection dans la table de logements a changé
			int selectedRowLogement = fenetreAccueil.getTableLogementsParBien().getSelectedRow();

			if (selectedRowLogement > -1) {
				// Si une ligne est sélectionnée
				JTable tableLogement = fenetreAccueil.getTableLogementsParBien();
				Bien bien = null;
				try {
					// Récupération de l'objet Bien associé à la ligne sélectionnée
					bien = daoBien.findById(tableLogement.getValueAt(selectedRowLogement, 0).toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// Mise à jour de la sauvegarde avec l'objet Bien sélectionné
				Sauvegarde.deleteItem("Logement");
				Sauvegarde.addItem("Logement", bien);
			}
		}
	}

}
