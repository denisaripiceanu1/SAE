package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
