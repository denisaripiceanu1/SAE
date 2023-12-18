package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;

public class GestionTableLogement implements ListSelectionListener {

    private Fenetre_Accueil fenetreAccueil;
    private DaoBien daoBien;

    public GestionTableLogement(Fenetre_Accueil fenetreAccueil) {
        this.fenetreAccueil = fenetreAccueil;
        this.daoBien = new DaoBien();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            
                int selectedRowLogement = fenetreAccueil.getTableLogementsParBien().getSelectedRow();

                if (selectedRowLogement > -1) {
                    JTable tableLogement = fenetreAccueil.getTableLogementsParBien();
                    Bien bien = null;
                    try {
                        bien = daoBien.findById(tableLogement.getValueAt(selectedRowLogement, 0).toString());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    Sauvegarde.deleteItem("Logement");
                	Sauvegarde.addItem("Logement", bien);
                }
            }
        }
}  
