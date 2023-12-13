package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Bien;
import modele.Immeuble;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;

public class GestionLocations implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoLouer daoLouer;


	public GestionLocations(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoLouer = new DaoLouer();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = fenetreAccueil.getTableLocations().getSelectedRow();

			if (selectedRow > -1) {
				JTable tableLocations = fenetreAccueil.getTableLocations();
				Louer location = null;
				try {
					location = daoLouer.findById(tableLocations.getValueAt(selectedRow, 0).toString(),
							tableLocations.getValueAt(selectedRow, 1).toString(),
							tableLocations.getValueAt(selectedRow, 2).toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
}
