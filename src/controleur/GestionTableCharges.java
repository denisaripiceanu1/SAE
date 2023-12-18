package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Charge;
import modele.Immeuble;
import modele.dao.DaoBien;
import modele.dao.DaoCharge;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;

public class GestionTableCharges implements ListSelectionListener {

    private Fenetre_Accueil fenetreAccueil;
    private DaoCharge daoCharge;

    public GestionTableCharges(Fenetre_Accueil fenetreAccueil) {
        this.fenetreAccueil = fenetreAccueil;
        this.daoCharge = new DaoCharge();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRowCharge = fenetreAccueil.getTableChargesLocatives().getSelectedRow();

            if (selectedRowCharge > -1) {
                JTable tableCharges = fenetreAccueil.getTableChargesLocatives();
                Charge charge = null;
                try {
                    // Correction : Utilisez les entiers 1 et 0 pour deductible
                    int deductible = "Oui".equalsIgnoreCase(tableCharges.getValueAt(selectedRowCharge, 2).toString()) ? 1 : 0;
                    
                    charge = daoCharge.findById(
                    	    tableCharges.getValueAt(selectedRowCharge, 0).toString(), // nom
                    	    tableCharges.getValueAt(selectedRowCharge, 3).toString(), // montant_reel
                    	    tableCharges.getValueAt(selectedRowCharge, 4).toString(), // montant_previsionnel
                    	    tableCharges.getValueAt(selectedRowCharge, 2).toString(), // deductible
                    	    tableCharges.getValueAt(selectedRowCharge, 1).toString()  // Id_Bien
                    	);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                Sauvegarde.deleteItem("Charge");
                Sauvegarde.addItem("Charge", charge);
            }
        }
    }

}  
