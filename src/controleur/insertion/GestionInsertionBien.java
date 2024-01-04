package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controleur.outils.Sauvegarde;
import modele.Compteur;
import modele.Immeuble;
import modele.dao.DaoCompteur;
import modele.dao.DaoImmeuble;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionBien;
import vue.insertion.Fenetre_InsertionCompteur;

public class GestionInsertionBien implements ActionListener {

    private Fenetre_InsertionBien insertionBien;
    private DaoImmeuble daoImmeuble;
    private DaoCompteur daoCompteur;

    public GestionInsertionBien(Fenetre_InsertionBien insertionBien) {
        this.insertionBien = insertionBien;
        this.daoImmeuble = new DaoImmeuble();
        this.daoCompteur = new DaoCompteur();
        Sauvegarde.initializeSave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.insertionBien.getTopLevelAncestor();
        switch (btn.getText()) {
            case "Ajouter un compteur":
                // Ouvrir la fenêtre d'insertion de compteur
                Fenetre_InsertionCompteur fenetreCompteur = new Fenetre_InsertionCompteur();
                
                // Créer temporairement l'immeuble pour pouvoir récupérer l'ID lors de la création du compteur
                Immeuble immeubleTemporaire = new Immeuble(
                        this.insertionBien.getTextField_IdImmeuble().getText(),
                        this.insertionBien.getTextField_adresse().getText(),
                        this.insertionBien.getTextField_codePostal().getText(),
                        this.insertionBien.getTextField_ville().getText(),
                        this.insertionBien.getTextField_periodeDeConstruction().getText(),
                        this.insertionBien.getComboBox_typeDeBien().getSelectedItem().toString());
                
                // Ajouter l'immeuble dans la sauvegarde pour réutilisation
                Sauvegarde.deleteItem("Immeuble");
                Sauvegarde.addItem("Immeuble", immeubleTemporaire);
                
                fenetre_Principale.getLayeredPane().add(fenetreCompteur);
                fenetreCompteur.setVisible(true);
                fenetreCompteur.moveToFront();
                break;
            case "Ajouter":
                try {
                    // Créer un nouvel immeuble avec les données de la fenêtre d'insertion
                    Immeuble nouvelImmeuble = new Immeuble(
                            this.insertionBien.getTextField_IdImmeuble().getText(),
                            this.insertionBien.getTextField_adresse().getText(),
                            this.insertionBien.getTextField_codePostal().getText(),
                            this.insertionBien.getTextField_ville().getText(),
                            this.insertionBien.getTextField_periodeDeConstruction().getText(),
                            this.insertionBien.getComboBox_typeDeBien().getSelectedItem().toString());

                    // Ajouter l'immeuble avant d'ajouter le compteur, sinon on ne peut pas créer un compteur sur un immeuble inexistant
                    this.daoImmeuble.create(nouvelImmeuble);
                    
                    // Ajouter le compteur de la sauvegarde qui est déjà relié à l'immeuble courant
                    if (Sauvegarde.onSave("Compteur")) {
                        this.daoCompteur.create((Compteur) Sauvegarde.getItem("Compteur"));
                        Sauvegarde.clearSave();
                    }
                    
                    // Fermer la fenêtre d'insertion après l'ajout
                    this.insertionBien.dispose();
                    
                    // Afficher un message de réussite
                    JOptionPane.showMessageDialog(insertionBien, "Le bien a été bien ajouté.", "Succès",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                break;

            case "Annuler":
                // Annuler l'opération, fermer la fenêtre d'insertion
                this.insertionBien.dispose();
                break;
        }
    }
}
