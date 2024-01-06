package controleur;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.outils.Sauvegarde;
import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.modification.Fenetre_ModificationAssurance;

public class GestionTableEntrepriseFenetreModificationAssurance implements ListSelectionListener {

    // Référence à la fenêtre d'insertion de paiement de logement
    private Fenetre_ModificationAssurance fma;

    // Accès à la couche d'accès aux données pour l'entité Entreprise
    private DaoEntreprise daoEntreprise;

    // Constructeur prenant en paramètre la fenêtre d'insertion de paiement de logement
    public GestionTableEntrepriseFenetreModificationAssurance(Fenetre_ModificationAssurance fma) {
        this.fma = fma;
        // Initialisation de l'accès à la base de données pour l'entité Entreprise
        this.daoEntreprise = new DaoEntreprise();
        // Initialisation de la sauvegarde
        Sauvegarde.initializeSave();
    }

    // Méthode appelée lorsqu'une sélection est modifiée dans la table d'entreprise
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Vérifie si l'événement de sélection a été finalisé
        if (!e.getValueIsAdjusting()) {
            // Récupère l'indice de la ligne sélectionnée dans la table d'entreprise
            int selectedRowEntreprise = this.fma.getTable_entreprise().getSelectedRow();

            // Vérifie si une ligne est effectivement sélectionnée
            if (selectedRowEntreprise > -1) {
                // Récupère la référence à la table d'entreprise
                JTable tableEntreprise = this.fma.getTable_entreprise();
                // Initialise une référence à l'objet Entreprise
                Entreprise entreprise = null;

                try {
                    // Récupère l'objet Entreprise à partir des données de la ligne sélectionnée dans la table
                    entreprise = this.daoEntreprise.findById(
                            tableEntreprise.getValueAt(selectedRowEntreprise, 0).toString(),
                            tableEntreprise.getValueAt(selectedRowEntreprise, 1).toString());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                // Supprime l'élément Entreprise précédemment sauvegardé et sauvegarde le nouvel élément
                Sauvegarde.deleteItem("Entreprise");
                Sauvegarde.addItem("Entreprise", entreprise);
            }
        }
    }
}
