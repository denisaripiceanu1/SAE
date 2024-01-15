package controleur;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Louer;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;

public class GestionTableArchiveLouer implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoLouer daoLouer;

	public GestionTableArchiveLouer(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		daoLouer = new DaoLouer();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			// Vérifie si la sélection dans la table de logements a changé
			int selectedRowLogement = fenetreAccueil.getTable_MesArchives_Louer().getSelectedRow();

			if (selectedRowLogement > -1) {
				// Si une ligne est sélectionnée
				JTable tableLouer = fenetreAccueil.getTable_MesArchives_Louer();
				Louer louer = this.daoLouer.find
//				try {
//					// Récupération de l'objet Bien associé à la ligne sélectionnée
//					bien = daoBien.findById(tableLogement.getValueAt(selectedRowLogement, 0).toString());
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
				// Mise à jour de la sauvegarde avec l'objet Bien sélectionné
				Sauvegarde.deleteItem("Logement");
				Sauvegarde.addItem("Logement", bien);
			}
		}
	}
}
