package controleur;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.ICC;
import modele.dao.DaoBien;
import modele.dao.DaoICC;
import vue.insertion.Fenetre_InsertionLocation;

public class GestionTableLogementsFenetreLocation implements ListSelectionListener {

    private Fenetre_InsertionLocation fil;
    private DaoICC daoICC;

    public GestionTableLogementsFenetreLocation(Fenetre_InsertionLocation fil) {
        this.fil = fil;
        this.daoICC = new DaoICC();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            
                int selectedRowLogement = fil.getTable_liste_ICC().getSelectedRow();

                if (selectedRowLogement > -1) {
                    JTable tableICC = fil.getTable_liste_ICC();
                    ICC icc = null;
                    try {
                    	icc = daoICC.findById(tableICC.getValueAt(selectedRowLogement, 0).toString(), 
                    			tableICC.getValueAt(selectedRowLogement, 1).toString(),
                    			tableICC.getValueAt(selectedRowLogement, 2).toString());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    Sauvegarde.deleteItem("ICC");
                	Sauvegarde.addItem("ICC", icc);
                }
            }
        }
}  
