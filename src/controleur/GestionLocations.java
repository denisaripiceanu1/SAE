package controleur;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modele.Facture;
import modele.Louer;
import modele.dao.DaoFacture;
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
                    location = daoLouer.findById(tableLocations.getValueAt(selectedRow, 1).toString(),
                            tableLocations.getValueAt(selectedRow, 0).toString());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                if (location != null) {
                    Facture derniereFactureLoyer = null;

                    try {
                    	derniereFactureLoyer = daoFacture.findDerniereFactureLoyer(location.getIdBien());

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    JTextField loyer = fenetreAccueil.getTextField_loyer();
                    loyer.setText(String.valueOf(location.getLoyerTTC()));

                    JTextField dateEmission = fenetreAccueil.getTextField_dateEmission();
                    // Vérification si la facture et sa date d'émission ne sont pas null
                    dateEmission.setText(derniereFactureLoyer != null ? derniereFactureLoyer.getDateEmission() : "");

                    JTextField dateEcheance = fenetreAccueil.getTextField_dateEcheance();
                    // Vérification si la facture et sa date de paiement ne sont pas null
                    dateEcheance.setText(derniereFactureLoyer != null ? derniereFactureLoyer.getDatePaiement() : "");

                    JTextField paye = fenetreAccueil.getTextField_paye();
                    paye.setText(String.valueOf(location.getMontantReelPaye()));

                    JTextField restantDu = fenetreAccueil.getTextField_restantDu();
                    restantDu.setText(String.valueOf(location.getLoyerTTC() + location.getProvision_chargeMens_TTC() - location.getMontantReelPaye()));

                    JTextField caution = fenetreAccueil.getTextField_caution();
                    caution.setText(String.valueOf(location.getCautionTTC()));

                    JTextField provision = fenetreAccueil.getTextField_provisionCharges();
                    provision.setText(String.valueOf(location.getProvision_chargeMens_TTC()));
                }
            }
        }
    }
}
