package controleur;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Bien;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;

public class GestionBienLogement implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;

	public GestionBienLogement(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	    if (!e.getValueIsAdjusting()) {
	        int selectedRow = fenetreAccueil.getTableBiens().getSelectedRow();

	        if (selectedRow > -1) {

	            JTable tableBiens = fenetreAccueil.getTableBiens();
	            Immeuble immeuble = null;
	            try {
	                immeuble = daoImmeuble.findById(tableBiens.getValueAt(selectedRow, 0).toString(),
	                        tableBiens.getValueAt(selectedRow, 1).toString(),
	                        tableBiens.getValueAt(selectedRow, 2).toString());
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }

	            if (immeuble != null) {

	                List<Bien> biens = null;
	                try {
	                    biens = daoBien.findBiensparImmeuble(immeuble.getImmeuble());
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }

	                JTable logements = fenetreAccueil.getTableLogementsParBien();
	                GestionAccueil.viderTable(logements);

	                for (int i = 0; i < biens.size(); i++) {
	                    String nom = biens.get(i).getIdBien();
	                    double surface = biens.get(i).getSurfaceHabitable();
	                    int nbPieces = biens.get(i).getNbPieces();
	                    int etage = biens.get(i).getNumEtage();
	                    String date = biens.get(i).getDateAcquisition();
	                    int occupe = 0; // changer

	                    if (biens.get(i) == null) {
	                        logements.setValueAt(null, i, 0);
	                        logements.setValueAt(null, i, 1);
	                        logements.setValueAt(null, i, 2);
	                        logements.setValueAt(null, i, 3);
	                        logements.setValueAt(null, i, 4);
	                        logements.setValueAt(null, i, 5);
	                    } else {
	                        logements.setValueAt(nom, i, 0);
	                        logements.setValueAt(surface, i, 1);
	                        logements.setValueAt(nbPieces, i, 2);
	                        logements.setValueAt(etage, i, 3);
	                        logements.setValueAt(date, i, 4);
	                        logements.setValueAt(occupe, i, 5);
	                    }
	                }
	            }
	        }
	    }
	}

}
