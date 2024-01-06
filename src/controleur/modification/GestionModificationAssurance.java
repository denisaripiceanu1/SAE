package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Assurance;
import modele.Bien;
import modele.Echeance;
import modele.Entreprise;
import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoEcheance;
import vue.modification.Fenetre_ModificationAssurance;

public class GestionModificationAssurance implements ActionListener {

    private Fenetre_ModificationAssurance modificationAssurance;
    private DaoAssurance daoAssurance;
    private DaoBien daoBien;
    private DaoEcheance daoEcheance;

    public GestionModificationAssurance(Fenetre_ModificationAssurance modificationAssurance) {
        // Initialisation du gestionnaire pour la fenêtre de modification d'assurance
        this.modificationAssurance = modificationAssurance;
        // Initialisation de l'accès aux opérations de la base de données pour l'assurance, le bien et l'échéance
        this.daoAssurance = new DaoAssurance();
        this.daoBien = new DaoBien();
        this.daoEcheance = new DaoEcheance();
        // Initialisation de la sauvegarde (potentiellement non nécessaire ici, dépend du contexte)
        Sauvegarde.initializeSave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupération du bouton source de l'événement
        JButton btn = (JButton) e.getSource();

        switch (btn.getText()) {
            case "Modifier":
                Assurance assurance = null;
                Echeance echeance = null;

                try {
                    // Récupération du Bien et de l'Entreprise sauvegardés précédemment
                    Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
                    Entreprise entrepriseSauvegarde = (Entreprise) Sauvegarde.getItem("Entreprise");

                    // Recherche du Bien par son identifiant
                    Bien bien = daoBien.findById(bienSauvegarde.getIdBien());

                    // Création de l'objet Assurance avec les données de la fenêtre de modification
                    assurance = new Assurance(
                            this.modificationAssurance.getTextField_numPolice().getText(),
                            Float.parseFloat(this.modificationAssurance.getTextField_montant().getText()), bien,
                            entrepriseSauvegarde);

                    // Création de l'objet Echeance avec les données de la fenêtre de modification
                    echeance = new Echeance(assurance, this.modificationAssurance.getTextField_dateEcheance().getText());

                    // Mise à jour des données de l'assurance dans la base de données
                    this.daoAssurance.update(assurance);
                    // Mise à jour des données de l'échéance dans la base de données
                    this.daoEcheance.update(echeance);

                    // Fermeture de la fenêtre de modification après la mise à jour
                    this.modificationAssurance.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
                
            case "Annuler":
                // Fermeture de la fenêtre de modification sans effectuer de modification
                this.modificationAssurance.dispose();
                break;
        }
    }

}
