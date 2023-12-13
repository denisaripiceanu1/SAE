package controleur;

import java.sql.SQLException;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Bien;
import modele.Facture;
import modele.Immeuble;
import modele.Louer;
import modele.dao.DaoBien;
import modele.dao.DaoFacture;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLouer;
import vue.Fenetre_Accueil;

public class GestionLocations implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoLouer daoLouer;
	private DaoFacture daoFacture;


	public GestionLocations(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoLouer = new DaoLouer();
		this.daoFacture = new DaoFacture();
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

				if (location != null) {
                    Facture derniereFactureLoayer = null;
                    
                    try {
                    	
                    	derniereFactureLoayer = daoFacture.findDerniereFactureLoayer(location.getIdBien());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    JTable logements = fenetreAccueil.getTableLogementsParBien();
                    GestionAccueil.viderTable(logements);

                    DefaultTableModel model = (DefaultTableModel) logements.getModel();

                    // Assuming you know the number of columns in your logements table
                    int numColumns = 6; // Change this to the actual number of columns

                    // Ensure the table has enough rows
                    int numRowsNeeded = biens.size();
                    int currentRows = model.getRowCount();

                    for (int i = 0; i < numRowsNeeded - currentRows; i++) {
                        model.addRow(new Object[numColumns]);
                    }

                    // Now populate the table
                    for (int i = 0; i < biens.size(); i++) {
                        Bien bien = biens.get(i);
                        if (bien != null) {
                            String nom = bien.getIdBien();
                            double surface = bien.getSurfaceHabitable();
                            int nbPieces = bien.getNbPieces();
                            int etage = bien.getNumEtage();
                            String date = bien.getDateAcquisition();
                            int occupe = 0; // Traitement à faire plus tard 

                            model.setValueAt(nom, i, 0);
                            model.setValueAt(surface, i, 1);
                            model.setValueAt(nbPieces, i, 2);
                            model.setValueAt(etage, i, 3);
                            model.setValueAt(date, i, 4);
                            model.setValueAt(occupe, i, 5);
                        }
                    }
                }
            }
        }
    }
}
