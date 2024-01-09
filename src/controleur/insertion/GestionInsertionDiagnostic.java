package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Diagnostics;
import modele.dao.DaoDiagnostic;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_InsertionDiagnostic;

public class GestionInsertionDiagnostic implements ActionListener {

    private Fenetre_InsertionDiagnostic fid;
    private DaoDiagnostic daoDiagnostic;

    public GestionInsertionDiagnostic(Fenetre_InsertionDiagnostic fid) {
        this.fid = fid;
        this.daoDiagnostic = new DaoDiagnostic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fid.getTopLevelAncestor(); 

        switch (btn.getText()) {
            case "Ajouter":
                Diagnostics diagnostic = null;
                Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
                try {
                    // Créer un nouveau diagnostic avec les données de la fenêtre d'insertion
                    diagnostic = new Diagnostics(
                            this.fid.getTextField_Date_Validite().getText(),
                            this.fid.getTextField_Type().getText(), bienSauvegarde);

                    // Ajouter le nouveau diagnostic dans la base de données
                    int idSequence = this.daoDiagnostic.createAvecSequence(diagnostic);
                    // Attribue l'id de la séquence au diagnostic
                    diagnostic.setIdDiagnostic(idSequence);
                   
                    // Fermer la fenêtre d'insertion après l'ajout
                    this.fid.dispose();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                break;

            case "Annuler":
                // Annuler l'opération, fermer la fenêtre d'insertion
                this.fid.dispose();
                break;
        }
    }
}
