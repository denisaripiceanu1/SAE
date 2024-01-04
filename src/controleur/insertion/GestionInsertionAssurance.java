package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Assurance;
import modele.Entreprise;
import modele.Bien;
import modele.dao.DaoAssurance;
import modele.dao.DaoEntreprise;
import modele.dao.DaoBien;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionAssurance;

public class GestionInsertionAssurance implements ActionListener {

    private Fenetre_InsertionAssurance fia;
    private DaoAssurance daoAssurance;

    public GestionInsertionAssurance(Fenetre_InsertionAssurance fia) {
        this.fia = fia;
        this.daoAssurance = new DaoAssurance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fia.getTopLevelAncestor();
        switch (btn.getText()) {
            case "Ajouter":
                // Création d'un objet Assurance
                Assurance assurance = null;
                try {
                    // Récupération des DAO nécessaires
                    DaoBien daoBien = new DaoBien();
                    DaoEntreprise daoEntreprise = new DaoEntreprise();
                    
                    // Recherche du Bien par son identifiant (à compléter avec la méthode correspondante)
                    Bien bien = daoBien.findById(/*à compléter*/);
                    
                    // Recherche de l'Entreprise par son SIRET
                    Entreprise entreprise = daoEntreprise.findById(this.fia.getTextField_SIRET().getText());

                    // Création de l'objet Assurance avec les données de la fenêtre d'insertion
                    assurance = new Assurance(
                            this.fia.getTextField_numPolice().getText(),
                            Float.parseFloat(this.fia.getTextField_montant().getText()),
                            bien, entreprise);

                    // Appel de la méthode DAO pour l'ajout de l'assurance dans la base de données
                    this.daoAssurance.create(assurance);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                // Fermeture de la fenêtre d'insertion après l'ajout
                this.fia.dispose();
                break;
            case "Annuler":
                // Annulation de l'opération, fermeture de la fenêtre d'insertion
                this.fia.dispose();
                break;
        }
    }
}
